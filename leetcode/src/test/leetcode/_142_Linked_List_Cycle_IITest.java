package leetcode;

import org.testng.annotations.Test;
import un._142_Linked_List_Cycle_II;
import utils.ListNode;

import static org.testng.Assert.*;

public class _142_Linked_List_Cycle_IITest {

    @Test
    public void testDetectCycle() {
        _142_Linked_List_Cycle_II c = new _142_Linked_List_Cycle_II();

        int[] vals = {3,2,0,5};

        ListNode head = new ListNode(vals[0]);
        ListNode loop = head;
        for(int i = 1; i < vals.length; i ++) {
            loop.next = new ListNode(vals[i]);
            loop = loop.next;
        }

        loop.next = head.next;

        assertEquals(c.detectCycle(head), head.next);
    }
}