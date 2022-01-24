package solutions;

public class _268_Missing_number {
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        for(int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        int n = nums.length;

        return (n * (n+1) /2) - numsSum;
    }
}
