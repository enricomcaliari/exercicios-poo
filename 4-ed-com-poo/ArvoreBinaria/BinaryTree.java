import java.util.NoSuchElementException;

public class BinaryTree {

    private static class BtNode {
        int value;
        BtNode left;
        BtNode right;

        BtNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private BtNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int value) {
        BtNode newNode = new BtNode(value);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        BtNode node = this.root;

        while (true) {
            if (value == node.value) {
                return;
            } else if (value < node.value) {
                if (node.left == null) {
                    node.left = newNode;
                    return;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    return;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public boolean exists(int val) {
        BtNode n = this.root;

        while (n != null) {
            if (val == n.value) {
                return true;
            } else if (val < n.value) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return false;
    }

    public int min() {
        if (this.root == null) {
            throw new NoSuchElementException("Error: empty tree");
        }

        BtNode n = this.root;
        while (n.left != null) {
            n = n.left;
        }
        return n.value;
    }

    public int max() {
        if (this.root == null) {
            throw new NoSuchElementException("Error: empty tree");
        }

        BtNode node = this.root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }
}