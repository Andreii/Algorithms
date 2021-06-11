package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median_maintenence {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/Median.txt"));
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        Integer sum = 0;
        int k = 3;
        int first = in.nextInt();
        int second = in.nextInt();
        int min = Math.min(first, second);
        int max = Math.max(first, second);

        leftQueue.add(min);
        rightQueue.add(max);

        sum += first + min;

        while(in.hasNext()) {
            Integer number = in.nextInt();

            assert rightQueue.peek() != null;
            if(number < rightQueue.peek()) {
                leftQueue.add(number);
            } else {
                rightQueue.add(number);
            }

            if(rightQueue.size() - leftQueue.size() == 2) {
                leftQueue.add(rightQueue.poll());
            } else if (leftQueue.size() - rightQueue.size() == 2){
                rightQueue.add(leftQueue.poll());
            }

            if(k % 2 == 0 || leftQueue.size() > rightQueue.size()) {
                sum += leftQueue.peek();
            } else {
                sum += rightQueue.peek();
            }

            k++;
        }

        System.out.printf("Result is: %d", sum);
    }
}
