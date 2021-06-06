import org.junit.Test;

import static org.junit.Assert.*;

public class MallocTest {
    /**
     * Tests for class DoublelinkedList.
     */
    @Test
    public final void test2() {
        MemoryManager manager = new MemoryManager(100);
        manager.malloc(5);
        manager.malloc(2);

        System.out.println(
                manager.dlist.get(0).index + " " + manager.dlist.get(0).length + " " + manager.dlist.get(0).allocated);
        System.out.println(
                manager.dlist.get(1).index + " " + manager.dlist.get(1).length +  " " + manager.dlist.get(1).allocated);
        System.out.println(
                manager.dlist.get(2).index + " " + manager.dlist.get(2).length +  " " + manager.dlist.get(2).allocated);

        assertEquals(manager.dlist.get(0).index,0);
        assertEquals(manager.dlist.get(0).length,5);
        assertTrue(manager.dlist.get(0).allocated);

        assertEquals(manager.dlist.get(1).index,5);
        assertEquals(manager.dlist.get(1).length,2);
        assertTrue(manager.dlist.get(1).allocated);

        assertEquals(manager.dlist.get(2).index,7);
        assertEquals(manager.dlist.get(2).length,93);
        assertFalse(manager.dlist.get(2).allocated);

        assertNull(manager.dlist.get(3));

    }
}
