package lesson4.homework;

import lesson3.homework.Stack;

public class LinkedStack<E> implements Stack<E> {

    private SimpleLinkedList<E> data;

    public LinkedStack() {
        this.data = new SimpleLinkedListImpl<>();
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
    public E[] asArray(){
        E[] array =(E[]) new Object[data.size()];
        int index = 0;
        ListIterator<E> iterator = (ListIterator<E>) data.iterator();
        while (iterator.hasNext()){
            array[index++] = iterator.next();
        }
        return array;
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
