import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter@Setter
public class MemoryManager {

    /*
     * Memory Space Item is structure consisting of three fields: index, length, status. Is used to store info about
     * a memory piece.
     * index - number of memory space item
     * length - length of memory space item
     * status - indicates whether space item is allocated or free
     * node - the link to
     */

    private class MemorySpaceItem {
        int index;
        int length;
        boolean allocated;


        public MemorySpaceItem(int index, int length, boolean allocated) {
            this.index = index;
            this.length = length;
            this.allocated = allocated;
        }
    }

    /*
     * Stores the size of managed memory space
     *
     */
    private final int size;

    /*
     * Double linked list. Contains collection of memory space items. Main structure containing info about which memory
     * spaces are allocated and which are free
     *
     */
    DoublelinkedList<MemorySpaceItem> dlist = new DoublelinkedList<>();


    MemoryManager(int size){
        //our memory size
        this.size = size;

        //initialize manager by adding one free MemorySpaceItem with starting index = 0 and size equals to @size
        dlist.addToBegin(new MemorySpaceItem(0,size,false));
    }

    public int malloc (int n) {
        /*
         * Space item is the node with three fields - status (free/allocated), start index, length.
         * 1. find Least Recently Used (least recently freed) memory space item in stack (stack.item)
         * 2. check if n is less or equal to stack.item.length returned at step above. If greater - error
         * 3. find free dlist.item corresponding to this stack.item. Delete this stack.item from stack.
         * 4. add new allocated dlist.item, i from free dlist.item, n (from @param) to the dlist. Set allocated memory
         * hash map element with key = i (allocMemMap)
         * 5. calculate new free space item, which will be free dlist.item excluding from it the allocated dlist.item
         * 6. delete free dlist.item
         * 7. add new free (reduced) dlist.item
         * 8. add new stack.item corresponding to dlist.item
         * 9. return allocated dlist.item.index (from step 4)
         *
         *
         *
         */
        return n;
    }

    public int free (int i) {
        /*
         * 1. Find allocated space.item with index = i in dlink and set its status as to free
         *
         */

        return (i);
    }
}
