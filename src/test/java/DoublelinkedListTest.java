import static org.junit.Assert.*;

import org.junit.Test;

public class DoublelinkedListTest {
    /**
     * Tests for class Finder.
     * <p>
     * All tests in the folder "test" are executed
     * when the "Test" action is invoked.
     */


    @Test
    public final void test() {
        DoublelinkedList<Integer> dlist = new DoublelinkedList<>();
        Integer[] arr = new Integer[]{46, 47, 48, 49};

        dlist.addToEnd(46);
        dlist.addToEnd(47);
        dlist.addToEnd(48);
        dlist.addToEnd(49);
        dlist.addToEnd(50);
        dlist.addToBegin(45);
        dlist.removeFromEnd();
        dlist.removeFromBegin();

        for (int i = 0; i < 3; i++) {
            assertTrue(dlist.get(i) == arr[i]);
        }

    }
}
