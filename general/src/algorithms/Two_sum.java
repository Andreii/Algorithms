package algorithms;

import java.io.File;
import java.util.*;

public class Two_sum {

    private static final int RANGE_LEFT = -3;
    private static final int RANGE_RIGHT = 10;


    public static void main(String[] args) throws Exception {
        // https://stackoverflow.com/questions/28951727/how-can-i-improve-my-2-sum-algorithm-for-a-range-of-numbers-using-a-hash-table
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/2sum_test.txt"));
        Set<Long> set = new HashSet<>();
        Set<Long> sortedSet = new TreeSet<>();

        Long number;
        while(in.hasNext()) {
            number = in.nextLong();
            set.add(number);
            sortedSet.add(number);
        }

        Long[] sortedArray = sortedSet.toArray(Long[]::new);
        Map<Integer, Map<Integer, Boolean>> visited = new HashMap<>();
        int answer = 0, i = 0, j = 0;
        for(Long x : set) {
            int startIndex = Arrays.binarySearch(sortedArray, RANGE_LEFT - x),
                endIndex = Arrays.binarySearch(sortedArray, RANGE_RIGHT - x), startInsertion, endInsertion;

            if(startIndex < 0) {
                startIndex = -startIndex -1;
            }

            if(endIndex < 0) {
                endIndex = -endIndex -1;
            }

            Long[] tArray = Arrays.copyOfRange(sortedArray, startIndex, endIndex);



        }

//        for(int t = 3; t <= 10; t++) {
//            for(Long x : set) {
//                if(t-x == x) continue;
//                if (set.contains(t-x)) { answer++;};
//            }
//        }

        System.out.printf("Answer is the following: %d", answer);
    }
}
