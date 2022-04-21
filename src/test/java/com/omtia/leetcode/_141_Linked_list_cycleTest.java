/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.utils.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _141_Linked_list_cycleTest {

    @Test
    void hasCycle() {
        int[] vals = {3,2,0,4};

        ListNode head = new ListNode();
        ListNode loop = head;
        for (int val : vals) {
            loop.next = new ListNode(val);
            loop = loop.next;
        }
        loop.next = head.next;

        _141_Linked_list_cycle c = new _141_Linked_list_cycle();
        assertTrue(c.hasCycle(head));
    }
}