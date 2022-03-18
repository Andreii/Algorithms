package un;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class _131_Palindrome_partitioning {
    private boolean isPalindrome(String s) {
        int L = 0, R = s.length() - 1;

        while(L<R) {
            if(s.charAt(L) == s.charAt(R)) {
                L++;
                R--;
            } else return false;
        }

        return true;
    }

    private void dfs(List<List<String>> ans, String s, List<String> path, int start) {
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            String substr = s.substring(start, i+1);
            if(isPalindrome(substr)) {
                path.add(substr);
                dfs(ans,s,path, i+1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, s, new ArrayList<>(), 0);
        return ans;
    }
}
