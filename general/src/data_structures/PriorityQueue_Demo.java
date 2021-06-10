package data_structures;

import java.util.*;

public class PriorityQueue_Demo {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {2, 4, 7 ,3, 1, 8};
        PriorityQueue<Integer> min = new PriorityQueue<>() {{ addAll(Arrays.asList(numbers)); }};

        System.out.println(min.poll());
        System.out.println(min.poll());
        System.out.println(min.poll());
    }
}
