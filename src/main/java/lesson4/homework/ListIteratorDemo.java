package lesson4.homework;

public class ListIteratorDemo {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(5);
        linkedList.insertFirst(4);
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);

        linkedList.display();

        ListIterator<Integer> iterator = (ListIterator<Integer>) linkedList.iterator();

        iterator.reset(); // переход на первый элемент коллекции
        iterator.insertBefore(20);
        linkedList.display();

        iterator.next(); // переход к слеующему элементу
        iterator.insertAfter(30);
        linkedList.display();

    }
}
