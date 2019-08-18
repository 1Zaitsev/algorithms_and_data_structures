package lesson3.homework;

import org.junit.*;

public class StackImplTest {

    Stack<Integer> stack;

    @Before
    public void init(){
        stack = new StackImpl<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    @Test
    public void push() {
        stack.push(5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, stack.asArray());
    }

    @Test
    public void push2() {
        stack.push(5);
        stack.push(6);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, stack.asArray());
    }

    @Test
    public void pop() {
        Assert.assertEquals(new Integer(4), stack.pop());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, stack.asArray());
    }

    @Test
    public void peek() {
        Assert.assertEquals(new Integer(4), stack.peek());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, stack.asArray());
    }
}
