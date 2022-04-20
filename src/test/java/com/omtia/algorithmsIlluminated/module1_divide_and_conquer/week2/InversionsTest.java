/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week2;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InversionsTest {

    @Test
    public void testInversions() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/IntegerArray.txt"));
        List<Integer> numbers = new ArrayList<>(100000);
        String line = bufferedReader.readLine();

        while(line != null) {
            numbers.add(Integer.parseInt(line));

            line = bufferedReader.readLine();
        }

        assertEquals(2407905288D, Inversions.inversions(numbers.stream().mapToInt(i->i).toArray()));
    }
}