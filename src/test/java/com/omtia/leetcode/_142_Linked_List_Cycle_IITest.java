package com.omtia.leetcode;

import org.junit.Test;
import com.omtia.un._142_Linked_List_Cycle_II;
import com.omtia.utils.ListNode;

import static com.google.common.truth.Truth.assertThat;

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

        assertThat(c.detectCycle(head)).isEqualTo(head.next);
    }
}