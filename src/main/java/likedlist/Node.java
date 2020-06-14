package likedlist;

public class Node {
    int value = 0;
    Node next;
    Node head;

    public void setNext(Node next) {
        this.next = next;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node(int value) {
        this.value = value;
    }
}
