package lesson2.classwork.array;

import java.util.*;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    protected E[] data;
    protected int size;

    public ArrayImpl(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity){
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkGrow();
        data[size++] = value;
    }

    protected void checkGrow() {
        if(size == data.length){
            data = Arrays.copyOf(data,size*2);
        }
    }

    @Override
    public boolean remove(E value) {
        int index =  indexOf(value);
        if(index != -1){
            return removeByIndex(index) != null;
        }
        return false;
    }

    @Override
    public E removeByIndex(int index) {
        checkIndex(index);

        E result = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[--size] = null;
        return result;
    }

    private void checkIndex(int index) {
        if (index >= 0 && index < size)
            return;

        throw new ArrayIndexOutOfBoundsException("Invalid index value: " + index + "; array size: " + data.length + ".");
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(value,data[i])){
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
    public int size() {
        return size;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
        System.out.println("____________");
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
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
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if(data[j].compareTo(data[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0){
                data[in] = data[in-1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}