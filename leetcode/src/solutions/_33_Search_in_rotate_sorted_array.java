package solutions;

public class _33_Search_in_rotate_sorted_array {
    public int search(int[] nums, int target) {

        int n = nums.length;
        if(n == 0) return -1;

        int L = 0, R = n-1;
        int first = nums[0];

        while(L<=R) {
            int mid = L + (R-L)/2;
            int value = nums[mid];

            if(value == target) return mid;

            boolean am_big = value >= first;
            boolean target_big = target >= first;

            if(am_big == target_big) {
                if(value < target) {
                    L = mid+1;
                } else {
                    R = mid -1;
                }
            } else {
                if(am_big) {
                    L = mid+1;
                } else {
                    R = mid-1;
                }
            }
        }

        return -1;
    }
}
