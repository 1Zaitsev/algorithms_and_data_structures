package lesson3.classwork;

import lesson3.classwork.queue.PriorityQueue;
import lesson3.classwork.queue.Queue;
import lesson3.classwork.queue.QueueImpl;
import lesson3.classwork.stack.Stack;
import lesson3.classwork.stack.StackImpl;

public class Main3 {
    public static void main(String[] args) {

//        testStack();
        Queue<Integer> queue = new PriorityQueue<>(5);
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

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
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
}
