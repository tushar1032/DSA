package likedlist;

public class Node implements Cloneable {
    public Object value = 0;
    public Node next;
    public Node head;

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
