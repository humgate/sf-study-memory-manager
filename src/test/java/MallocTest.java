import org.junit.Test;

public class MallocTest {
    /**
     * Tests for class DoublelinkedList.
     */
    @Test
    public final void test2() {
        MemoryManager manager = new MemoryManager(100);
        manager.malloc(5);
        manager.malloc(2);

        System.out.println(manager.dlist.get(0).index + " " + manager.dlist.get(0).length + " " + manager.dlist.get(0).allocated);
        System.out.println(manager.dlist.get(1).index + " " + manager.dlist.get(1).length +  " " + manager.dlist.get(0).allocated);
        System.out.println(manager.dlist.get(2).index + " " + manager.dlist.get(2).length +  " " + manager.dlist.get(0).allocated);

    }
}
