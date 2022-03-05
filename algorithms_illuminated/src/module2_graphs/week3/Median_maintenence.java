package module2_graphs.week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * The goal of this problem is to implement the "Median Maintenance" algorithm (covered in the Week 3 lecture on heap
 * applications).  The text file contains a list of the integers from 1 to 10000 in unsorted order; you should treat
 * this as a stream of numbers, arriving one by one.
 *
 * In the box below you should type the sum of these 10000 medians, modulo 10000 (i.e., only the last 4 digits).
 * That is, you should compute (m_1+m_2+m_3 + \cdots + m_{10000}) \bmod 10000(m

 * OPTIONAL EXERCISE: Compare the performance achieved by heap-based and search-tree-based implementations of the
 * algorithm.
 */
public class Median_maintenence {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("algorithms_illuminated/resources/Median.txt"));
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
