package lesson5.homework;

public class Power {

    public double power(double number, int degree) {

        if (number == 0 && degree < 0)
            throw new ArithmeticException("Division by zero");

        if (number == 0)
            return 0;

        if (degree == 0)
            return 1;

        if (degree > 1)
            return number * power(number, degree - 1);
        else if (degree < 0)
            return 1 / (number * power(number, -degree - 1));
        else
            return number;

    }
}
