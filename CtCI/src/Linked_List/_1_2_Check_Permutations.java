package Linked_List;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class _1_2_Check_Permutations {
    public static void main (String[] args) {

        assertEquals(checkPermutation("asd", "dsa"), true);

        System.out.printf(" Result from [%s], [%s], is [%b]", "asd", "dsa", checkPermutation("assd", "dsa"));
    }

    public static boolean checkPermutation(String left, String right) {
        HashMap<Character, Integer> o = new HashMap<>();

        if (left.length() != right.length()) return false;

        char[] l = left.toCharArray();
        for(char lc : l) {
            if(o.containsKey(lc)) {
                int count = o.get(lc);
                o.put(lc, count++);
            } else {
                o.put(lc, 1);
            }
        }

        char[] r = right.toCharArray();
        for(char rc : r) {
            if(o.containsKey(rc)) {
                int count = o.get(rc);
                if (count > 1) {
                    count--;
                    o.put(rc, count);
                } else if ( count == 1 ) {
                    o.remove(rc);
                }
            }
        }

        return o.size() == 0;
    }
}
