package solutions;

/**
 * An ugly number is a positive integer that is divisible by a, b, or c.
 *
 * Given four integers n, a, b, and c, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 *
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 *
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 *
 *
 * Constraints:
 *
 * 1 <= n, a, b, c <= 109
 * 1 <= a * b * c <= 1018
 * It is guaranteed that the result will be in range [1, 2 * 109]
 */
public class _1202_ugly_numbers_III {

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ac = (long) a *c / gcd(a,c);
        long ab = (long) a *b / gcd(a,b);
        long bc = (long) b *c / gcd(b,c);
        long abc = ab*c / gcd(ab,c);

        long L = n, R = 2 * (long) 1e9;
        long index = R;

        while( L <= R) {
            long mid = L + (R-L) / 2;
            long k = mid;
            long ugly_num_count = (k/a + k/b + k/c) - (k/ab + k/ac + k/bc) + k/abc;
            if( ugly_num_count >= n) {
                index = mid;
                R = mid -1;
            } else {
                L = mid +1;
            }
        }

        return (int) index;
    }
    public long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
