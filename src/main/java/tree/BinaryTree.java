package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {

        /**
         * Pre-Order Traversal
         */
        System.out.println("Pre-Order Traversal");
        Node<Integer> binaryTree = createABinaryTree();
        preOrderTraversal(binaryTree);

        /**
         * In-Order Traversal
         */
        System.out.println();
        System.out.println("In-Order Traversal");
        inOrderTraversal(binaryTree);

        /**
         * Post-Order Traversal
         */
        System.out.println();
        System.out.println("Post-Order Traversal");
        postOrderTraversal(binaryTree);

        /**
         * Level Wise Traversal
         */
        System.out.println();
        System.out.println("Level Wise Traversal");
        levelWiseTraversal(binaryTree);

        /**
         * Max Element in a Binary Tree (Non Recursively)
         */
        System.out.println();
        System.out.println("Max Element in a Binary Tree (Non Recursively)");
        findMax(binaryTree);

        /**
         * Max Element in a Binary Tree (Recursively)
         */
        int max = findMaxRecursively(binaryTree);
        System.out.println("Max element in the tree is: " + max);
    }

    private static int findMaxRecursively(Node root) {
        int max = Integer.MIN_VALUE;
        if(root != null) {
            int leftMax = findMaxRecursively(root.left);
            int rightMax = findMaxRecursively(root.right);

            max = Math.max(leftMax,rightMax);
            max = Math.max((Integer) root.data,max);
        }
        return max;
    }

    private static void findMax(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            Node tmp = q.remove();
            if(tmp != null) {
                max = Math.max(max, (Integer) tmp.data);
                if(tmp.left != null) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        System.out.println("Max element in the tree is: " + max);
    }

    private static void levelWiseTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node tmp = q.remove();
            if(tmp != null) {
                System.out.print(tmp.data + " ");
                if(tmp.left != null) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
    }

    private static void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }


    private static Node<Integer> createABinaryTree() {
        Node<Integer> root = new Node<>(1);
        root.setLeft(2);
        root.setRight(3);
        root.left.setLeft(4);
        root.left.setRight(5);
        root.right.setLeft(6);
        root.right.setRight(7);
        return root;
    }

}
