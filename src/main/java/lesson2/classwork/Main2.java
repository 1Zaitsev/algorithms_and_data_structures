package lesson2.classwork;

import lesson2.classwork.array.Array;
import lesson2.classwork.array.ArrayImpl;
import lesson2.classwork.array.SortedArrayImpl;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

//        testArray();

        Array<Integer> array = new ArrayImpl<>(5);
//        Array<Integer> array = new SortedArrayImpl<>();
        array.add(2);
        array.add(3);
        array.add(1);
        array.add(6);
        array.add(5);
        array.add(4);

        array.display();
//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
        array.display();


        System.out.println("Find 6: " + array.indexOf(6));
        System.out.println("Find 66: " + array.indexOf(66));

        array.remove(6);
        System.out.println("Find 6: " + array.indexOf(6));
        array.display();




    }

    private static void testArray() {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        int[] b =new int[] {1,2,3};
        int[] c = {1,2,3};

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        System.out.println("________________");

        for (int i: c) {
            System.out.println(i);
        }
        System.out.println("________________");

        Arrays.stream(c).forEach(System.out::println);
        Arrays.stream(c).forEach(value -> System.out.println(value));
    }
}