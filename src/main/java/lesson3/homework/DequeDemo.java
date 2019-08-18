package lesson3.homework;

public class DequeDemo {
    public static void main(String[] args) {

        Deque<Integer> dq = new DequeImpl<>(5);

        dq.insertLeft(1);
        dq.insertLeft(2);
        dq.insertLeft(3);
        dq.insertRight(4);
        dq.insertRight(5);

        while (!dq.isEmpty()) {
            System.out.println(dq.removeRight());
        }
    }
}
