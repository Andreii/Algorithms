package solutions;

import org.junit.Assert;

import static org.junit.Assert.*;

public class _1662 {
    public static void main(String[] args) {
        Assert.assertEquals(arrayStringsAreEqual(new String[] {"te", "s", "t"}, new String[]{"t", "est"}), true);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // O(w1 + w2)
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < word1.length; ++i) {
            sb1.append(word1[i]);
        }

        for(int j = 0; j < word2.length; ++j) {
            sb2.append(word2[j]);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
