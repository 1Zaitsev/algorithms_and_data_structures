package lesson4.homework;

import lesson3.classwork.ICollection;

public interface SimpleLinkedList<E> extends ICollection {

    void insertFirst(E value);

    E removeFirst();

    E getFirstValue();

    Node<E> getFirst();

    boolean contains(E value);

    boolean remove(E value);

    void display();

    @Override
    default boolean isFull(){
        return false;
    }

    class Node<T>{
        public Node<T> next;
        public final T value;

        public Node(T value){
            this.value = value;
        }
    }
}
