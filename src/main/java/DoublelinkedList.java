public class DoublelinkedList<E> {
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
    private final Node<E> first;
    private final Node<E> last;

    public DoublelinkedList() {

        /*
         * Both @first & @last are just links to first and last list elements. They are not the elements
         * themselves storing "business" data. They really need to be just links to Node<E>. But initialization
         * of @first and @last as Node<E> allows more simple, better readable and compact code in methods
         * implementations. So init them as two Node<E> elements connected to each other first->last
         *
         */

        first = new Node<>(null, null, null);
        last = new Node<>(first, null, null);
        first.next = last;

    }

    //adds new element to the end, marks it as last
    public void addToEnd(E val) {
        last.prev.next = last.prev = new Node<>(last.prev, val, last);
    }

    //adds new element to begin, marks it as first
    public void addToBegin(E val) {
        first.next.prev = first.next = new Node<>(first, val, first.next);
    }

    //gets element located at idx
    public E getByIndex(int idx) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current.item;
    }

    //gets link element Node located at idx
    public Node <E> getNodeByIndex(int idx) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    //sets element value for element located at idx
    public void setByIndex(int idx, E val) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        current.item = val;
    }

    //sets element value for element located by link
    public void setByLink(Node<E> node, E val) {
        node.item = val;
    }

    //inserts element after element located by link in param
    public Node<E> insertAfter(Node<E> node, E val) {
        Node<E> newNode = new Node<>(node, val, node.next);
        node.next.prev = newNode;
        node.next = newNode;
        return newNode;
    }

    //inserts element before element located by link in param
    public Node<E> insertBefore(Node<E> node, E val) {
        Node<E> newNode = new Node<>(node.prev, val, node);
        node.prev.next = newNode;
        node.prev = newNode;
        return newNode;
    }

    //removes last element from the end, marks previous to removed one (new last) as last
    public void removeFromEnd() {
        last.prev = last.prev.prev;
        last.prev.next = last;
    }

    //removes first element from begin, marks next to removed one (new first) as first
    public void removeFromBegin() {
        first.next = first.next.next;
        first.next.prev = first;
    }

    //removes the element by link
    public void remove (Node <E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    //gets last. @last is just the link to real last, so returns previous to @last
    public E getLast() {
        return last.prev.item;
    }

    //gets first. @first is just the link to real last, so returns next to @first
    public E getFirst() {
        return first.next.item;
    }

    //gets index of the first element containing @val in data
    public int getFirstIndexByVal(E val) {
        //return -1 if none
        int i = -1;
        Node<E> current = first;
        while (current.next != null) {
            i++;
            current = current.next;
            if (current.item.equals(val)) {
                return i;
            }
        }
        return i;
    }

    //gets link to the first element (Node) containing @val in data
    public Node<E> getFirstNodeByVal(E val) {
        //return null if none
        Node <E> node = null;
        Node<E> current = first;
        while (current.next != null) {
            current = current.next;
            if (current.item.equals(val)) {
                return current;
            }
        }
        return current;
    }

    //if @first and @last link to each other, then no real elements between them in the list
    public boolean isEmpty() {
        return (first.next == last && last.prev == first);
    }

}

