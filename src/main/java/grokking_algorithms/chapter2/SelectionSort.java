package grokking_algorithms.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    static int counter;

    public static int  findMin(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);
        int minIndex = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            counter++;
            if (arrayList.get(i) < min) {
                min = arrayList.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
     public static ArrayList selectionSort(ArrayList<Integer> arrayList){
         ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();
         int iter = arrayList.size();

        for (int i = 0; i < iter; i++) {
            counter++;
            int min = findMin(arrayList);
            sortedArrayList.add(arrayList.get(min));
            arrayList.remove(min);
        }
        return sortedArrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        Random rnd = new Random();

        for (int i = 0; i < 15; i++) {
            test.add(rnd.nextInt(100));
        }
        System.out.println(Arrays.toString(test.toArray()));

        ArrayList<Integer> sortedTest = selectionSort(test);

        System.out.println(Arrays.toString(sortedTest.toArray()));
        System.out.println(counter);
    }
}
