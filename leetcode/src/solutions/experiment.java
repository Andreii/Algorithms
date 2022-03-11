package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class experiment {
    public static void main(String[] args) {
        int[] test = new int[] {2,7,11,26};
        System.out.println(solve2(test));
    }
    public static boolean solve(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
    public static boolean solve2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
