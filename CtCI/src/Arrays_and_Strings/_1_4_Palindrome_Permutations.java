package Arrays_and_Strings;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class _1_4_Palindrome_Permutations {
    public static void main(String[] args) {
        System.out.println(perm("Tact Coa"));
    }

    public static boolean perm(String s) {
        HashMap<Character, Integer> m = new HashMap<>();

        s = s.toLowerCase(Locale.ROOT);

        char[] chars = s.toCharArray();
        for( char c : chars) {
            if(c == ' ') continue;
            if (m.containsKey(c)) {
                int count = m.get(c);
                m.put(c, ++count);
            } else {
                m.put(c, 1);
            }
        }

        int allowedOnes = 1;
        for(Map.Entry<Character, Integer> e : m.entrySet()) {
            if(e.getValue() != 2) {

                allowedOnes--;
            }
            if(allowedOnes < 0) return false;
        }

        return true;
    }

}
