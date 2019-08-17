package lesson3.classwork.queue;

import lesson3.classwork.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}
