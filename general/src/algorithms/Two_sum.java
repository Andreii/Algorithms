package algorithms;

import java.io.File;
import java.util.*;

public class Two_sum {

    private static final int RANGE_LEFT = 1;
    private static final int RANGE_RIGHT = 10;


    public static void main(String[] args) throws Exception {
        // https://stackoverflow.com/questions/28951727/how-can-i-improve-my-2-sum-algorithm-for-a-range-of-numbers-using-a-hash-table
//        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/2sum.txt"));
        Scanner in = new Scanner(new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/2sum_test3.txt"));
        // 2sum_test -> 3,10 -> 8
        // 2sum_test2 -> 10,40 -> 11
        // 2sum_test3 -> 1,10 -> 2
        Set<Long> set = new HashSet<>();
        Set<Long> sortedSet = new TreeSet<>();
        Set<Long> answerSet = new HashSet<>();

        Long number;
        while(in.hasNext()) {
            number = in.nextLong();
            set.add(number);
            sortedSet.add(number);
        }

        Long[] sortedArray = sortedSet.toArray(Long[]::new);
        for(Long x : sortedSet) {
            int startIndex = Arrays.binarySearch(sortedArray, RANGE_LEFT - x),
                endIndex = Arrays.binarySearch(sortedArray, RANGE_RIGHT - x);

            if(startIndex < 0) {
                startIndex = -startIndex ;
            }

            if(endIndex < 0) {
                endIndex = -endIndex ;
            }

            endIndex = Math.min(endIndex, sortedArray.length -1);

            for(int i = startIndex; i <= endIndex; i++) {
                Long y = sortedArray[i];
                Long t = x+y;
                if (!x.equals(y) && t >= RANGE_LEFT && t <= RANGE_RIGHT ) answerSet.add(x+y);
            }
        }

        System.out.printf("Answer is the following: %d", answerSet.size());
    }
}
