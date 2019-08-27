package lesson6.classwork;

import lesson3.classwork.ICollection;

public interface Tree<E> extends ICollection {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    void display();

    void isBalanced();

    void traverse(TraverseMode mode);
}
