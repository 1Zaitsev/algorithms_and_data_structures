package lesson4.homework;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements SimpleLinkedList<E>, Iterable<E>{

    public Node<E> firstElement;
    public int size;

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
    public E getFirstValue() {
        return isEmpty()? null : firstElement.value;
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null){
            if(current.value.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null){
            if(current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if(current == null)
            return false;
        else if(current == firstElement)
            firstElement = current.next;
        else
            previous.next = current.next;

        size--;
        return true;
    }

    @Override
    public void display() {
        Node<E> current = firstElement;
        System.out.println("__________________");
        while (current != null) {
            System.out.println(current.value + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("__________________");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>(this) {
        };
    }

    class MyIterator<E> implements Iterator<E> {
        private SimpleLinkedList<E> linkedList;
        Node<E> current;
        Node<E> previous;

            public MyIterator(SimpleLinkedList<E> linkedList){
                this.linkedList = linkedList;
                current = (Node<E>) firstElement;
                Node<E> previous = null;
            }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
