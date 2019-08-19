package lesson4.classwork;

import lesson3.classwork.queue.Queue;
import lesson3.classwork.stack.Stack;
import lesson4.classwork.linkedlist.*;

public class Main4 {
    public static void main(String[] args) {
//        testLinkedList();
//        testStack();
//        testTwoSideLinkedList();
        testLinkedQueue();
    }

    private static void testLinkedList() {
        LinkedList<Integer> ll = new SimpleLinkedListImpl<>();

        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);

        System.out.println("Contains 2: " + ll.contains(2));
        System.out.println("Remove 2: " + ll.remove(2));
        System.out.println("Contains 2: " + ll.contains(2));
        System.out.println("Remove 2: " + ll.remove(2));

        System.out.println("Size is: " + ll.size());
        ll.display();

        while (!ll.isEmpty()){
            System.out.println(ll.removeFirst());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);


        System.out.println("The top of stack is: " + stack.peek());
        System.out.println("The stack size is: " + stack.size());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void testTwoSideLinkedList(){
        TwoSideLinkedList<Integer> tsll = new TwoSideLinkedListImpl<>();

        tsll.insertFirst(1);
        tsll.insertLast(2);
        tsll.insertFirst(3);
        tsll.insertLast(4);

        tsll.display();

        System.out.println("Contains 2: " + tsll.contains(2));
        System.out.println("Remove 2: " + tsll.remove(2));
        System.out.println("Contains 2: " + tsll.contains(2));
        System.out.println("Remove 2: " + tsll.remove(2));

        System.out.println("Size is: " + tsll.size());
        tsll.display();

        while (!tsll.isEmpty()) {
            System.out.println(tsll.removeFirst());
        }
    }

    private static void testLinkedQueue(){
        Queue<Integer> queue = new LinkedQueue<>();
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        queue.insert(4);
        queue.insert(6);
        queue.insert(5);

        System.out.println("The top of the queue is: " + queue.peek());
        System.out.println("The queue size is: " + queue.size());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
