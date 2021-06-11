package algorithms;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Two_sum {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/2sum_test.txt"));
        Set<Long> set = new HashSet<>();
        Set<Long> sortedSet = new TreeSet<>();

        while(in.hasNext()) {
            set.add(in.nextLong());
        }

        int answer = 0;
        Long y;
        int index = 0;
        for(Long x : set) {
            for(Long t = Long.valueOf(3); t <= 10; t++) {
                y = t - x;
                if(x == y) continue;
                if(set.contains(y)) {
                    set.remove(x);
                    set.remove(y);
                    answer++;
                };
            }
            index++;
            System.out.printf("At index: %d \n", index);
        }

        System.out.printf("Answer is the following: %d", answer);
    }
}
