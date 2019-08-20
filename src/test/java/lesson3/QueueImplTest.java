package lesson3;

import lesson3.homework.Queue;
import lesson3.homework.QueueImpl;
import org.junit.*;

public class QueueImplTest {


    Queue<Integer> queue;

    @Before
    public void init(){
        queue = new QueueImpl<>(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
    }

    @Test
    public void insert() {
        queue.insert(5);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, queue.asArray());
    }

    @Test
    public void remove() {
        Assert.assertEquals(new Integer(1), queue.remove());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, queue.asArray());
    }

    @Test
    public void peek() {
        Assert.assertEquals(new Integer(1), queue.peek());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, queue.asArray());
    }
}