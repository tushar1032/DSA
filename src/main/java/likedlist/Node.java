package likedlist;

public class Node implements Cloneable {
    Object value = 0;
    Node next;
    Node head;

    public void setNext(Node next) {
        this.next = next;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node(Object value) {
        this.value = value;
    }

    public int getInt() {
        return (Integer) value;
    }

    public String getString() {
        return value.toString();
    }

    public Node clone() throws CloneNotSupportedException {
        return (Node) super.clone();
    }
}
