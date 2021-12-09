// Implement the in-order printing of the tree traversal without recursion and stack.

// A binary tree Node has data, a pointer to left child, and a pointer to right child.
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class TreeWithoutRecursion {
    Node root;

    // Function to traverse a binary tree without recursion and without stack.
    void MorrisTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                
                // Set the inorder predecessor of current.
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                // Set current as right child of its inorder predecessoor.
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                // Set and revert the changes, 'if' part to restore the original tree i.e., fix the right child of predecessor.
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } // End of 'if' condition pre->right == NULL.

            } // End of if condition current->left == NULL.

        } // End of while
    }

    // Execute Code
    public static void main(String args[]) {
        /*
         * Input constructed binary tree
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */
        TreeWithoutRecursion tree = new TreeWithoutRecursion();
        // Node test cases numbers
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.MorrisTraversal(tree.root);
    }
}

/*
 * output:
 * 4 2 5 1 3
 * 
 */