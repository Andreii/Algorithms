package algorithms;

import java.io.File;
import java.util.*;

public class Two_sum {

    private static final int RANGE_LEFT = -10_000;
    private static final int RANGE_RIGHT = 10_000;

    public static void main(String[] args) throws Exception {
        // https://stackoverflow.com/questions/28951727/how-can-i-improve-my-2-sum-algorithm-for-a-range-of-numbers-using-a-hash-table
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/2sum.txt"));
//        Scanner in = new Scanner(new File("/Users/andrei/IdeaProjects/algo/general/src/algorithms/2sum_test4.txt"));
        // 2sum_test -> 3,10 -> 8
        // 2sum_test2 -> 10,40 -> 11
        // 2sum_test3 -> 1,10 -> 2
        // 2sum_test4 -> 30,40 -> 0
        // 2sum_test4 -> 3,4 -> 2
        Set<Long> set = new HashSet<>();
        Set<Long> sortedSet = new TreeSet<>();
        List<Long> sortedList = new ArrayList<>();
        Set<Long> answerSet = new HashSet<>();

        Long number;
        while(in.hasNext()) {
            number = in.nextLong();
            set.add(number);
            sortedList.add(number);
        }

        Collections.sort(sortedList);
        for(Long x : sortedList) {
            int startIndex = Collections.binarySearch(sortedList, RANGE_LEFT - x),
                endIndex = Collections.binarySearch(sortedList, RANGE_RIGHT - x);

            if(startIndex < 0) {
                startIndex = -startIndex ;
            }

            if(endIndex < 0) {
                endIndex = -endIndex ;
            }

            endIndex = Math.min(endIndex, sortedList.size() -1);

            for(int i = startIndex; i <= endIndex; i++) {
                Long y = sortedList.get(i);
                Long t = x+y;
                if(answerSet.contains(t)) continue;
                if (!x.equals(y) && t >= RANGE_LEFT && t <= RANGE_RIGHT ) answerSet.add(x+y);
            }
        }

        // brute force
//        int answer = 0;
//        Set<Long> answerBruteForce = new HashSet<>();
//        for(int x = 0; x < sortedArray.length; x++) {
//            for (int y = x; y < sortedArray.length; y++) {
//                Long t = sortedArray[x] + sortedArray[y];
//                if(answerBruteForce.contains(t)) continue;
//                if( t >= RANGE_LEFT && t <= RANGE_RIGHT) {
//                    answerBruteForce.add(t);
//                    answer++;
//                }
//            }
//        }

        Long[] answerArr = answerSet.toArray(Long[]::new);
        Arrays.sort(answerArr);

        System.out.printf("Answer is the following: %d\n", answerSet.size());
        System.out.print("[");
        for(Long a : answerArr) {
            System.out.printf("%d, ", a);
        }
        System.out.print("]");
//        System.out.printf("Answer is the following: %d", answer);
    }
}
