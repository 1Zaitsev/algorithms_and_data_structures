package lesson4.homework;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements SimpleLinkedList<E>{

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
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("__________________");
    }

    public void dispayAll(SimpleLinkedList<E> linkedList){
        System.out.println("_____________________________________");
        for(E value: linkedList){
            System.out.print(value + " ");
        }
        System.out.println("/n_______________________________________");
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

    private static class MyIterator<E> implements ListIterator<E> {
        private SimpleLinkedListImpl linkedList;
        Node current;
        Node<E> previous;

            public MyIterator(SimpleLinkedListImpl linkedList){
                this.linkedList = linkedList;
                reset();
            }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
                E nextValue = (E) current.value;
                previous = current;
                current = current.next;
            return nextValue;
        }

        @Override
        public void reset() {
            current = linkedList.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Node newItem = new Node(value);
            if(previous == null) {
                newItem.next = linkedList.firstElement;
                linkedList.firstElement = newItem;
                reset();
            }else{
                newItem.next = previous.next;
                previous.next = newItem;
                current = newItem;
            }
        }

        @Override
        public void insertAfter(E value) {
                Node newItem = new Node(value);
                if(linkedList.isEmpty()){
                    linkedList.firstElement = newItem;
                    current = newItem;
                }else{
                    newItem.next = current.next;
                    current.next = newItem;
                    next();
                }
        }
    }

}
