package lesson3.homework;

public class Backward extends StackImpl {

    Stack<Character> msg;

    public Backward(String message){
        super(message.length());
        msg = new StackImpl<>(message.length());
        for (int i = 0; i < message.length(); i++) {
            msg.push(message.charAt(i));
        }
        while(!msg.isEmpty())
            System.out.print(msg.pop());

        System.out.println("");
    }
}
