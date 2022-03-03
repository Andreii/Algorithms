package solutions;

import java.util.HashSet;
import java.util.Set;

public class _136_Single_Number {
    public int singleNumber(int[] nums) {

        int a = 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }

        return (int) set.toArray()[0];
    }

    public int singleNumber_v2(int[] nums) {
        int a = 0;

        for(int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }

        return a;
    }
}
