package lesson4;

import lesson4.homework.LinkedQueue;
import org.junit.*;

public class LinkedQueueTest {

    LinkedQueue<Integer> linkedQueue;

    @Before
    public void init(){
        linkedQueue  = new LinkedQueue<>();

        linkedQueue.insert(1);
        linkedQueue.insert(2);
        linkedQueue.insert(3);
        linkedQueue.insert(4);
    }

    @Test
    public void insert() {
        linkedQueue.insert(5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, linkedQueue.asArray());
    }

    @Test
    public void remove() {
        Assert.assertEquals(new Integer(1), linkedQueue.remove());
        Assert.assertArrayEquals(new Integer[]{2, 3, 4}, linkedQueue.asArray());
    }

    @Test
    public void peek() {
        Assert.assertEquals(new Integer(1), linkedQueue.peek());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, linkedQueue.asArray());
    }
}