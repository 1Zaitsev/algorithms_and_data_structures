package lesson5.classwork;

public class HelloBye {
    public static void main(String[] args) {
        hello("DM");
    }

    private static void hello(String name) {
        print("Hello, "+ name + "!");
        bye(name);
    }

    private static void bye(String name) {
        print("Good bye, "+ name + "!");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
