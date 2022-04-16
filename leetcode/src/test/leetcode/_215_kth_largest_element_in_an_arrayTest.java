package leetcode;

import org.testng.annotations.Test;
import un._215_kth_largest_element_in_an_array;

import static org.testng.Assert.*;

public class _215_kth_largest_element_in_an_arrayTest {

    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        _215_kth_largest_element_in_an_array c = new _215_kth_largest_element_in_an_array();

        assertEquals(c.findKthLargest(nums, k), 5);
        assertEquals(c.findKthLargest2(nums, k), 5);
    }
}