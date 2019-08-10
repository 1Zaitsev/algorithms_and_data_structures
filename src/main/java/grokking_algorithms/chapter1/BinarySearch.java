package grokking_algorithms.chapter1;

public class BinarySearch {

    public static void binarySearch(int[] array, int item){
        int min = 0;
        int max = array.length-1;
        int mid = (max+min)/2;

        int counter = 0;
        int result = -1;

        while (array[mid]!=item && min <= max) {
            ++counter;
            int guess = array[mid];

            if(guess > item){
                max = mid - 1;
                mid = (max+min)/2;
            }
            else if(guess < item){
                min = mid + 1;
                mid = (max+min)/2;
            }
        }
        if(array[mid] == item){
            ++counter;
            System.out.println("Число " + item + " найдена на позиции № " + mid + " c " + counter + " попытки");
        }
        else
            System.out.println("Число " + item + " не найдено. Выполнено" + counter + " попыток");
    }


    public static void main(String[] args) {
        int[] array = {1 , 23, 45, 67, 89, 101, 203, 356, 410};
        binarySearch(array, 1);
        binarySearch(array, 23);
        binarySearch(array, 45);
        binarySearch(array, 410);
        binarySearch(array, 100);
    }
}
