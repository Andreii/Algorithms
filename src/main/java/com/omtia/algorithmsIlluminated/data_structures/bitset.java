/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.data_structures;

import java.util.BitSet;
import java.util.stream.IntStream;

public class bitset {
    public static final int N = 100;

    static BitSet stringToBitSet(String bitArray) {
        String array = bitArray.replace(" ", "");
        BitSet bs = new BitSet(array.length());
        for(int i = 0; i < array.length(); i++) {
            if(array.charAt(i) == '1') bs.set(i);
        }
        return bs;
    }

    static int toInteger(BitSet bs) {
        int result = 0;
        for(int i = 0; i < bs.length(); i++) {
            result += (bs.get(i)) ? 1 << i : 0;
        }
        return  result;
    }

    public static void main(String[] args) {

        BitSet bitset = new BitSet(N);
        bitset.set(3);
        bitset.set(4);
        bitset.set(5);

        printBitset(bitset);
        bitset = bitset.get(1, bitset.length());
        printBitset(bitset);
        System.out.println(bitset.cardinality());

        BitSet b1 = stringToBitSet("0 1 1 0 0 1 1 0 0 1 0 1 1 1 1 1 1 0 1 0 1 1 0 1");
        BitSet b2 = stringToBitSet("0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 1 0 1 0 0 1 0 1");

        printBitset(b1);
        printBitset(b2);

        System.out.println("Bitset 1 integer ->" + toInteger(b1));
        System.out.println("Bitset 2 integer ->" + toInteger(b2));

        b1.xor(b2);

        System.out.println("Cardinality of b1 xor b2 -> " + b1.cardinality());
    }

    private static void printBitset(BitSet bitSet) {
        System.out.println(IntStream.range(0, N).mapToObj(i -> bitSet.get(N - i - 1) ? "1" : "0").collect(
                () -> new StringBuilder(N),
                StringBuilder::append,
                StringBuilder::append

        ).toString() + " " + bitSet.cardinality());
    }
}
