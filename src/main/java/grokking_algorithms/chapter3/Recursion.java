package grokking_algorithms.chapter3;

public class Recursion {

    public static void countDown(int i){
        System.out.print(i + "\t");
        if(i<=0)
            return;
        else
            countDown(i-1);
    }

    public static int factorial(int i){
        if(i==1)
            return 1;
        else
            return i*factorial(i-1);
    }

    public static void lookForKey(Item item) {
        if(item.isBox()){
            lookForKey(new Item());
        }
        else if(item.isKey()){
            System.out.println("Key has been found!\n");
            return;
        }
    }


    public static void main(String[] args) {
        countDown(15);
        System.out.println(factorial(15));

        Item mainBox= new Item();
        mainBox.setKey(false); //это не обязательно
        mainBox.setBox(true);
        lookForKey(mainBox);
    }
}
