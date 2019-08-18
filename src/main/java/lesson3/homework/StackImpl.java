package lesson3.homework;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E> {

    private int size;
    private final E[] data;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
    }

    @Override
    public boolean push(E value) {
        if(isFull())
            return false;
        data[size++] = value;
        return false;
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
        return data[--size];
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public E[] asArray(){
        E[] result = Arrays.copyOf(data, size);
        return result;
    }
}
