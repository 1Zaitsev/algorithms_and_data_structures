package lesson2.homework;

import java.util.Random;

public class MainArray {
    public static void main(String[] args) {

        int arrayLength = 10000;
        Random random = new Random();
        ArrayInterface<Integer> array1 = new ArrayImpl<>(arrayLength);
        ArrayInterface<Integer> array2 = new ArrayImpl<>(arrayLength);
        ArrayInterface<Integer> array3 = new ArrayImpl<>(arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            int item = random.nextInt(arrayLength);
            array1.add(item);
            array2.add(item);
            array3.add(item);
        }

        array1.display();
        array2.display();
        array3.display();

        System.out.println("Bubble-sort time test ___________________________________________");
        long t = System.currentTimeMillis();
        array1.sortBubble();
        array1.display();
        long time1 = System.currentTimeMillis() - t;
        System.out.println("Result: " + time1);

        System.out.println("Select-sort time test ___________________________________________");
        t = System.currentTimeMillis();
        array2.sortSelect();
        array2.display();
        long time2 = System.currentTimeMillis() - t;
        System.out.println("Result: " + time2);

        System.out.println("Insert-sort time test ___________________________________________");
        t = System.currentTimeMillis();
        array3.sortInsert();
        array3.display();
        long time3 = System.currentTimeMillis() - t;
        System.out.println("Result: " + time3);
    }
}
