package lesson2.homework;

public interface ArrayInterface<E> {

     int DEFAULT_CAPACITY = 10;

     void add(E value);

     E removeByIndex(int index);
     boolean remove(E value);

     boolean contains(E value);

     int indexOf(E value);

     boolean isEmpty();

     void display();

     int size();

     void sortBubble();
     void sortSelect();
     void sortInsert();
}
