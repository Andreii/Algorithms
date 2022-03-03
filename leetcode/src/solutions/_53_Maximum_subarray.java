package solutions;

public class _53_Maximum_subarray {
    public int maxSubArray(int[] nums) {
        int curSum = 0, curMax = nums[0];

        for(int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            curMax = Math.max(curSum, curMax);
        }

        return curMax;
    }
}
