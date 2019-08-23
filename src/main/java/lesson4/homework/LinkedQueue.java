package lesson4.homework;

import lesson3.homework.Queue;

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

    @SuppressWarnings("unchecked")
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
}
