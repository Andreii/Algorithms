package solutions;

import java.util.Arrays;

public class _338_Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits2(5)));
    }

    public static int[] countBits(int n) {
        int[] sol = new int[n+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 64; j++) {
                if((i& (1L<<j)) > 0) sol[i] ++;
            }
        }

        return sol;
    }

    public static int[] countBits2(int n) {
        int[] sol = new int[n+1];

        for(int i = 0; i <= n; i++) {
            sol[i] = Integer.bitCount(i);
        }

        return sol;
    }
}
