package leetcode;

import org.testng.annotations.Test;
import un._1985_find_the_kth_largest_integer_in_array;

import static org.testng.Assert.*;

public class _1985_find_the_kth_largest_integer_in_arrayTest {

    @Test
    public void testKthLargestNumber() {
        String[] nums = {"3","6","7","10"};
        String[] nums2 = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};

        _1985_find_the_kth_largest_integer_in_array c = new _1985_find_the_kth_largest_integer_in_array();

        assertEquals(c.kthLargestNumber(nums, 4), "3");
        assertEquals(c.kthLargestNumber(nums2, 11), "695");
    }
}