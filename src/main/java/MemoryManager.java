import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Objects;

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
     * Stores the size of managed memory
     *
     */
    private final int size;

    /*
     * Double linked list. Contains collection of memory space items. Main structure containing info about which memory
     * spaces are allocated and which are free and how they are located related to each other
     *
     */
    DoublelinkedList<MemorySpaceItem> dlist = new DoublelinkedList<>();


    /*
     * HasMap stores pairs of: memory item index - memory item length. Used to check if the given index has
     * allocated memory item starting at that index.
     * (It is possible to seek for that index right in the double linked
     * list. But in this case it will iterate through all dlist elements each time (worst case). To speed up this
     * search we store each allocated memspace index along with its length in the HashMap)
     *
     */
    HashMap<Integer, Integer> allocMemMap = new HashMap<>();


    MemoryManager(int size){
        //our memory size
        this.size = size;

        //initialize manager by adding one free MemorySpaceItem with starting index = 0 and size equals to @size
        dlist.addToBegin(new MemorySpaceItem(0,size,false));

    }

    public int malloc (int n) {
        /*
         * Space item (MemorySpaceItem object) is the node with three fields - status (free/allocated), start index,
         * length.
         * 1. Find Least Recently Used (least recently freed) memory space item in stack (stack.item)
         * 2. check if n is less or equal to stack.item.length returned at step above. If greater - error
         * 3. find free dlist.item (MemorySpaceItem object) corresponding to this stack.item. Delete this stack.item
         * from stack.
         * 4. add new allocated dlist.item, set i from free dlist.item, n (from @param) to the dlist. Put new pair int
         * allocated memory hash map (allocMemMap), with key = i and value = dlist.item
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
         * 1. Find allocated space.item with index = i in allocMemMap.
         * If none return -1 , else proceed below
         * 2. As soon as it exists, find it in the dlist. Set its status to free
         * 3. Find appropriate stack.item and delete it
         * 3. Check if there are adjacent free memory space items to this one in dlist using dlist getPrev/getNext.
         * If yes:
         * merge them by setting leftmost (closest to dlist begin) item length equal to sum of all
         * found free adjacent item lengths. Delete all found adjacent neighbour dlist.items to the right
         * (closer to the end of dlist). Along with deleting these dlist.items, find corresponding ones in the stack
         *  and delete them as well
         *
         */


        return (i);
    }
}
