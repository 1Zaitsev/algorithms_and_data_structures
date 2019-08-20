package lesson3.homework;

import java.util.Arrays;

public class DequeImpl<E> implements Deque<E>{

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;
    private int size;
    private final E[] data;

    @SuppressWarnings("unchecked")
    public DequeImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    private int head;
    private int tail;

    @Override
    public boolean insertLeft(E value) {
        if(isFull())
            return false;

        if(head == 0)
            head = data.length;

        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if(isFull())
            return false;

        if(tail == data.length - 1)
            tail = DEFAULT_TAIL;
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if(isEmpty())
            return null;
        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        if(isEmpty())
            return null;
        if(tail < 0)
            tail = data.length - 1;

        E value = data[tail--];
        size--;
        return value;
    }

    @Override
    public E peekLeft() {
        if(isEmpty())
            return null;
        else
            return data[head];
    }

    @Override
    public E peekRight() {
        if(isEmpty())
            return null;
        else
            return data[tail];
    }

    @Override
    public E[] asArray(){
        return Arrays.copyOf(data, size);
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
}
