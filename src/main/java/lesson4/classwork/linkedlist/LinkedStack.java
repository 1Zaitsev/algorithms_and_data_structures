package lesson4.classwork.linkedlist;

import lesson3.classwork.stack.Stack;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedStack() {
        this.data = new SimpleLinkedListImpl<E>();
    }

    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
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
}
