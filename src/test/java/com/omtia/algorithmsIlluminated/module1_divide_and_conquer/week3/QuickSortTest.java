/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week3.QuickSort.quicksort;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void testQuicksort() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/1_QuickSort.txt"));

        int[] arrToSort = new int[10_000];
        List<Integer> arrList = new ArrayList<>(10_000);
        String line = bufferedReader.readLine();
        while(line != null) {
            arrList.add(Integer.parseInt(line));
            line = bufferedReader.readLine();
        }
        arrToSort = arrList.stream().mapToInt(i->i).toArray();
        quicksort(arrToSort, 0, arrToSort.length -1);

        assertEquals(164123, QuickSort.switches);
    }
}