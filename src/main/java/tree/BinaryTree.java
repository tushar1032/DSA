package tree;

import java.util.*;

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

        /**
         * Search an element in binary tree.
         */
        System.out.println("Search an element in binary tree.");
        boolean isPresent = findElement(binaryTree,5);
        System.out.println("Element is 5 present ?: " + isPresent);
        isPresent = findElement(binaryTree,9);
        System.out.println("Element is 9 present ?: " + isPresent);

        /**
         * Print Elements Level Wise in Reverse Order.
         */
        System.out.println("Print Elements Level Wise in Reverse Order.");
        printElementsLevelWiseReverse(binaryTree);

        /**
         * Find the Depth of a tree.
         */
        System.out.println();
        System.out.println("Find the Depth of a tree.");
        int depth = findDepth(binaryTree);
        System.out.println("Depth: " + depth);

        /**
         * Find the Deepest Node in the Tree.
         */
        findTheDeepestNode(binaryTree);
    }

    private static int findTheTotalNumOfFullNodes(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

    }

    private static void findTheDeepestNode(Node root) {
        if(root == null) {
            System.out.println("Root is null");
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node tmp = null;
        while(!q.isEmpty()) {
            tmp = q.remove();
            if(tmp != null) {
                if(tmp.left != null) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        System.out.println("Deepest Node: " + tmp.data);

    }

    private static int findDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int leftDept = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return leftDept >= rightDepth?leftDept + 1 : rightDepth + 1;
    }

    private static void printElementsLevelWiseReverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Node>> levelWise = new ArrayList<>();
        List<Node> currentLevel = new ArrayList<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node tmp = q.remove();
            if(tmp != null) {
                currentLevel.add(tmp);
                if(tmp.left != null) {
                    q.add(tmp.left);

                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            else {
                levelWise.add(new ArrayList<>(currentLevel));
                currentLevel.clear();
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        int size = levelWise.size();
        for(int i = size-1;i >= 0;i--) {
            levelWise.get(i).forEach(node -> System.out.print(node.data + " "));
        }
    }

    private static boolean findElement(Node root,int data) {
        if(root == null) {
            return false;
        }
        if((Integer) root.data == data) {
            return true;
        }
        if(findElement(root.left,data)) {
            return true;
        }
        return findElement(root.right,data);
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
