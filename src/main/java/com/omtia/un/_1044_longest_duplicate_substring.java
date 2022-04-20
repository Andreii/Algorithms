/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.*;

/**
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times.
 * The occurrences may overlap.
 *
 * Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring,
 * the answer is "".
 *
 *
 *
 * Example 1:
 *
 * Input: s = "banana"
 * Output: "ana"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 3 * 104
 * s consists of lowercase English letters.
 */

public class _1044_longest_duplicate_substring {
    public static void main(String[] args) {
        _1044_longest_duplicate_substring c = new _1044_longest_duplicate_substring();

        System.out.println(c.longestDupSubstring("ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba"));
        System.out.println("Expected 'aeeebaabd'");
    }

    private final int P = 1_000_000_007;
    private final int base = 26;
    public String longestDupSubstring(String s) {
        String res = "";
        int L = 1, R = s.length()-1, n = s.length();

        long[] hash = new long[n+1];
        hash[0] = 1L;
        for(int i = 1; i <= n; i++) {
            hash[i] = (hash[i-1] * base) % P;
        }

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = (int)s.charAt(i) - (int) 'a';
        }

        while(L <= R) {

            int M = L + (R-L) / 2;

            String curr = getDuplicate(s, M, hash, n, nums);

            if(!curr.equals("")) {
                if(curr.length() > res.length()) res = curr;
                L = M+1;
            } else {
                R = M-1;
            }
        }

        return res;
    }

    public String getDuplicate(String s, int M, long[] hash, int n, int[] nums) {

        long h = 0;
        for(int i = 0; i < M; i++) {
            h = (h * base + nums[i]) % P;
        }

        HashMap<Long, List<Integer>> visited = new HashMap<>();
        visited.putIfAbsent(h, new ArrayList<>());
        visited.get(h).add(0);

        for(int i = 1; i < n - M + 1; i++) {
            h = (h * base - nums[i - 1] * hash[M] % P + P) % P;
            h = (h + nums[i + M - 1]) % P;

            List<Integer> seen_list = visited.get(h);
            if(seen_list != null) {

                String s2 = s.substring(i, i + M);
                for(Integer index : seen_list) {
                    String s1 = s.substring(index, index + M);

                    if(s1.equals(s2)) {
                        return s1;
                    }
                }
            }

            visited.putIfAbsent(h, new ArrayList<>());
            visited.get(h).add(i);
        }

        return "";
    }
}
