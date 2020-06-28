package likedlist;

import java.util.Random;

public class StackOperations {

    public static void main(String[] args) {
        /**
         * Infix to Postfix Expression.
         */
        String infix = "A*(B+C)+C";
        System.out.println("Infix: " + infix);
        String postFix = convertInfixToPostfix(infix);
        System.out.println("Postfix: " + postFix);

        /**
         * Reverse a Stack
         */
        System.out.println("Reverse a Stack");
        Stack<Integer> stack = createAnIntegerStack(5,25);
        System.out.println("Before:");
        stack.printStack();
        printStackReverse(stack);
        System.out.println("After:");
        stack.printStack();
    }

    private static void printStackReverse(Stack stack) {
        if(stack.isEmpty()) {
            return;
        }
        int tmp = (Integer) stack.pop();
        printStackReverse(stack);
        insertAtBottom(stack,tmp);
    }

    private static void insertAtBottom(Stack stack, int data) {
        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }
            int tmp = (Integer) stack.pop();
            insertAtBottom(stack,data);
            stack.push(tmp);
    }

    private static String convertInfixToPostfix(String expr) {
        Stack<Character> stack = new Stack<>(expr.length());
        StringBuilder postFix = new StringBuilder();
        for (Character c : expr.toCharArray()) {
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                postFix.append(c);
            } else {
                if (!stack.isEmpty() && c != ')' && !isHigherPrecedence(stack.peek(), c)) {
                    Character poppedOutOperator = stack.pop();
                    postFix.append(poppedOutOperator);
                    stack.push(c);
                } else if (c == ')') {
                    while (stack.peek() != '(') {
                        Character popperOutOperator = stack.pop();
                        postFix.append(popperOutOperator);
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                postFix.append(stack.pop());
            }
        }
        return postFix.toString();
    }

    private static boolean isHigherPrecedence(Character op1, Character op2) {
        switch (op1) {
            case '*':
                if (op2 == '+' || op2 == '-')
                    return false;
                else
                    return true;
            case '/':
                if (op2 == '+' || op2 == '-' || op2 == '*')
                    return false;
                else
                    return true;
            case '+':
            case '-':
            case '(':
                return true;
            default:
                throw new RuntimeException(new IllegalArgumentException(String.format("This is an unsupported operator {} in expr", op1)));
        }
    }

    private static Stack<Integer> createAnIntegerStack(int size, int upperBound) {
        Stack<Integer> stack = new Stack(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            stack.push(random.nextInt(upperBound));
        }
        return stack;
    }
}
