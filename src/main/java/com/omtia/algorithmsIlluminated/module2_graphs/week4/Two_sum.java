/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module2_graphs.week4;

import java.io.File;
import java.util.*;

/**
 * The goal of this problem is to implement a variant of the 2-SUM algorithm covered in this week's lectures.
 *
 * The file contains 1 million integers, both positive and negative (there might be some repetitions!).This is your
 * array of integers, with the i^{th}i
 * th
 *   row of the file specifying the i^{th}i
 * th
 *   entry of the array.
 *
 * Your task is to compute the number of target values tt in the interval [-10000,10000] (inclusive) such that there
 * are distinct numbers x,yx,y in the input file that satisfy x+y=tx+y=t. (NOTE: ensuring distinctness requires a
 * one-line addition to the algorithm from lecture.)
 *
 * Write your numeric answer (an integer between 0 and 20001) in the space provided.
 *
 * OPTIONAL CHALLENGE: If this problem is too easy for you, try implementing your own hash table for it. For example,
 * you could compare performance under the chaining and open addressing approaches to resolving collisions.
 */
public class Two_sum {

    private static final int RANGE_LEFT = -10_000;
    private static final int RANGE_RIGHT = 10_000;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("algorithms_illuminated/resources/2sum.txt"));
//        Scanner in = new Scanner(new File("algorithms_illuminated/resources/2sum_test4.txt"));
        // 2sum_test -> 3,10 -> 8
        // 2sum_test2 -> 10,40 -> 11
        // 2sum_test3 -> 1,10 -> 2
        // 2sum_test4 -> 30,40 -> 0
        // 2sum_test4 -> 3,4 -> 2
        List<Long> sortedList = new ArrayList<>();
        Set<Long> answerSet = new HashSet<>();

        Long number;
        while(in.hasNext()) {
            number = in.nextLong();
            sortedList.add(number);
        }

        Collections.sort(sortedList);
        for(Long x : sortedList) {
            int startIndex = Collections.binarySearch(sortedList, RANGE_LEFT - x),
                endIndex = Collections.binarySearch(sortedList, RANGE_RIGHT - x);

            if(startIndex < 0) {
                startIndex = -startIndex-1;
            }

            if(endIndex < 0) {
                endIndex = -endIndex-1;
            }

            for(int i = startIndex; i < endIndex; i++) {
                Long y = sortedList.get(i);
                long t = x+sortedList.get(i);
                if(answerSet.contains(t)) continue;
                if (!x.equals(y) && t >= RANGE_LEFT && t <= RANGE_RIGHT ) answerSet.add(t);
            }
        }

        System.out.printf("Answer is the following: %d\n", answerSet.size());
    }
}
