package solutions;

public class _69_sqrt {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int L = 1, R = x;

        int ans = 0;
        while(L<=R) {
            int mid = L + (R-L) / 2;

            if(mid <= x / mid) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid -1;
            }
        }

        return ans;
    }
}
