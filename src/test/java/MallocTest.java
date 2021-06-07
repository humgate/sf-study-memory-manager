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

        assertEquals(manager.malloc(94),-1);

        assertEquals(manager.dlist.getMemItemByIndex(0).index,0);
        assertEquals(manager.dlist.getMemItemByIndex(0).length ,5);
        assertTrue(manager.dlist.getMemItemByIndex(0).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(1).index,5);
        assertEquals(manager.dlist.getMemItemByIndex(1).length ,2);
        assertTrue(manager.dlist.getMemItemByIndex(1).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(2).index,7);
        assertEquals(manager.dlist.getMemItemByIndex(2).length ,93);
        assertFalse(manager.dlist.getMemItemByIndex(2).allocated);

        assertNull(manager.dlist.getMemItemByIndex(3));
    }
}
