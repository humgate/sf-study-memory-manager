import static org.junit.Assert.*;

import org.junit.Test;

public class DoublelinkedListTest {
    /**
     * Tests for class DoublelinkedList.
     */

    @Test
    public final void test() {
        DoublelinkedList<Integer> dlist = new DoublelinkedList<>();
        Integer[] arr = new Integer[]{46, 1, 48, 49};

        dlist.addToEnd(46);
        dlist.addToEnd(47);
        dlist.addToEnd(48);
        dlist.addToEnd(49);
        dlist.addToEnd(50);
        dlist.addToBegin(45);
        dlist.removeFromEnd();
        dlist.removeFromBegin();
        dlist.set(1,1);

        for (int i = 0; i < 4; i++) {
            assertEquals(arr[i], dlist.get(i));
        }
        assertEquals(dlist.getFirstIndex(46),0);
        assertEquals(dlist.getFirstIndex(1),1);
        assertEquals(dlist.getFirstIndex(49),3);

    }
}
