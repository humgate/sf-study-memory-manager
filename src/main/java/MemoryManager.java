import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemoryManager {
    DoublelinkedList<Integer> list = new DoublelinkedList<>();

    private int size;

    MemoryManager() {
    this(1024);
    }

    MemoryManager(int size){
        this.size = size;
    }

    public int malloc (int n) {
        /*
         * Space item is the node with three fields - status (free/allocated), start index, length.
         * 1. find Least Recently Used (least recently freed) memory space item in stack (stack.item)
         * 2. check if n is less or equal to stack.item.length returned at step above. If greater - error
         * 3. find free dlist.item corresponding this stack.item. Delete this stack.item from stack.
         * 4. add new allocated dlist.item, i from free dlist.item, n (from @param) to the dlist.
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
        return (i);
    }
}
