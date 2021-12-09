import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintingBinaryTree {

    private static Node<Integer> TestCases() {
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> x11 = new Node<Integer>(3);
        Node<Integer> x12 = new Node<Integer>(7);
        Node<Integer> x21 = new Node<Integer>(4);
        Node<Integer> x22 = new Node<Integer>(8);
        Node<Integer> x23 = new Node<Integer>(11);
        Node<Integer> x31 = new Node<Integer>(3);
        Node<Integer> x32 = new Node<Integer>(9);
        Node<Integer> x33 = new Node<Integer>(5);

        root.left = x11;
        root.right = x12;

        x11.left = x21;
        x11.right = x22;

        x12.right = x23;
        x22.left = x31;
        x22.right = x32;

        x23.left = x33;

        return root;
    }

    public static void main(String[] args) {

        PrintingTree.printNode(TestCases());

    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class PrintingTree {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = PrintingTree.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || PrintingTree.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        PrintingTree.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            PrintingTree.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int a = 1; a <= endgeLines; a++) {
            for (int b = 0; b < nodes.size(); b++) {
                PrintingTree.printWhitespaces(firstSpaces - a);
                if (nodes.get(b) == null) {
                    PrintingTree.printWhitespaces(endgeLines + endgeLines + a + 1);
                    continue;
                }

                if (nodes.get(b).left != null)
                    System.out.print("/");
                else
                    PrintingTree.printWhitespaces(1);

                PrintingTree.printWhitespaces(a + a - 1);

                if (nodes.get(b).right != null)
                    System.out.print("\\");
                else
                    PrintingTree.printWhitespaces(1);

                PrintingTree.printWhitespaces(endgeLines + endgeLines - a);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int a = 0; a < count; a++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(PrintingTree.maxLevel(node.left), PrintingTree.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}


/*
 * Output:
 * 
 * 2
 * / \
 * / \
 * / \
 * / \
 * 3 7
 * / \ \
 * / \ \
 * 4 8 11
 * / \ /
 * 3 9 5
 * 
 */
