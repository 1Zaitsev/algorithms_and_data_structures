package lesson4;

import lesson4.homework.LinkedStack;
import org.junit.*;

public class LinkedStackTest {

    LinkedStack<Integer> linkedStack;

    @Before
    public void init(){
        linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
    }

    @Test
    public void push() {
        linkedStack.push(5);
        Assert.assertArrayEquals(new Integer[]{5, 4, 3, 2, 1}, linkedStack.asArray());
    }

    @Test
    public void push2() {
        linkedStack.push(5);
        linkedStack.push(6);
        Assert.assertArrayEquals(new Integer[]{6, 5, 4, 3, 2, 1}, linkedStack.asArray());
    }

    @Test
    public void pop() {
        Assert.assertEquals(new Integer(4), linkedStack.pop());
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, linkedStack.asArray());
    }

    @Test
    public void peek() {
        Assert.assertEquals(new Integer(4), linkedStack.peek());
        Assert.assertArrayEquals(new Integer[]{4, 3, 2, 1}, linkedStack.asArray());
    }
}