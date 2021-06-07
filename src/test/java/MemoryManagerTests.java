import org.junit.Test;
import static org.junit.Assert.*;

public class MemoryManagerTests {
    @Test
    public final void test1() {
        /*
         * malloc (n) test
         */

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
        assertEquals(0,manager.dlist.getMemItemByIndex(0).index);
        assertEquals(5,manager.dlist.getMemItemByIndex(0).length);
        assertTrue(manager.dlist.getMemItemByIndex(0).allocated);

        assertEquals(5,manager.dlist.getMemItemByIndex(1).index);
        assertEquals(2,manager.dlist.getMemItemByIndex(1).length);
        assertTrue(manager.dlist.getMemItemByIndex(1).allocated);

        assertEquals(7,manager.dlist.getMemItemByIndex(2).index);
        assertEquals(4,manager.dlist.getMemItemByIndex(2).length);
        assertTrue(manager.dlist.getMemItemByIndex(2).allocated);

        assertEquals(11,manager.dlist.getMemItemByIndex(3).index);
        assertEquals(10,manager.dlist.getMemItemByIndex(3).length);
        assertTrue(manager.dlist.getMemItemByIndex(3).allocated);

        assertEquals(21,manager.dlist.getMemItemByIndex(4).index);
        assertEquals(79,manager.dlist.getMemItemByIndex(4).length);
        assertFalse(manager.dlist.getMemItemByIndex(4).allocated);

        assertNull(manager.dlist.getMemItemByIndex(5));
    }

    @Test
    public final void test2() {
        /*
         * free(i) test
         */

        MemoryManager manager = new MemoryManager(100);

        //malloc 4 items
        manager.malloc(5);
        manager.malloc(2);
        manager.malloc(4);
        manager.malloc(10);
        /*
         *As result must have items item: index-length-allocated
         * 0: 0-5-true
         * 1: 5-2-true
         * 2: 7-4-true
         * 3: 11-10-true
         * 4: 21-100-false
         */

        //free 2 items
        manager.free(7);
        manager.free(5);
        manager.free(11);
        /*
         *As result must have items item: index-length-allocated
         * 0: 0-5-true
         * 1: 5-95-false
         */

        assertEquals(0,manager.dlist.getMemItemByIndex(0).index);
        assertEquals(5,manager.dlist.getMemItemByIndex(0).length);
        assertTrue(manager.dlist.getMemItemByIndex(0).allocated);

        assertEquals(5,manager.dlist.getMemItemByIndex(1).index);
        assertEquals(95,manager.dlist.getMemItemByIndex(1).length);
        assertFalse(manager.dlist.getMemItemByIndex(1).allocated);

        assertNull(manager.dlist.getMemItemByIndex(3));
        assertNull(manager.dlist.getMemItemByIndex(4));
        assertNull(manager.dlist.getMemItemByIndex(5));
    }
}
