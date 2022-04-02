package solutions;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class _680_Valid_palindrome_II {
    public boolean isPalindrome(String s, int L, int R) {
        while(L<R) {
            if(s.charAt(L) != s.charAt(R)) return false;
            L++;
            R--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int L = 0, R = s.length() -1;

        while(L<R) {
            if(s.charAt(L) != s.charAt(R)) {
                return isPalindrome(s, L+1, R) || isPalindrome(s, L, R-1);
            }
            L++;
            R--;
        }

        return true;
    }
}
