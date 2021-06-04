//Doublelinked list implementation
public class DoublelinkedList<E> {

    // Nested inner class
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
        //Both @first & @last are just links to first and last DoublelinkedList elements. They are not the elements
        //themselves. So they really need to be just links to Node <E>. But initialization of @first and @last
        //as Node <E> allows more simple, better readable and compact code in methods implementations
        //So init them as two Nodes first->last
        first = new Node<E>(null, null, null);
        last = new Node<E>(first, null, null);
        first.next = last;
    }

    //add new elements to the end, mark it last
    public void addToEnd(E val) {
        last.prev.next = last.prev = new Node<>(last.prev, val, last);
    }

    //add to begin, mark it first
    public void pushFront(E val) {
        first.next.prev = first.next = new Node<>(first, val, first.next);
    }

    //get element located at idx
    public E get(int idx) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        return current.item;
    }

    //set element value to element located at idx
    public void set(int idx, E val) {
        Node<E> current = first;
        for (int i = -1; i < idx; i++) {
            current = current.next;
        }
        current.item = val;
    }

    //remove from end, mark previous to removed as last
    public void removeFromEnd() {
        last.prev = last.prev.prev;
        last.prev.next = last;
    }

    //remove from  begin, mark next to removed as first
    public void removeFromBegin() {
        first.next = first.next.next;
        first.next.prev = first;
    }

    //get last. @last is just the link to real last, so return previous to @last
    public E getLast() {
        return last.prev.item;
    }

    //get first. @first is just the link to real last, so return next to @first
    public E front() {
        return first.next.item;
    }

    //if @first and last link to each other, then no real elements between them in the list
    public boolean isEmpty() {
        return (first.next == last && last.prev == first);
    }
}

