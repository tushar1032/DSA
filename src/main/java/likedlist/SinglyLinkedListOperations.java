package likedlist;

import java.util.Random;

public class SinglyLinkedListOperations {

    public static void main(String[] args) {
        /**
         * Create a Linked List and Print it.
         */
        System.out.println("Create a Linked List and Print it.");
        Node start = createLinkedList(10, false, 0);
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
        Node newEnd = insertNodeAtTheEndOfList(start, 10);
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
        Node afterNodeRemoved = removeNodeMatchingVal(start, 6);
        printList(afterNodeRemoved);

        /**
         * Merge Sort a LinkedList.
         */
        System.out.println("Merge Sort a LinkedList.");
        Node l1 = createLinkedList(10, true, 100);
        System.out.println("List: ");
        printList(l1);
        Node sortedList = mergeSort(l1);
        System.out.println("Merged List: ");
        printList(sortedList);

        /**
         * Exchange Adjacent Nodes in a LinkedList.
         */
        System.out.println("Exchange Adjacent Nodes in a LinkedList.");
        Node list = createLinkedList(10, true, 100);
        System.out.println("List: ");
        printList(list);
        Node exchangedList = exchangeAdjacentNodes(list);
        System.out.println("Output: ");
        printList(exchangedList);

        /**
         * Check if a given list is palindrome.
         */
        System.out.println("Check if a given list is palindrome.");
        Node palindromeList = createEvenSizedPalindromeList(10);
        printList(palindromeList);
        boolean result = checkIfListIsPalindrome(palindromeList);
        System.out.println("Result: " + result);
        result = checkIfListIsPalindrome(list);
        printList(list);
        System.out.println("Result: " + result);

        /**
         * Reverse k blocks of nodes in a linkedList
         */
        System.out.println("Reverse k blocks of nodes in a linkedList");
        Node inputList = createLinkedList(10, true, 100);
        printList(inputList);
        Node reversedBlockList = reverseBlocks(inputList, 3);
        printList(reversedBlockList);

        /**
         * Rotate list to the right by k places.
         * Eg: 1 -> 2 -> 3 -> 4 -> 5 -> NULL, k = 2
         * Output: 4 -> 5 -> 1 -> 2 -> 3 -> NULL
         */
        System.out.println("Rotate list to the right by k places.");
        Node toBeRotatedList = createLinkedList(5, true, 100);
        printList(toBeRotatedList);
        Node rotatedList = rotateByKPlaces(toBeRotatedList, 2);
        printList(rotatedList);

        /**
         * Perform Addition of 2 numbers in LinkedList Form.
         * Eg: (3 -> 4 -> 3) + (5 -> 6 -> 4) = (8 -> 0 -> 8)
         */
        System.out.println("Perform Addition of 2 numbers in LinkedList Form.");
        Node num1 = createLinkedList(3, true, 9);
        Node num2 = createLinkedList(4, true, 9);
        System.out.println("Input 1");
        printList(num1);
        System.out.println("Input 2");
        printList(num2);
        System.out.println("Result");
        Node sum = addNumbers(num1, num2);
        printList(sum);

    }

    private static Node addNumbers(Node num1, Node num2) {
        if(num1 == null) {
            return num2;
        }
        if(num2 == null) {
            return num1;
        }
        Node res = new Node(-1);
        Node temp = res;
        int carry = 0;
        while (num1 != null && num2 != null) {
            int sum = num1.value + num2.value + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new Node(sum);
            temp = temp.next;
            num1 = num1.next;
            num2 = num2.next;
        }
        if (num1 != null) {
            if(carry != 0) {
                temp.next = addNumbers(num1, new Node(carry));
            }
            else {
                temp.next = num1;
            }

        } else if (num2 != null) {
            if(carry != 0) {
                temp.next = addNumbers(num2,new Node(carry));
            }
            else {
                temp.next = num2;
            }
        } else if(carry != 0) {
            temp.next = new Node(carry);
        }
        return res.next;
    }


    private static Node rotateByKPlaces(Node head, int k) {
        Node rotateStart = head;
        Node rotateEnd = head;
        while (k > 0) {
            if (rotateEnd.next != null) {
                rotateEnd = rotateEnd.next;
            } else {
                rotateEnd = head;
            }
            k--;
        }

        while (rotateEnd.next != null) {
            rotateStart = rotateStart.next;
            rotateEnd = rotateEnd.next;
        }

        Node startingPointForRotatedList = rotateStart.next;
        rotateStart.next = null;
        rotateEnd.next = head;

        return startingPointForRotatedList;
    }

    private static Node reverseBlocks(Node head, int k) {
        int count = k;
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null && count != 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }
        if (next != null) {
            head.next = reverseBlocks(next, k);
        }
        return prev;
    }


    private static boolean checkIfListIsPalindrome(Node node) {
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node reversedSecondHalf = reverseList(nextOfMiddle);

        while (node != middle && reversedSecondHalf != null) {
            if (node.value != reversedSecondHalf.value) {
                return false;
            }
            node = node.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        return true;
    }

    private static Node reverseList(Node node) {
        Node prev = null;
        Node next = null;
        Node current = node;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    private static Node createEvenSizedPalindromeList(int size) {
        if (size % 2 != 0) {
            size++;
        }
        int middle = size / 2;
        Node start = new Node(1);
        Node current = start;
        for (int i = 2; i <= middle; i++) {
            Node temp = new Node(i);
            current.next = temp;
            current = current.next;
        }
        for (int i = middle; i >= 1; i--) {
            Node temp = new Node(i);
            current.next = temp;
            current = current.next;
        }
        return start;
    }

    private static Node exchangeAdjacentNodes(Node node) {
        Node temp = new Node(-1);
        temp.next = node;
        Node current = temp;
        while (current.next != null && current.next.next != null) {
            Node firstNode = current.next;
            Node secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }
        return temp.next;
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = mergeLists(left, right);
        return sortedList;
    }

    private static Node getMiddle(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node fast = node;
        Node slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private static Node mergeLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node head = null;
        if (l1.value <= l2.value) {
            head = l1;
            head.next = mergeLists(head.next, l2);
        } else {
            head = l2;
            head.next = mergeLists(l1, head.next);
        }
        return head;
    }

    private static Node removeNodeMatchingVal(Node start, int val) {
        Node current = start;
        while (current.next != null && current.next.value != val) {
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

    private static Node insertNodeAtTheEndOfList(Node start, int val) {
        Node newNode = new Node(val);
        Node current = start;
        while (current.next != null) {
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

    private static Node createLinkedList(int n, boolean random, int upperBound) {
        Node start = new Node(1);
        Node current = start;
        Random rand = new Random();
        for (int i = 1; i < n; i++) {
            if (random)
                current.next = new Node(rand.nextInt(upperBound - 1) + 1);
            else
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
