// Implement a single linked list with add and remove methods. 

//  Set exception if Singly LinkedList is empty.
class SingleLinkedList extends RuntimeException {
    public SingleLinkedList() {
        super();
    }

    public SingleLinkedList(String message) {
        super(message);
    }
}

// Defined Node class, which holds data and contains next which points to next Node.
class Node {
    public int data; // set data in Node.
    public Node next; // set points to next Node in list.

    // Initialized constructor
    public Node(int data) {
        this.data = data;
    }

    // Display Node's data
    public void displayNode() {
        System.out.print(data + " ");
    }
}

// Singly LinkedList class
class LinkedList {
    private Node first; // ref to first link on list

    // LinkedList constructor
    public LinkedList() {
        first = null;
    }

    // Added new Node at last of Singly LinkedList.
    public void addLast(int data) {
        Node newNode = new Node(data); // Initialization of New Node.

        if (first == null) { // If LinkedList is empty, make first point to new Node.
            first = newNode; // first ---> newNode
            return;
        }

        Node tempNode = first; // Save reference to first Node in tempNode- so that we could return saved
                               // reference.
        while (tempNode.next != null) { // Executes until we don't find last Node of LinkedList.
                                        // If next of some Node is pointing to null, that means it's a last Node.
            tempNode = tempNode.next; // It move to next Node.
        }
        tempNode.next = newNode; // It make last's Node next point to new Node
    }

    
    // It removes last Node from Singly LinkedList
    public Node removeLast() {

        // Case1: when there is no value in LinkedList
        if (first == null) { // means LinkedList in empty, throw exception.
            throw new SingleLinkedList("LinkedList doesn't contain any Nodes.");
        }

        // Case2: when there is only one element in LinkedList
        if (first.next == null) { // It means LinkedList consists of only one element, remove that.
            Node tempNode = first; // It save reference to first Node in tempNode- so that we could return saved
                                   // reference.
            first = first.next; // It remove firstNode (make first point to secondNode)
            return tempNode; // return removed Node.
        }

        // Case3: when there are atLeast two elements in LinkedList
        Node previous = null;
        Node current = first;

        while (current.next != null) { // It executes until we don't find last Node of LinkedList.
                                       // It next of some Node is pointing to null, that means it's a last Node.
            previous = current;
            current = current.next; // It moves to next node.
        }

        previous.next = null; // Now, previous is pointing to second last Node of LinkiedList,
                              // make it point to null [it byPasses current Node(last Node of LinkedList)
                              // which was in between]
        return current;
    }

    
    // Display LinkedList
    public void displayLinkedList() {
        System.out.print("Displaying LinkedList [first--->last]: ");
        Node tempDisplay = first; // It start at the beginning of linkedList
        while (tempDisplay != null) { // It executes until we don't find end of list.
            tempDisplay.displayNode();
            tempDisplay = tempDisplay.next; // It moves to next Node
        }
        System.out.println();
    }
}
