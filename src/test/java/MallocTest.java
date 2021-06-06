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

        assertEquals(manager.dlist.getByIndex(0).index,0);
        assertEquals(manager.dlist.getByIndex(0).length,5);
        assertTrue(manager.dlist.getByIndex(0).allocated);

        assertEquals(manager.dlist.getByIndex(1).index,5);
        assertEquals(manager.dlist.getByIndex(1).length,2);
        assertTrue(manager.dlist.getByIndex(1).allocated);

        assertEquals(manager.dlist.getByIndex(2).index,7);
        assertEquals(manager.dlist.getByIndex(2).length,93);
        assertFalse(manager.dlist.getByIndex(2).allocated);

        assertNull(manager.dlist.getByIndex(3));
    }
}
