public class DoublelinkedList {
    /**
     * Doublelinked list implementation specifically designed to hold Node<E> elements.
     * Node <E> class declared public to allow access to Doublelinked list elements (Nodes) from outside of this class.
     * Allowing this significantly simplifies operations of setting list elements values, getting elements, inserting
     * and deleting elements located next to given Node within the list
     * */

    /*
     * Technical staff. Elements pointing to first and last list elements
     *
     */
    private final Node first;
    private final Node last;

    public DoublelinkedList() {

        /*
         * Both @first & @last are just links to first and last list elements. They are not the elements
         * themselves storing "business" data. They really need to be just links to Node<E>. But initialization
         * of @first and @last as Node<E> allows more simple, better readable and compact code in methods
         * implementations. So init them as two Node<E> elements connected to each other first->last
         *
         */

        first = new Node(null, null);
        last = new Node(first, null);
        first.next = last;

    }

    //adds new element to the end, marks it as last
    public Node addToEnd(Node node) {
        node.prev = last.prev;
        node.next = last;
        return last.prev.next = last.prev = node;
    }

    //adds new element to begin, marks it as first
    public Node addToBegin(Node node) {
        node.prev = first;
        node.next = first.next;
        return first.next.prev = first.next = node;
    }

    //gets link to Node located at idx
    public Node getNodeByIndex(int idx) {
        Node current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    //sets element value for element located at idx
    public Node setByIndex(int idx) {
        Node current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    //inserts element after element located by link in param
    public Node insertAfter(Node afterNode, Node newNode) {
        newNode.prev = afterNode;
        newNode.next = afterNode.next;

        afterNode.next.prev = newNode;
        afterNode.next = newNode;
        return newNode;
    }

    //inserts element before element located by link in param
    public Node insertBefore(Node beforeNode, Node newNode) {
        newNode.prev = beforeNode.prev;
        newNode.next = beforeNode;

        newNode.prev.next = newNode;
        newNode.prev = newNode;
        return newNode;
    }

    //removes the element by link
    public void remove (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //gets last. @last is just the link to real last, so returns previous to @last
    public Node getLast() {
        return last.prev;
    }

    //gets first. @first is just the link to real last, so returns next to @first
    public Node getFirst() {
        return first.next;
    }

    //if @first and @last link to each other, then no real elements between them in the list
    public boolean isEmpty() {
        return (first.next == last && last.prev == first);
    }

}

