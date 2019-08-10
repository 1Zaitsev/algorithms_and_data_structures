package grokking_algorithms.chapter4;

import java.util.Arrays;

public class DivideAndConquer {

    static int sum(int... array){
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

     static int recSum(int... array){
       if(array.length == 0){
           return 0;
       }else{
           return array[0] + recSum(Arrays.copyOfRange(array,1,array.length));
       }
    }

    static int count(int...array){
        return array.length;
    }

    static int recCount(int... array){
        if(array.length == 0){
            return 0;
        }else{
            return 1 + recCount(Arrays.copyOfRange(array,1,array.length));
        }
    }

    static int findMax(int... array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    static int recFindMax(int... array) {
        if (array.length == 1) {
            return array[0];
        } else {
            int max = recFindMax(Arrays.copyOfRange(array, 1, array.length));

            if (max > array[0])
                return max;
            else
                return array[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5,6,7,8));
        System.out.println(recSum(1,2,3,4,5,6,7,8));
        System.out.println(count(1,1,1,2,5,3,6,7,8,9,4));
        System.out.println(recCount(1,1,1,2,5,3,6,7,8,9,4));
        System.out.println(findMax(1,15,4,8,6,7,9,84,1,5,6,7,8,9));
        System.out.println(recFindMax(1,15,4,8,6,7,9,84,1,5,6,7,8,9));
    }
}
