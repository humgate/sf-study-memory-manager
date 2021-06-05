import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Stack;

@Getter@Setter
public class MemoryManager {

    /*
     * Memory Space Item is structure used to store info about a memory piece.
     * index -  number of memory space item
     * length - length of memory space item
     * status - indicates whether space item is allocated or free
     *
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
     * (It is possible to seek for that index right in the double linked dlist. But in this case it will iterate
     * through all dlist elements each time (worst case). To speed up this search we store each allocated mem space
     * index along with its length in the HashMap)
     *
     */
    HashMap<Integer, Integer> allocMemMap = new HashMap<>();

    /*
    * Stack holds free memory space items lest recently freed. So as soon as memory manager frees a memory space item
    * this item is pushed to stack. When memory manager allocates a memory space item, it looks for LRU items at the
    * top of the stack.
    *
    */
    Stack<MemorySpaceItem> stack = new Stack<>();

    MemoryManager(int size){
        this.size = size;

        MemorySpaceItem memItem = new MemorySpaceItem(0,size,false);
        //Initialize manager by adding one free MemorySpaceItem with starting index = 0 and size equals to @size
        dlist.addToBegin(memItem);

        /*
         * Initialize stack with this item. According to the task description, this implementation of memory manager
         * can allocate memory only if there is an LFU memory item. We have to create at least one LFU stack item at
         * the very begin, otherwise, malloc(n) will be unable to allocate memory at all
         */
        stack.push(memItem);
    }

    public int malloc (int n) {
        /*
         * 1. Find Least Recently Used (least recently freed) memory space item in stack (stack.item)
         * 2. Check if n is less or equal to stack.item.length returned at step above. According to task description:
         * if n > LRU stack.item - return -1, else proceed below.
         * 3. Find free dlist.item (MemorySpaceItem object) corresponding to this (1) stack.item. Delete this
         * stack.item from stack.
         * 4. Mark this (3) free dlist.item as allocated, change its n (to @param). Put new pair into allocated memory
         * hash map (allocMemMap), with key = i and value = n.
         * 5. Calculate new free space item, left from previous item (3) after allocation new item into it.
         * 6. Add new free (reduced) dlist.item next to this (4) just allocated item.
         * 8. Add new stack.item corresponding to new free (6) dlist.item
         * 9. return allocated dlist.item.index (from 4)
         *
         */


        return n;
    }

    public int free (int i) {
        /*
         * 1. Find allocated space.item with index = i in allocMemMap.
         * If none return -1, else proceed below
         * 2. As soon as it exists, find it in the dlist. Set its status to free in the dlist
         * 3. Check if there are adjacent free memory space items to this one in dlist using dlist getPrev/getNext.
         * If yes:
         * merge them by setting leftmost (closest to dlist begin) item length equal to sum of all
         * found free adjacent item lengths. Delete all found adjacent neighbour dlist.items to the right
         * (closer to the end of dlist). Along with deleting these dlist.items, find corresponding ones in the stack
         *  and delete them as well
         * 4. Add new free stack.item corresponding to the item got on previous step
         *
         */


        return (i);
    }
}
