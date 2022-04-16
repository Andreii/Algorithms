package leetcode;

import org.testng.annotations.Test;
import un._347_top_k_frequent_elements;

import java.util.Arrays;

import static org.testng.Assert.*;

public class _347_top_k_frequent_elementsTest {

    @Test
    public void testTopKFrequent() {
        _347_top_k_frequent_elements c = new _347_top_k_frequent_elements();

        int[] res = c.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(res);
        assertEquals(res, new int[]{1,2});
    }
}