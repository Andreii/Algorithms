package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This problem also asks you to solve a knapsack instance, but a much bigger one.
 *
 * Download the text file below.
 *
 * knapsack_big
 * TXT File
 * Download file
 * This file describes a knapsack instance, and it has the following format:
 *
 * [knapsack_size][number_of_items]
 *
 * [value_1] [weight_1]
 *
 * [value_2] [weight_2]
 *
 * ...
 *
 * For example, the third line of the file is "50074 834558", indicating that the second item has value 50074 and size 834558, respectively.  As before, you should assume that item weights and the knapsack capacity are integers.
 *
 * This instance is so big that the straightforward iterative implemetation uses an infeasible amount of time and space.  So you will have to be creative to compute an optimal solution.  One idea is to go back to a recursive implementation, solving subproblems --- and, of course, caching the results to avoid redundant work --- only on an "as needed" basis.  Also, be sure to think about appropriate data structures for storing and looking up solutions to subproblems.
 *
 * In the box below, type in the value of the optimal solution.
 *
 * ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases. And then post them to the discussion forum!
 */
public class Knapsack_big {
    static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

   public static class Triple<T, U, V> {
        private final T first;
        private final U second;
        private final V third;

        public Triple(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }


       public T getFirst() {
           return first;
       }

       public U getSecond() {
           return second;
       }

       public V getThird() {
           return third;
       }
   }

    public static void main (String[] args) {
        try {
            Scanner scanner = new Scanner(new File("general/resources/knapsack_big.txt"));
            String[] firstLine = scanner.nextLine().split(" ");
            int C = Integer.parseInt(firstLine[0]);
            int item_count = Integer.parseInt(firstLine[1]);
            Item[] items = new Item[item_count+1];

            int item_index = 1;
            while(scanner.hasNext()) {
                String[] line = scanner.nextLine().split(" ");
                items[item_index++] = new Item(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }

            for(int i = 1; i <= item_count; i++) {
                Item item = items[i];
                System.out.printf("Item [%d] has value [%d] and weight [%d]\n",i,item.value, item.weight);
            }
            Map<String, Integer> cache = new HashMap<>();
            Long result = knapsack(0,0, item_count, C, items, cache);

            System.out.println("Solution is: " + result);

        } catch(FileNotFoundException e) { /* ignore */ }
    }

    public static long knapsack(int i, int x, int item_count, int C, Item[] items, Map<String, Integer> cache) {
        Item item = items[i];



        if(item.weight > C) {

        }

        return knapsack(++i, ++x, item_count, C, items, cache);
    }
}
