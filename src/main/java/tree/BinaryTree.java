package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    private static int count = 0;

    private static int sum = 0;

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
        boolean isPresent = findElement(binaryTree, 5);
        System.out.println("Element is 5 present ?: " + isPresent);
        isPresent = findElement(binaryTree, 9);
        System.out.println("Element is 9 present ?: " + isPresent);

        /**
         * Print Elements Level Wise in Reverse Order.
         */
        System.out.println("Print Elements Level Wise in Reverse Order.");
        printElementsLevelWiseReverse(binaryTree);

        /**
         * Find the Depth of a tree. Also equal to the height of the tree.
         */
        System.out.println();
        System.out.println("Find the Depth of a tree. Also equal to height of the tree.");
        int depth = findDepth(binaryTree);
        System.out.println("Depth: " + depth);

        /**
         * Find the width of the tree.
         */
        System.out.println("Find the width of the tree.");
        int width = findWidth(binaryTree);
        System.out.println("Width: " + width);

        /**
         * Find the max Sum of a tree level wise.
         */
        System.out.println("Find the max Sum of a tree level wise.");
        int maxSumLevelWise = maxSumPerLevel(binaryTree);
        System.out.println("Max Sum per Level: " + maxSumLevelWise);

        /**
         * Find the number of Full Nodes. i.e; Nodes that have both children.
         */
        System.out.println("Find the number of Full Nodes. i.e; Nodes that have both children.");
        int numOfFullNodes = numOfFullNodes(binaryTree);
        System.out.println("Num of Full Nodes: " + numOfFullNodes);

        /**
         * Print every path from root to leaf.
         */
        System.out.println("Print every path from root to leaf.");
        pathOfRootToLeaf(binaryTree);

        /**
         * Mirror a binary tree.
         */
        System.out.println("Mirror a binary tree.");
        System.out.println("Before:");
        inOrderTraversal(binaryTree);
        treeMirror(binaryTree);
        System.out.println("After:");
        inOrderTraversal(binaryTree);
        System.out.println();

        /**
         * Create a Binary tree using inorder and preorder traversal.
         */
        System.out.println("Create a Binary tree using inorder and preorder traversal.");
        System.out.println("In Order: D,B,E,A,F,C");
        System.out.println("Pre Order: A,B,D,E,C,F");
        String[] preorder = {"A", "B", "D", "E", "C", "F"};
        String[] inorder = {"D", "B", "E", "A", "F", "C"};
        Node tree = buildBinaryTreeFromInOrderAndPreOrder(preorder, inorder);
        System.out.println("Inorder Traversal of the Resultant Tree");
        inOrderTraversal(tree);
        System.out.println();

        /**
         * Create a Binary tree using In Order and Post Order traversal.
         */
        System.out.println("Create a Binary tree using in Order and Post Order traversal.");
        System.out.println("In Order: D,B,E,A,F,C");
        System.out.println("Post Order: D,E,B,F,C,A");
        String[] postorder = {"D", "E", "B", "F", "C", "A"};
        Node tree2 = buildBinaryTreeFromInOrderAndPostOrder(postorder, inorder);
        System.out.println("Inorder Traversal of the Resultant Tree");
        inOrderTraversal(tree);
        System.out.println();

        /**
         * Find all the ancestors for a given Node in a Tree.
         */
        System.out.println("Find all the ancestors for a given Node in a Tree.");
        System.out.println("Given Tree InOrder: ");
        Node newTree = createABinaryTree();
        inOrderTraversal(newTree);
        System.out.println();
        System.out.println("Result: ");
        findAncestors(newTree, 7);

        /**
         * Find the LCA (Lowest Common Ancestor) of two nodes in a tree.
         */
        System.out.println("Find the LCA (Lowest Common Ancestor) of two nodes in a tree.");
        System.out.println("LCA of 4 and 6");
        Node result = findLCA(binaryTree, new Node(4), new Node(6));
        System.out.println(result.data);

        /**
         * Find the Shortest Distance between 2 Nodes in a BST. Assuming that both the nodes exist in the tree.
         */
        System.out.println("Find the Shortest Distance between 2 Nodes in a BST. Assuming that both the nodes exist in the tree.");
        int distance = findShortestDistanceBetweenNodesBST(getBST(), 5, 1);
        System.out.println("Distance between Node 3 and 5 is: " + distance);

        /**
         * Create a BST from a sorted array.
         */
        System.out.println("Create a BST from a sorted array.");
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node generatedTree = createBSTFromArray(a, 0, a.length - 1);
        System.out.println("Inorder Traversal of the new Tree");
        inOrderTraversal(generatedTree);
        System.out.println("\nPreorder Traversal of the new Tree");
        preOrderTraversal(generatedTree);
        System.out.println();

        /**
         * Find the kth smallest element in a BST.
         */
        System.out.println("Find the kth smallest element in a BST.");
        Node bst = getBST();
        Node kthSmallestElement = getKthSmallestElement(bst, 4);
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(bst);
        System.out.println();
        System.out.println("4th Smallest Element is: " + kthSmallestElement.data);

        /**
         * Another way of Finding the kth element in a bst without a static counter.
         */
        System.out.println("Another way of Finding the kth element in a bst without a static counter.");
        result = getKthSmallestElementWithoutStaticCounter(bst, 4);
        System.out.println("4th Smallest Element in a BST without static counter: " + result.data);

        /**
         * Find Floor of a number in a BST.
         */
        System.out.println("Find Floor of a number in a BST.");
        Node floor = findFloor(getBST(), null, 7);
        System.out.println("Floor of the 7 in the BST is: " + floor.data);

        /**
         * Find Ceil of a number in a BST.
         */
        System.out.println("Find Ceil of a number in a BST.");
        Node ceil = findCeil(getBST(), null, 5);
        System.out.println("Ceil of the 5 in the BST is: " + ceil.data);

        /**
         * Find Sum of all paths from root in a binary tree.
         */
        System.out.println("Find Sum of all paths from root in a binary tree.");
        int total = sumNumbers(getBSTForSum());
        System.out.println("Sum: " + total);

        /**
         * Find Min Depth of a tree.
         */
        System.out.println("Find Min Depth of a tree.");
        int minDepth = minDepth(getBST(), 0);
        System.out.println(minDepth);

        /**
         * Flatten a tree.
         */
        System.out.println("Flatten a tree.");
        Node flatRoot = flatten(getTree());
        inOrderTraversal(flatRoot);
    }

    private static Node getTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        Node lRoot = root.left;
        lRoot.left = new Node(3);
        lRoot.right = new Node(4);
        Node rRoot = root.right;
        rRoot.right = new Node(6);
        return root;
    }

    private static Node t;
    private static Node temp;
    public static Node flatten(Node root) {
        return helper(root);
    }

    public static Node helper(Node root) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
            return root;
        }

        Node left = helper(root.left);
        Node right = helper(root.right);

        if(left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;

        }

        return right != null ? right : left;
    }

    private static int minLength = Integer.MAX_VALUE;

    private static int minDepth(Node root, int pathLen) {
        if (root == null) {
            return 0;
        }
        pathLen++;
        if (root.left == null && root.right == null) {
            minLength = Math.min(pathLen, minLength);
        }
        minDepth(root.left, pathLen);
        minDepth(root.right, pathLen);
        return minLength;
    }


    private static Node getBSTForSum() {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        return root;
    }

    private static int sumNumbers(Node root) {
        sumNumberHelper(root, 0, new ArrayList<>());
        return sum;
    }

    public static void sumNumberHelper(Node root, int pathLen, List<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(pathLen, (Integer) root.data);
        pathLen++;
        if (root.left == null && root.right == null) {
            int num = 0;
            int c = pathLen - 1;
            for (int i = 0; i < pathLen; i++) {
                int multiplicant = (int) Math.pow(10, c);
                c--;
                num = num + arr.get(i) * multiplicant;
            }
            sum = sum + num;
        }

        sumNumberHelper(root.left, pathLen, arr);
        sumNumberHelper(root.right, pathLen, arr);
    }

    private static Node findFloor(Node root, Node prev, int k) {
        if (root == null) {
            return null;
        }
        Node left = findFloor(root.left, prev, k);
        if (left != null) {
            return left;
        }
        if ((Integer) root.data > k) {
            return prev;
        } else if ((Integer) root.data == k) {
            return root;
        }
        prev = root;
        return findFloor(root.right, prev, k);

    }

    private static Node findCeil(Node root, Node prev, int k) {
        if (root == null) {
            return null;
        }
        Node right = findCeil(root.right, prev, k);
        if (right != null) {
            return right;
        }
        if ((Integer) root.data < k) {
            return prev;
        } else if ((Integer) root.data == k) {
            return root;
        }
        prev = root;
        return findCeil(root.left, prev, k);
    }

    private static List<Node> inOrderAccumulation(Node root, List<Node> nodes) {
        if (root == null) {
            return null;
        }
        inOrderAccumulation(root.left, nodes);
        nodes.add(root);
        inOrderAccumulation(root.right, nodes);
        return nodes;
    }

    private static Node getKthSmallestElementWithoutStaticCounter(Node root, int k) {
        List<Node> nodes = new ArrayList<>();
        nodes = inOrderAccumulation(root, nodes);
        return nodes.get(k - 1);
    }

    private static Node getKthSmallestElement(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node left = getKthSmallestElement(root.left, k);
        if (left != null) {
            return left;
        }
        if (++count == k) {
            return root;
        }
        return getKthSmallestElement(root.right, k);
    }


    private static Node createBSTFromArray(int a[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(a[mid]);
        root.left = createBSTFromArray(a, start, mid - 1);
        root.right = createBSTFromArray(a, mid + 1, end);
        return root;
    }

    private static Node getBST() {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        Node l1 = root.left;
        l1.left = new Node(2);
        l1.left.left = new Node(1);
        l1.right = new Node(4);
        l1.right.right = new Node(5);
        return root;
    }

    private static int findDistanceFromRoot(Node<Integer> root, int a) {
        if (root.data == a) {
            return 0;
        } else if (root.data > a) {
            return 1 + findDistanceFromRoot(root.left, a);
        } else {
            return 1 + findDistanceFromRoot(root.right, a);
        }
    }

    private static int findShortestDistanceBetweenNodesBST(Node<Integer> root, int a, int b) {
        if (root == null) {
            return 0;
        }
        if (root.data > a && root.data > b) {
            return findShortestDistanceBetweenNodesBST(root.left, a, b);
        } else if (root.data < a && root.data < b) {
            return findShortestDistanceBetweenNodesBST(root.right, a, b);
        } else if ((root.data <= a && root.data >= b) || (root.data >= a && root.data <= b)) {
            return findDistanceFromRoot(root, a) + findDistanceFromRoot(root, b);
        } else {
            return 0;
        }
    }

    private static Node findLCA(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        if (root.data == a.data || root.data == b.data) {
            return root;
        }
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private static void findAncestors(Node root, int value) {
        findAncestors(root, new ArrayList<Integer>(), value, 0);
    }

    private static void findAncestors(Node root, List<Integer> nodes, int value, int len) {
        if (root == null) {
            return;
        }
        nodes.add(len, (Integer) root.data);
        len++;
        if ((Integer) root.data == value) {
            for (int i = 0; i < len; i++) {
                System.out.print(nodes.get(i) + " ");
            }
            return;
        }
        findAncestors(root.left, nodes, value, len);
        findAncestors(root.right, nodes, value, len);
    }

    private static Node<String> buildBinaryTreeFromInOrderAndPostOrder(String[] postorder, String[] inorder) {
        if (postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        return buildBinaryTreeFromInorderAndPostOrder(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static Node<String> buildBinaryTreeFromInorderAndPostOrder(String[] postorder, int postStart, int postEnd, String[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        String root = postorder[postEnd];
        Node<String> current = new Node<>(root);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (inorder[offset] == root) {
                break;
            }
        }
        current.left = buildBinaryTreeFromInorderAndPostOrder(postorder, postStart + offset - inStart - 1, postEnd - 1, inorder, inStart, offset - 1);
        current.right = buildBinaryTreeFromInorderAndPostOrder(postorder, postStart, postStart + offset - inStart, inorder, offset + 1, inEnd);
        return current;
    }


    private static Node<String> buildBinaryTreeFromInOrderAndPreOrder(String[] preorder, String[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildBinaryTreeFromInOrderAndPreOrder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static Node<String> buildBinaryTreeFromInOrderAndPreOrder(String[] preorder, int preStart, int preEnd, String[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        String root = preorder[preStart];
        Node<String> current = new Node<>(root);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (inorder[offset] == root) {
                break;
            }
        }
        current.left = buildBinaryTreeFromInOrderAndPreOrder(preorder, preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1);
        current.right = buildBinaryTreeFromInOrderAndPreOrder(preorder, preStart + offset - inStart + 1, preEnd, inorder, offset + 1, inEnd);
        return current;
    }

    private static void treeMirror(Node root) {
        if (root != null) {
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            treeMirror(root.left);
            treeMirror(root.right);
        }
    }

    private static void pathOfRootToLeaf(Node root) {
        List<Integer> path = new ArrayList<>();
        pathOfRootToLeaf(root, path, 0);
    }

    private static void pathOfRootToLeaf(Node root, List<Integer> path, int pathLen) {
        if (root == null) {
            return;
        }
        path.add(pathLen, ((Integer) root.data));
        pathLen++;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < pathLen; i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }
        pathOfRootToLeaf(root.left, path, pathLen);
        pathOfRootToLeaf(root.right, path, pathLen);
    }

    private static int numOfFullNodes(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int numOfFullNodes = 0;
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
            if (tmp.left != null && tmp.right != null) {
                numOfFullNodes++;
            }
        }
        return numOfFullNodes;
    }

    private static int maxSumPerLevel(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int maxSum = Integer.MIN_VALUE;
        int currentLevelSum = 0;
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp != null) {
                currentLevelSum += (Integer) tmp.data;
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            } else {
                maxSum = Math.max(maxSum, currentLevelSum);
                currentLevelSum = 0;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return maxSum;
    }

    private static int findWidth(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int width = 0;
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp != null) {
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            } else {
                width = Math.max(width, q.size());
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return width;
    }

    private static int findDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDept = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return leftDept >= rightDepth ? leftDept + 1 : rightDepth + 1;
    }

    private static void printElementsLevelWiseReverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Node>> levelWise = new ArrayList<>();
        List<Node> currentLevel = new ArrayList<>();

        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp != null) {
                currentLevel.add(tmp);
                if (tmp.left != null) {
                    q.add(tmp.left);

                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            } else {
                levelWise.add(new ArrayList<>(currentLevel));
                currentLevel.clear();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        int size = levelWise.size();
        for (int i = size - 1; i >= 0; i--) {
            levelWise.get(i).forEach(node -> System.out.print(node.data + " "));
        }
    }

    private static boolean findElement(Node root, int data) {
        if (root == null) {
            return false;
        }
        if ((Integer) root.data == data) {
            return true;
        }
        if (findElement(root.left, data)) {
            return true;
        }
        return findElement(root.right, data);
    }

    private static int findMaxRecursively(Node root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = findMaxRecursively(root.left);
            int rightMax = findMaxRecursively(root.right);

            max = Math.max(leftMax, rightMax);
            max = Math.max((Integer) root.data, max);
        }
        return max;
    }

    private static void findMax(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp != null) {
                max = Math.max(max, (Integer) tmp.data);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        System.out.println("Max element in the tree is: " + max);
    }

    private static void levelWiseTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            if (tmp != null) {
                System.out.print(tmp.data + " ");
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) {
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
