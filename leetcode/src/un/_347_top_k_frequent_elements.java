package un;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
 * any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _347_top_k_frequent_elements {
    // TC: O(n log k)
    // SC: O(n + k)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // TC: O(1)
        if(n == k) return nums;

        // val, freq
        Map<Integer,Integer> freq = new HashMap<>();

        // TC: O(n)
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // val
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                freq.size(),
                Comparator.comparingInt(freq::get)
        );

        // TC: O(n log k)
        for(Integer f : freq.keySet()) {
            pq.add(f);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
