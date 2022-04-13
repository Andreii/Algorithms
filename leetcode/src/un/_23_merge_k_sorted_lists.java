package un;

import utils.ListNode;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class _23_merge_k_sorted_lists {
    // TC: O(kB log kB)
    // SC: O(kB)
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode res = new ListNode();
        if(k == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode list : lists) {
            while(list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }

        if(pq.isEmpty()) return null;

        ListNode head = res;
        while(!pq.isEmpty()) {
            res.next = new ListNode(pq.poll());
            res = res.next;
        }

        return head.next;
    }

    // TC: O(kB log k)
    // SC: O(k)
    public ListNode mergeKLists2(ListNode[] lists) {
        int k = lists.length;
        ListNode res = new ListNode();
        if(k == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, (a,b) -> a.val - b.val);

        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        if(pq.isEmpty()) return null;

        ListNode head = res;
        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            res.next = curr;
            if(curr.next != null) pq.add(curr.next);
            res = res.next;
        }

        return head.next;
    }
}
