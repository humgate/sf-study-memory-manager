public class Node <E> {
        /*
         * Base class to encapsulate element to be stored in double linked list
         *
         */
        E item; // the data
        Node<E> next; //link to next
        Node<E> prev; //link to previous

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
}



