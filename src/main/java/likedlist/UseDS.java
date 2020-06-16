package likedlist;

import java.util.Random;

public class UseDS {

    public static void main(String[] args) {
        useStack();
    }

    private static void useStack() {
        Stack stack = new Stack(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(25));
        }
        for (int i = 0; i < 10; i++) {
            stack.pop();
            stack.printStack();
        }
    }
}
