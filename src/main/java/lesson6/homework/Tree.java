package lesson6.homework;

import lesson3.classwork.ICollection;

public interface Tree<E> extends ICollection {

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isBalanced();

    void display();

    enum TraverseMode{
        IN_ORDER,               //leftChild-parent-rightChild
        PRE_ORDER,              //parent-leftChild-rightChild
        POST_ORDER,             //leftChild-rightChild-parent
    }

    void traverse(TraverseMode mode);
}
