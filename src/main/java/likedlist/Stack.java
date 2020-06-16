package likedlist;

public class Stack {
    private Node HEAD;
    private Node TAIL;
    private int size;
    private int currentSize;

    public Stack(int size) {
        HEAD = new Node(0);
        TAIL = HEAD;
        this.size = size;
    }

    public void push(int val) {
        if (currentSize < size) {
            if (currentSize == 0) {
                HEAD.value = val;
            } else {
                Node newNode = new Node(val);
                TAIL.next = newNode;
                newNode.head = TAIL;
                TAIL = newNode;
            }
            currentSize++;
        } else {
            throw new RuntimeException("Stack Overflow!!!");
        }
    }

    public Node pop() {
        if (currentSize > 0) {
            Node popperNode = TAIL;
            TAIL.next = null;
            TAIL = TAIL.head;
            currentSize--;
            return popperNode;
        } else {
            throw new RuntimeException("Stack Underflow!!!");
        }
    }

    public void printStack() {
        Node printerNode = null;
        try {
            printerNode = HEAD.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.print(printerNode.value + " -> ");
        while (printerNode.next != null) {
            printerNode = printerNode.next;
            if (printerNode.next == null) {
                System.out.println(printerNode.value);
            } else {
                System.out.print(printerNode.value + " -> ");
            }
        }
        System.out.println();
    }
}
