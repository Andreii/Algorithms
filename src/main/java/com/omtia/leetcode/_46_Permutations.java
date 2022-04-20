/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/solution/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
 * order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * Accepted
 * 1,100,463
 * Submissions
 * 1,534,818
 */
public class _46_Permutations {
    // TC: O(n!)
    // SC: O(n!)
    private static void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> path) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            path.add(nums[i]);

            dfs(nums, visited, res, path);

            visited[i] = false;
            path.remove(path.size() -1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) return new ArrayList<>(0);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], res, new ArrayList<Integer>());
        return res;
    }
}
