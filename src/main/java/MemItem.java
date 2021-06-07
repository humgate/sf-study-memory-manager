/*
 * Memory Item is structure used to store info about a memory piece.
 *
 */
public class MemItem {

    //link to next
    MemItem next;

    //link to previous
    MemItem prev;

    //index - number of memory space item
    int index;

    //length - length of memory space item
    int length;

    //status - indicates whether space item is allocated or free
    boolean allocated;

    public MemItem(int index, int length, boolean allocated, MemItem prev, MemItem next) {
        this.index = index;
        this.length = length;
        this.allocated = allocated;
        this.prev = prev;
        this.next = next;
    }

    public MemItem(int index, int length, boolean allocated) {
        this.prev = null;
        this.next = null;
        this.index = index;
        this.length = length;
        this.allocated = allocated;
    }
}