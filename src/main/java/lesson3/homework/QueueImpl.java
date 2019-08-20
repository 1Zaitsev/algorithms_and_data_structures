package lesson3.homework;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;
    private int size;
    private final E[] data;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if(isFull())
            return false;

        if(tail == data.length - 1)
            tail = DEFAULT_TAIL;
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if(isEmpty())
            return null;
        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        else
            return data[head];
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
        return Arrays.copyOf(data, size);
    }
}
