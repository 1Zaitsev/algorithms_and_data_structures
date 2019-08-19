package lesson4.classwork.iterator;

import lesson4.classwork.linkedlist.LinkedList;
import lesson4.classwork.linkedlist.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            doAction(value);
        }

        int index = 0;
        while(index < array.length){
            int value = array[index++];
            doAction(value);
        }
        System.out.println("___________");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);

        LinkedList.Node<Integer> current = linkedList.getFirst();
        while(current != null) {
            Integer value = current.value;
            doAction(value);
            current = current.next;
        }

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            doAction(value);
        }

        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(1);
        jdkLinkedList.add(2);
        jdkLinkedList.add(3);

        Iterator<Integer> jdkiterator = jdkLinkedList.iterator();
        while (jdkiterator.hasNext()){
            Integer value = jdkiterator.next();
            doAction(value);
        }


    }



    private static void doAction(int value) {
        System.out.println(value);
    }
}
