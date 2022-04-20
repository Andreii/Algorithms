/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.data_structures;

import java.util.BitSet;

public class Bitset_algo {
    public static void main(String[] args) {
        BitSet bitset = new BitSet(100);

        bitset.set(3);
        bitset.set(4);
        bitset.set(5);


        bitset = bitset.get(1, bitset.length());
        System.out.println(bitset.toString());
    }
}
