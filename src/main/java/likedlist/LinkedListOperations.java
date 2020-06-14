package likedlist;

public class LinkedListOperations {

    public static void main(String[] args) {
        /**
         * Create a Linked List and Print it.
         */
        System.out.println("Create a Linked List and Print it.");
        Node start = createLinkedList(10);
        printList(start);

        /**
         * Insert node at beginning of the list.
         */
        System.out.println("Insert node at beginning of the list.");
        Node newStart = insertNodeAtBeginningOfList(start, -1);
        printList(newStart);

        /**
         * Insert Node at the end of the list.
         */
        System.out.println("Insert Node at the end of the list.");
        Node newEnd = insertNodeAtTheEndOfList(start,10);
        printList(newEnd);

        /**
         * Remove Node at the head of the List.
         */
        System.out.println("Remove Node at the head of the List.");
        Node removedStart = removeNodeAtTheHeadOfTheList(start);
        printList(removedStart);

        /**
         * Remove Node matching a specified value.
         */
        System.out.println("Remove Node matching a specified value.");
        Node afterNodeRemoved = removeNodeMatchingVal(start,6);
        printList(afterNodeRemoved);
    }

    private static Node removeNodeMatchingVal(Node start,int val) {
        Node current = start;
        while(current.next != null && current.next.value != val) {
            current = current.next;
        }
        Node prev = current;
        Node toBeDeleted = current.next;
        prev.next = toBeDeleted.next;
        return start;
    }

    private static Node removeNodeAtTheHeadOfTheList(Node start) {
        Node newStart = start.next;
        return newStart;
    }

    private static Node insertNodeAtTheEndOfList(Node start,int val) {
        Node newNode = new Node(val);
        Node current =  start;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return start;
    }

    private static Node insertNodeAtBeginningOfList(Node start, int val) {
        Node newNode = new Node(val);
        newNode.next = start;
        return newNode;
    }

    private static Node createLinkedList(int n) {
        Node start = new Node(0);
        Node current = start;
        for (int i = 1; i < n; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        return start;
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
