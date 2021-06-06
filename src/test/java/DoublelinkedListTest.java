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
        dlist.setByIndex(1,1);

        for (int i = 0; i < 4; i++) {
            assertEquals(arr[i], dlist.getByIndex(i));
        }
        assertEquals(dlist.getFirstIndexByVal(46),0);
        assertEquals(dlist.getFirstIndexByVal(1),1);
        assertEquals(dlist.getFirstIndexByVal(49),3);

    }
}
