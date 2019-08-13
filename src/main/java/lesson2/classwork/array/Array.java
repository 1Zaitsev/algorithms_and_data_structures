package lesson2.classwork.array;

public interface Array<E> {

    int DEFAULT_CAPACITY = 16;

    void add(E value);

    boolean remove(E value);
    E removeByIndex(int index);

    boolean contains(E Value);

    int indexOf(E value);

    boolean isEmpty();

    int size();

    void display();


    default void addAll(E...values){
        for (E value: values){
            add(value);
        }
    }

    void sortBubble();

    void sortSelect();

    void sortInsert();

}
