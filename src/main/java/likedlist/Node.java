package likedlist;

public class Node implements Cloneable {
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

    public Node clone() throws CloneNotSupportedException {
        return (Node) super.clone();
    }
}
