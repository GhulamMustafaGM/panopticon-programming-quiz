
/**
 * Main class - Singly LinkedList.
 */

public class SingleLinkedListAddRemove {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(); // Initalized of Linked List

        linkedList.addLast(10);
        linkedList.addLast(22);
        linkedList.addLast(69);
        linkedList.addLast(13);
        linkedList.addLast(49);

        linkedList.displayLinkedList(); // Display LinkedList

        System.out.print("Removed Nodes: ");
        Node removedNode = linkedList.removeLast(); // Remove Node
        removedNode.displayNode(); // Display remove Node.
        removedNode = linkedList.removeLast(); // Remove Node
        removedNode.displayNode(); // Display remove Node.

        System.out.println();// System output used to format output
        linkedList.displayLinkedList(); // Again display LinkedList

    }
}

/*
 * Output:
 * 
 * Displaying LinkedList [first--->last]: 10 22 69 13 49
 * Removed Nodes: 49 13
 * Displaying LinkedList [first--->last]: 10 22 69
 */
