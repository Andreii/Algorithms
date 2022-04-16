package leetcode;

import org.testng.annotations.Test;
import un._378_kth_smallest_element_in_a_sorted_matrix;

import static org.testng.Assert.*;

public class _378_kth_smallest_element_in_a_sorted_matrixTest {

    @Test
    public void testKthSmallest() {
        _378_kth_smallest_element_in_a_sorted_matrix c = new _378_kth_smallest_element_in_a_sorted_matrix();

        assertEquals(c.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8), 13);
        assertEquals(c.kthSmallest2(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8), 13);
    }
}