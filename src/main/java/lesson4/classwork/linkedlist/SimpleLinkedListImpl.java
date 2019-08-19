package lesson4.classwork.linkedlist;

import jdk.nashorn.internal.ir.WhileNode;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Node<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = firstElement;
        firstElement = node;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;

        E value = firstElement.value;
        firstElement = firstElement.next;

        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;
        while (current != null) {
            if(current.value.equals(value))
                break;
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }
        else if(current == firstElement){
            firstElement = current.next;
        }
        else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if(current.value.equals(value))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("_____________________");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("_____________________");
    }

    @Override
    public E getFirstValue() {
        return firstElement!= null ? firstElement.value : null ;
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }
}
