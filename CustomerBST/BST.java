import java.util.*;

public class BST {
    // NODE CLASS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected static class Node {
        private Customer element;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Customer x) {
            this.element = x;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public Node(Customer e, Node above, Node leftChild, Node rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;

        }

        public Customer getElement() {
            return element;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setElement(Customer e) {
            element = e;
        }

        public void setParent(Node parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node leftNode) {
            left = leftNode;
        }

        public void setRight(Node rightNode) {
            right = rightNode;
        }

    }

    // CONSTRUCTORS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected Node root = null;

    public BST() {
        root = null;
    }

    // MEMBER METHODS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public boolean isEmpty() {
        return (root == null);
    }

    // CLASS METHODS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static Customer findMax(BST tree) {
        if (tree.isEmpty()) {
            throw new EmptyStackException();
        }
        return findMax(tree.root);
    }

    private static Customer findMax(Node t) {
        if (t.right != null) {
            return findMax(t.right);
        }
        return t.element;
    }

    public static void Insert(BST tree, Customer x) {
        tree.root = Insert(x, tree.root);
    }

    private static Node Insert(Customer x, Node t) {
        if (t != null) {
            if (x.compareTo(t.element) < 0) {
                t.left = Insert(x, t.left);
            } else if ((x.compareTo(t.element) > 0)) {
                t.right = Insert(x, t.right);
            }
            return t;
        } else
            return new Node(x);
    }

    public static void delete(BST tree, Customer x) {
        if (tree.isEmpty()) {
            throw new EmptyStackException();
        }
        tree.root = delete(x, tree.root);
    }

    private static Node delete(Customer x, Node t) {
        if (t == null) {
            System.out.println("Not found.");
            return null;
        }
        if (x.compareTo(t.element) < 0) {
            t.left = delete(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = delete(x, t.right);
        } else {
            if (t.right == null) {
                return t.left;
            }
            if (t.left == null) {
                return t.right;
            }
            t.element = findMax(t.left);
            t.left = delete(t.element, t.left);
        }
        return t;
    }

    public static Customer search(BST tree, Customer key) {
        if (tree.isEmpty()) {
            throw new EmptyStackException();
        }
        return search(key, tree.root);
    }

    private static Customer search(Customer key, Node t) {
        if (t == null) {
            System.out.println("Not found.");
            return null;
        }
        if (t.element.compareTo(key) > 0) {
            return search(key, t.left);
        }
        if (t.element.compareTo(key) < 0) {
            return search(key, t.right);
        }
        return t.element;
    }

    // TRAVERSALLS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void InOrder(BST tree) {
        InOrder(tree.root);
    }

    private static void InOrder(Node t) {
        if (t != null) {
            InOrder(t.left);
            System.out.println(t.element.toString());
            InOrder(t.right);
        }
    }

    public void PreOrder() {
        PreOrder(root);
    }

    private void PreOrder(Node t) {
        if (t != null) {
            System.out.println(t.element.toString());
            PreOrder(t.left);
            PreOrder(t.right);
        }
    }

    public void PostOrder() {
        PostOrder(root);
    }

    private void PostOrder(Node t) {
        if (t != null) {
            PostOrder(t.left);
            PostOrder(t.right);
            System.out.println(t.element.toString());
        }
    }
}
