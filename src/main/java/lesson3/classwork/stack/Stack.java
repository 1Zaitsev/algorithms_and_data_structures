package lesson3.classwork.stack;

import lesson3.classwork.ICollection;

public interface Stack<E> extends ICollection {

    boolean push (E value);

    E pop();

    E peek();

}
