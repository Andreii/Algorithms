/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.RabinKarp;

import java.util.Arrays;

public class StringMatching {

    protected static int[] P;
    protected static final int p = 131;
    protected static final int M = (int) (1e9+7);

    public static void main(String[] args) {
        String string = "testString";

        for(int character : computeRollingHash(string)) {
            System.out.println(character);
        }
    }

    public static int[] prepareP(int n) {
        P = new int[n];
        Arrays.fill(P, 0);

        P[0] = 1;

        for(int i = 1; i < n; i++) {
            P[i] = (int)((double)(P[i-1]*p) % M);
        }
        return P;
    }

    public static int[] computeRollingHash(String T) {
        int[] P = prepareP(T.length());
        int[] h = new int[T.length()];
        Arrays.fill(h, 0);

        for(int i = 0; i < T.length(); i++) {
            if( i != 0) h[i] = h[i-1];
            h[i] = (h[i] + (T.charAt(i) * P[i] % M) % M) % M;
        }
        return h;
    }
}
