package lesson5.homework;

public class Power {
    public static void main(String[] args) {

        float result = power(1000,-2);
        System.out.println(result);
    }

    private static float power(float number, int degree) {

        if(number == 0)
            return 0;

        if(degree == 0)
            return 1;

        if(degree > 1)
            return number*power(number,degree - 1);
        else if(degree < 0)
            return 1/(number*power(number, -degree -1));
        else
            return number;

    }
}
