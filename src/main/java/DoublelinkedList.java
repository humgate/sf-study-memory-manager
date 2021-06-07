public class DoublelinkedList {
    /**
     * Doublelinked list implementation specifically designed to hold MemItem<E> elements.
     * MemItem <E> class declared public to allow access to Doublelinked list elements (MemItems) from outside of this class.
     * Allowing this significantly simplifies operations of setting list elements values, getting elements, inserting
     * and deleting elements located next to given MemItem within the list
     * */

    /*
     * Technical staff. Elements pointing to first and last list elements
     *
     */
    private final MemItem first;
    private final MemItem last;

    public DoublelinkedList() {

        /*
         * Both @first & @last are just links to first and last list elements. They are not the elements
         * themselves storing "business" data. They really need to be just links to MemItem<E>. But initialization
         * of @first and @last as MemItem<E> allows more simple, better readable and compact code in methods
         * implementations. So init them as two MemItem<E> elements connected to each other first->last
         *
         */

        first = new MemItem(-1,0,false,null, null);
        last = new MemItem(-1,0,false,first, null);
        first.next = last;

    }

    //adds new element to the end, marks it as last
    public MemItem addToEnd(MemItem node) {
        node.prev = last.prev;
        node.next = last;
        return last.prev.next = last.prev = node;
    }

    //adds new element to begin, marks it as first
    public MemItem addToBegin(MemItem node) {
        node.prev = first;
        node.next = first.next;
        return first.next.prev = first.next = node;
    }

    //gets link to MemItem located at idx except first and last nodes
    public MemItem getMemItemByIndex(int idx) {
        MemItem current = first;
        int i = -1;
        while (current != last && i < idx) {
            current = current.next;
            i++;
        }

        return (current == last || current==first) ? null:current;
    }


    //inserts element after element located by link in param
    public MemItem insertAfter(MemItem afterMemItem, MemItem newMemItem) {
        newMemItem.prev = afterMemItem;
        newMemItem.next = afterMemItem.next;

        afterMemItem.next.prev = newMemItem;
        afterMemItem.next = newMemItem;
        return newMemItem;
    }

    //inserts element before element located by link in param
    public MemItem insertBefore(MemItem beforeMemItem, MemItem newMemItem) {
        newMemItem.prev = beforeMemItem.prev;
        newMemItem.next = beforeMemItem;

        newMemItem.prev.next = newMemItem;
        newMemItem.prev = newMemItem;
        return newMemItem;
    }

    //removes the element by link
    public void remove (MemItem node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //gets last. @last is just the link to real last, so returns previous to @last
    public MemItem getLast() {
        return last.prev;
    }

    //gets first. @first is just the link to real last, so returns next to @first
    public MemItem getFirst() {
        return first.next;
    }

    //if @first and @last link to each other, then no real elements between them in the list
    public boolean isEmpty() {
        return (first.next == last && last.prev == first);
    }

}

