package un;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the
 * given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */

public class _39_combination_sum {
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int prefix, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if( sum > target) return;

        for(int i = prefix; i < candidates.length; i++) {
            int c = candidates[i];
            if(candidates[i] <= target) {
                path.add(c);
                sum += c;
                dfs(candidates, target, ans, path, i, sum);
                path.remove(path.size() - 1);
                sum -= c;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(candidates, target, ans, new ArrayList<>(), 0, 0);

        return ans;
    }
}
