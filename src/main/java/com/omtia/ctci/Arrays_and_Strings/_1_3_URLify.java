/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.ctci.Arrays_and_Strings;

import static org.junit.Assert.*;

public class _1_3_URLify {
    public String URLify(String s) {
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
