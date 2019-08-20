package lesson2;

import lesson2.homework.ArrayImpl;
import lesson2.homework.ArrayInterface;
import org.junit.*;

public class ArrayImplTest {

    ArrayInterface<Integer> array;

    @Before
    public void init(){
        array = new ArrayImpl<>(5);

        array.add(6);
        array.add(2);
        array.add(4);
        array.add(1);
        array.add(5);
        array.add(3);
    }

    @Test
    public void add() {
        array.add(7);
        Assert.assertArrayEquals(new Integer[]{6,2,4,1,5,3,7}, array.asArray());
    }

    @Test
    public void removeByIndex() {
        array.removeByIndex(5);
        Assert.assertArrayEquals(new Integer[]{6,2,4,1,5}, array.asArray());

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeByIndex2() {
        Assert.assertEquals(new ArrayInterface[]{}, array.removeByIndex(-5));
    }

    @Test
    public void remove() {
        array.remove(3);
        Assert.assertArrayEquals(new Integer[]{6,2,4,1,5}, array.asArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(array.contains(1));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(2, array.indexOf(4));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(6, array.size());
    }

    @Test
    public void sortBubble() {
        array.sortBubble();
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6}, array.asArray());
    }

    @Test
    public void sortSelect() {
        array.sortSelect();
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6}, array.asArray());
    }

    @Test
    public void sortInsert() {
        array.sortInsert();
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5,6}, array.asArray());
    }
}
