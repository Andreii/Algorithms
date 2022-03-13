package data_structures;

import java.util.*;

public class PriorityQueue_Demo {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PriorityQueue<Integer> min = new PriorityQueue<>() {{ addAll(Arrays.asList(numbers)); }};

        System.out.println(min.poll());
        System.out.println(min.poll());
        System.out.println(min.poll());
    }

    public static boolean isFeasable(int[] weights, int maxWeight, int d) {
        LinkedList<Integer> q = new LinkedList<>();
        for(int w : weights) {
            q.add(w);
        }

        int sum = 0;
        while( q.size() > 0 && d >= 0 ) {
            while(q.size() > 0 && sum + q.peek() <= maxWeight) {
                sum += q.poll();
            }

            sum = 0;
            d--;
        }

        return q.size() == 0;
    }
}
