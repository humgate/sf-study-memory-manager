public class DoublelinkedList<E> {
    /**
     * Doublelinked list implementation
     * @param <E>  - element type
     */

    static class Node<E> {
        E item; // the data
        Node<E> next; //link to next
        Node<E> prev; //link to previous

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    private Node<E> first;
    private Node<E> last;

    public DoublelinkedList() {

        /* Both @first & @last are just links to first and last DoublelinkedList elements. They are not the elements
         *themselves. So they really need to be just links to Node <E>. But initialization of @first and @last
         *as Node <E> allows more simple, better readable and compact code in methods implementations
         * So init them as two Nodes first->last
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
    public E get(int idx) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current.item;
    }

    //sets element value for element located at idx
    public void set(int idx, E val) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        current.item = val;
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

    //gets last. @last is just the link to real last, so returns previous to @last
    public E getLast() {
        return last.prev.item;
    }

    //gets first. @first is just the link to real last, so returns next to @first
    public E front() {
        return first.next.item;
    }

    //if @first and @last link to each other, then no real elements between them in the list
    public boolean isEmpty() {
        return (first.next == last && last.prev == first);
    }
}

