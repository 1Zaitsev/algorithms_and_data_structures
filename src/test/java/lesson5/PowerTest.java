package lesson5;

import lesson5.homework.Power;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowerTest {

    @Parameterized.Parameters
            public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {5, 0, 1},
                {2, 2, 4},
                {-15, 1, -15},
                {5, -2, 0.04},
        });

    }

    double a;
    int b;
    double c;

    public PowerTest(double a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Power power;

    @Before
    public  void init() {
        power = new Power();
    }


    @Test
    public void test1(){
        Assert.assertEquals(c, power.power(a,b), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void test2(){
        Assert.assertEquals(4.0, power.power(0,-2), 0);
    }
}