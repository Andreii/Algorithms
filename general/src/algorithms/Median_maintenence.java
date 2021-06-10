package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median_maintenence {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/Median.txt"));
        int sum = 0;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        int k = 1;

        while(in.hasNext()) {
            Integer number = in.nextInt();

            if(leftQueue.isEmpty()) {
                leftQueue.add(number);
            } else if (rightQueue.isEmpty()) {
                rightQueue.add(number);
                if(leftQueue.peek() > rightQueue.peek()) {
                    int z = rightQueue.poll();
                    rightQueue.add(leftQueue.poll());
                    leftQueue.add(z);
                }
            } else if(number < rightQueue.peek()) {
                leftQueue.add(number);
            } else {
                rightQueue.add(number);
            }

            if(rightQueue.size() - leftQueue.size() == 2) {
                leftQueue.add(rightQueue.poll());
            } else if (leftQueue.size() - rightQueue.size() == 2){
                rightQueue.add(leftQueue.poll());
            }

            if(k % 2 == 0) {
                sum += leftQueue.peek();
            } else if (leftQueue.size() > rightQueue.size()) {
                sum += leftQueue.peek();
            } else {
                sum += rightQueue.peek();
            }

            k++;
        }

        System.out.printf("Result is: %d", sum);
    }
}
