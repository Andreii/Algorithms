package algorithms;

import java.io.File;
import java.util.*;

public class Two_sum {

    private static final int RANGE_LEFT = -10_000;
    private static final int RANGE_RIGHT = 10_000;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/2sum.txt"));
//        Scanner in = new Scanner(new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/2sum_test4.txt"));
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
