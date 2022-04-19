package com.omtia.leetcode;

import com.omtia.leetcode._23_merge_k_sorted_lists;
import com.omtia.utils.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class _23_merge_k_sorted_listsTest {
    @Test
    public void testMergeKLists() {
        _23_merge_k_sorted_lists c = new _23_merge_k_sorted_lists();

        int[][] vals_list = {{1,4,5}, {1,3,4}, {2,6}};
        int[] expected = {1,1,2,3,4,4,5,6};
        ListNode[] sortedLists = new ListNode[3];

        int i = 0;
        for(int[] vals : vals_list) {
            ListNode head = new ListNode();
            ListNode loop = head;
            for (int val : vals) {
                loop.next = new ListNode(val);
                loop = loop.next;
            }
            sortedLists[i++] = head.next;
        }

        ListNode expectedLN = new ListNode();
        ListNode loop_expected = expectedLN;
        for(int expected_val : expected) {
            loop_expected.next = new ListNode(expected_val);
            loop_expected = loop_expected.next;
        }
        expectedLN = expectedLN.next;

        ListNode res = c.mergeKLists(sortedLists);
        ListNode res2 = c.mergeKLists2(sortedLists);
        while(res != null) {
            assertThat(res.val).isEqualTo(expectedLN.val);
            res = res.next;
            res2 = res2.next;
            expectedLN = expectedLN.next;
        }
    }
}