package solutions;

public class _201_Bitwise_AND_of_Numbers_range {
    public int rangeBitwiseAnd(int left, int right) {
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111

        int ans = 0;
        for(int i = 30; i >= 0; i--) {
            if((left & (1<<i)) != (right & (1<<i))) {
                break;
            } else {
                ans |= (left & (1<<i));
            }
        }
        return ans;
    }
}
