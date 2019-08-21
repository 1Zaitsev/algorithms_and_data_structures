package lesson4.homework;

import lesson3.homework.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LinkedQueue<E> implements Queue<E> {

    TwoSideLinkedList<E> data;

    public LinkedQueue() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return data.isFull();
    }

    @Override
    public E[] asArray(){
        return
        }

    }
}
