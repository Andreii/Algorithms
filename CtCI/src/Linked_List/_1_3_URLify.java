package Linked_List;

import static org.junit.Assert.*;

public class _1_3_URLify {
    public static void main(String[] args) {
        assertEquals(URLify("Mr John Smith     "), "Mr%20John%20Smith");

        System.out.println(URLify("Mr John Smith     "));
    }

    public static String URLify(String s) {
        s = s.trim();
        char[] c = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(c[i]);
            }
        }

        return sb.toString();
    }
}
