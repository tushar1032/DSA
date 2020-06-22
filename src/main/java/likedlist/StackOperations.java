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
