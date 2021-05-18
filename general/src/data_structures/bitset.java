package data_structures;

import java.util.BitSet;
import java.util.stream.IntStream;

public class bitset {
    public static final int N = 100;

    public static void main(String[] args) {

        BitSet bitset = new BitSet(N);

        bitset.set(3);
        bitset.set(4);
        bitset.set(5);

        printBitset(bitset);
        bitset = bitset.get(1, bitset.length());
        printBitset(bitset);
        System.out.println(bitset.cardinality());
    }

    private static void printBitset(BitSet bitSet) {
        System.out.println(IntStream.range(0, N).mapToObj(i -> bitSet.get(N - i - 1) ? "1" : "0").collect(
                () -> new StringBuilder(N),
                StringBuilder::append,
                StringBuilder::append

        ).toString() + " " + bitSet.cardinality());
    }
}
