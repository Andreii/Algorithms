/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This file contains all of the 100,000 integers between 1 and 100,000 (inclusive) in some order, with no integer
 * repeated.
 *
 *  Your task is to compute the number of inversions in the file given, where the i^{th}i
 * th
 *   row of the file indicates the i^{th}i
 * th
 *   entry of an array.
 *
 *   Because of the large size of this array, you should implement the fast divide-and-conquer algorithm covered in the
 *   video lectures.
 *
 * The numeric answer for the given input file should be typed in the space below.
 *
 * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / any
 * other punctuation marks. You can make up to 5 attempts, and we'll use the best one for grading.
 *
 * (We do not require you to submit your code, so feel free to use any programming language you want --- just type the
 * final numeric answer in the following space.)
 *
 * [TIP: before submitting, first test the correctness of your program on some small test files or your own devising.
 * Then post your best test cases to the discussion forums to help your fellow students!]
 */
public class Inversions {
    public static int inversions = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("algorithms_illuminated/resources/IntegerArray.txt"));
        List<Integer> numbers = new ArrayList<>(100000);
        String line = bufferedReader.readLine();

        while(line != null) {
            numbers.add(Integer.parseInt(line));

            line = bufferedReader.readLine();
        }

        System.out.printf("Number of inversions is %f ", inversions(numbers.stream().mapToInt(i->i).toArray()));
    }

    public static double mergeSort(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0; double count = 0;
        while(i < left.length || j < right.length) {
            if(i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length - i;
                j++;
            }
        }
        return count;
    }

    public static double inversions(int[] arr) {

        if(arr.length <= 1) {
            return 0;
        }

        int half = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, half);
        int[] right = Arrays.copyOfRange(arr, half, arr.length);

        return inversions(left) + inversions(right) + mergeSort(arr, left, right);
    }
}
