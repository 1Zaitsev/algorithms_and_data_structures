package lesson3.homework;

import lesson3.classwork.ICollection;

public interface Deque<E> extends ICollection {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekLeft();

    E peekRight();

    E[] asArray();
}
