package lesson2.homework;

import java.util.*;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements ArrayInterface<E> {

    protected int size;
    protected E[] data;

    public ArrayImpl(int initialCapacity){
        this.data = (E[])new Object[initialCapacity];
    }

    public ArrayImpl(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(E value) {
        checkGrow();
        data[size++] = value;

    }

    protected void checkGrow() {
        if(size == data.length)
            data = Arrays.copyOf(data,size*2);
    }

    @Override
    public E removeByIndex(int index) {
        checkIndex(index);
        E result = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i-1];
        }

        data[--size] = null;
        return result;
    }

    private boolean checkIndex(int index) {
        if(index >= 0 && index < size)
            return true;
        else{
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    @Override
    public boolean remove(E value) {
        if(indexOf(value) != -1)
            return removeByIndex(indexOf(value)) != null;
        return false;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(value.compareTo(data[i]) == 0){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(data[j].compareTo(data[j+1]) > 0){
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i+1; j < size; j++) {
                if(data[j].compareTo(data[min]) < 0)
                    min = j;
            }
            swap(min, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while(in > 0 && data[in - 1].compareTo(temp) >= 0){
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public E[] asArray(){
        E[] result = Arrays.copyOf(data, size);
        return result;
    }
}
