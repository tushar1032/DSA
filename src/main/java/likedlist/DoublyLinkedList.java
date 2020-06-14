package likedlist;

public class DoublyLinkedList {
    public static void main(String[] args) {
        /**
         * Create a doubly LinkedList and Print it.
         */
        Node start = createLinkedList(10);
        printList(start);
        printlnListReversed(start);

    }

    private static Node createLinkedList(int n) {
        Node start = new Node(0);
        Node second = new Node(1);
        start.next = second;
        second.head = start;
        Node current = second;
        for (int i = 2; i < n; i++) {
            Node newNode = new Node(i);
            current.next = newNode;
            newNode.head = current;
            current = current.next;
        }

        return start;
    }

    private static void printlnListReversed(Node start) {
        System.out.println("Printing List Reversed.");
        while (start.next != null) {
            start = start.next;
        }
        while (start.head != null) {
            if (start.head == null) {
                System.out.print(start.value);
            } else {
                System.out.print(start.value + " <- ");
            }
            start = start.head;
        }
        System.out.print(start.value);
    }

    private static void printList(Node start) {
        System.out.print(start.value + " -> ");
        while (start.next != null) {
            start = start.next;
            if (start.next == null) {
                System.out.println(start.value);
            } else {
                System.out.print(start.value + " -> ");
            }
        }
    }
}
