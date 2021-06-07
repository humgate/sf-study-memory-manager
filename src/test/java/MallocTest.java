import org.junit.Test;

import static org.junit.Assert.*;

public class MallocTest {
    /**
     * Tests for malloc(n).
     */
    @Test
    public final void test1() {

        MemoryManager manager = new MemoryManager(100);

        //malloc 4 items
        manager.malloc(5);
        manager.malloc(2);
        manager.malloc(4);
        manager.malloc(10);

        /*
         *As result must have items index-length-allocated
         * 0: 0-5-true
         * 1: 5-2-true
         * 2: 7-4-true
         * 3: 11-21-true
         * 4: 21-100-false
         */
        assertEquals(manager.dlist.getMemItemByIndex(0).index,0);
        assertEquals(manager.dlist.getMemItemByIndex(0).length ,5);
        assertTrue(manager.dlist.getMemItemByIndex(0).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(1).index,5);
        assertEquals(manager.dlist.getMemItemByIndex(1).length ,2);
        assertTrue(manager.dlist.getMemItemByIndex(1).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(2).index,7);
        assertEquals(manager.dlist.getMemItemByIndex(2).length ,4);
        assertTrue(manager.dlist.getMemItemByIndex(2).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(3).index,11);
        assertEquals(manager.dlist.getMemItemByIndex(3).length ,10);
        assertTrue(manager.dlist.getMemItemByIndex(3).allocated);

        assertEquals(manager.dlist.getMemItemByIndex(4).index,21);
        assertEquals(manager.dlist.getMemItemByIndex(4).length ,79);
        assertFalse(manager.dlist.getMemItemByIndex(4).allocated);

        assertNull(manager.dlist.getMemItemByIndex(5));
    }
}
