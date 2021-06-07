public class Node {
        /*
         * Base class to encapsulate element to be stored in double linked list
         *
         */

        Node next; //link to next
        Node prev; //link to previous
        Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
}



