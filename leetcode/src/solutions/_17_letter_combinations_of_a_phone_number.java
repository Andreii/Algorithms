package solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class _17_letter_combinations_of_a_phone_number {
    private static final Map<Character, char[]> KEYS = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    );

    private void dfs(String digits, List<String> res, List<String> path) {
        if(path.size() == digits.length()) {
            res.add(String.join("",path));
            return;
        }

        char[] next_digits = KEYS.get(digits.charAt(path.size()));
        for (char next_digit : next_digits) {
            path.add(String.valueOf(next_digit));
            dfs(digits, res, path);
            path.remove(path.size() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>(0);
        List<String> res = new ArrayList<>();
        dfs(digits, res, new ArrayList<String>());
        return res;
    }
}
