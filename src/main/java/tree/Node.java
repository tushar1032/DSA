package tree;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public void setLeft(T val) {
        this.left = new Node<T>(val);
    }

    public void setRight(T val) {
        this.right = new Node<T>(val);
    }
}
