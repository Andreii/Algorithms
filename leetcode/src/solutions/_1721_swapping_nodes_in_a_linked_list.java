package solutions;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
 * from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
public class _1721_swapping_nodes_in_a_linked_list {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] arr = {1,2,3,4,5};

        ListNode cursor = head;
        int i = 0;
        for(int a : arr) {
            cursor.val = a;
            if(arr.length - 1 != i) {
                cursor.next = new ListNode();
                cursor = cursor.next;
            }
            i++;
        }
        _1721_swapping_nodes_in_a_linked_list c = new _1721_swapping_nodes_in_a_linked_list();

        System.out.print(c.swapNodes2(head, 2));
    }

    public ListNode swapNodes(ListNode head, int k) {
        // find mid
        // slow, fast pointer
        ListNode mid = head;
        ListNode fast = head;

        int end = 0;
        while(fast.next != null) {
            end++;
            fast = fast.next;
        }

        // we navigate 2mid-k
        int i = 0;
        ListNode L = new ListNode(), R = new ListNode();
        ListNode node = head;
        while(node != null) {
            if(i == k-1) {
                L = node;
            }

            if(i == end-k+1) {
                R = node;
                int z = L.val;
                L.val = R.val;
                R.val = z;
            }

            node = node.next;
            i++;
        }

        return head;
    }

    // att 2
    public ListNode swapNodes2(ListNode head, int k) {

        List<Integer> arr = new ArrayList<>();

        // compute array
        ListNode node = head;
        while(node != null) {
            arr.add(node.val);
            node = node.next;
        }

        // loop and swap values
        for(int i = 0, j = arr.size()-1; i < arr.size(); i++, j--) {
            if(i == k-1) {
                int z = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, z);
            }
        }

        // compute the linked list again
        int curr = 0;
        ListNode c = head;
        ListNode fake_head = c;
        while(c != null) {

            c.val = arr.get(curr);

            c = c.next;
            curr++;
        }

        return fake_head;
    }
}
