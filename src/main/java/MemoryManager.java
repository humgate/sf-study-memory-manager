import java.util.HashMap;
import java.util.Stack;

/**
 * Implements memory manager according to SF module 25 task description.
 * Memory here is just sequence of number from 0 to size.
 * Memory contains memory items (MemItem class). Each memory item has:
 * - starting index
 * - length
 * - allocated staus
 * - link to next memory item
 * - link to previous memory item
 * Memory represented by custom implementation of double linked list of MemItems(DoublelinkedList class)
 */
public class MemoryManager {
    /*
     * Stores the size of managed memory
     */
    private final int size;

    /*
     * Double linked list. Contains collection of memory space items. Main structure containing info about which memory
     * spaces are allocated and which are free and how they are located related to each other
     */
    DoublelinkedList dlist = new DoublelinkedList();

    /*
     * HasMap stores pairs of: memory item index - Node object. Used to check if the given index has
     * allocated memory item starting at that index.
     * (It is possible to seek for that index right in the double linked dlist. But in this case it will iterate
     * through all dlist elements each time (worst case). To speed up this search we store each allocated mem space
     * index along with link to its Node in dlist in the HashMap)
     */
    HashMap<Integer, MemItem> allocMemMap = new HashMap<>();

    /*
     * Stack holds free memory space items lest recently freed. So as soon as memory manager frees a memory space item
     * this item is pushed to stack. When memory manager allocates a memory space item, it looks for LRU items at the
     * top of the stack.
     *
     */
    Stack<MemItem> stack = new Stack<>();

    MemoryManager(int size){
        this.size = size;

        //Initialize manager by adding one free MemorySpaceItem with starting index = 0 and size equals to @size
        MemItem initialItem = new MemItem(0, size, false);
        dlist.addToBegin(initialItem);

        /*
         * Initialize stack with this item. According to the task description, this implementation of memory manager
         * can allocate memory only if there is an LFU memory item. We have to create at least one LFU stack item at
         * the very begin, otherwise, malloc(n) will be unable to allocate memory at all
         */
        stack.push(initialItem);
    }

    /**
     * Allocates memory item with size = @param.
     * @param n - size of memory item to allocate
     * @return - number at which allocated memory item starts, or -1 in when unable to allocate memory item of
     * requested size.
     *
     * Algorithm:
     * 1. Find Least Recently Used (least recently freed) memory item in stack (stack item)
     * 2. Check item returned at (1) is not null and n is less or equal to item.length. Return -1 if not
     * 3. Get list item (MemItem object) corresponding to this (1) stack item. Delete it (stack item) from stack
     * 4. Mark this (3) free list item as allocated, change its n (to @param). Put new pair into allocated memory
     * hash map (allocMemMap), with key = i and value = n.
     * 5. Calculate new free MemItem size, left from previous item (3) after allocation new item into it.
     * 6. Add new free (reduced) list item next to this (4) just allocated item.
     * 7. Add new stack item corresponding to new free (6) list item
     * 8. return allocated list item index (from 4)
     *
     */
    public int malloc (int n) {
        // 1,2,3
        MemItem item = stack.pop();
        if (item == null || item.length < n) {
            return -1;
        }

        //4,5
        MemItem newItem = new MemItem(item.index + n, item.length - n, false);

        item.length = n;
        item.allocated = true;
        allocMemMap.put(item.index, item);

        //6
        dlist.insertAfter(item, newItem);

        //7
        stack.push(newItem);

        return n;
    }

    /**
     * Frees memory item previously allocated by malloc(n)
     * @param i - memory item index previously allocated by malloc(n)
     * @return - 0 if success, -1 if i does not correspond to any of previously allocated MemItem index
     *
     * Algorithm:
     * 1. Find allocated space item with index = @param in allocated memory map (allocMemMap).
     * If none return -1, else proceed below.
     * 2. As soon as it exists, find it in the list. Set its status to free. Remove it from allocated memory
     * map (allocMemMap)
     * 3. Check if there are adjacent free memory space items to this one in the lis.
     * If yes:
     * - merge them by setting leftmost (closest to list begin) memory item length equal to sum of all
     * found free adjacent item lengths.
     * - delete all found adjacent neighbour list items to the leftmost item (all ones located to the right or
     * closer to the end of list).
     * - along with deleting these list items, find corresponding ones in the stack and delete them as well
     * 4. Add new free stack.item corresponding to the item got on previous step
     *
     */
    public int free (int i) {
        //1
        if (allocMemMap.get(i) == null) {
            return -1;
        }

        //2
        MemItem item = allocMemMap.get(i);
        allocMemMap.remove(i, item);

        item.allocated = false;

        //4a - check if right neighbour is free and ADD IT if yes
        MemItem neighbourItem = item.next;
        if (!neighbourItem.allocated) {
            item.length = item.length + neighbourItem.length;
            stack.remove(neighbourItem);
            dlist.remove(neighbourItem);
        }

        //4b - check if left neighbour is free and JOIN TO IT if yes
        neighbourItem = item.prev;
        if (!neighbourItem.allocated) {
            neighbourItem.length = neighbourItem.length + item.length;
            stack.remove(neighbourItem);
            dlist.remove(item);
            item = neighbourItem;
        }

        stack.push(item);
        return 0;
    }
}
