package module3_greedy.week4;

import java.io.File;
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
 * For example, the third line of the file is "50074 834558", indicating that the second item has value 50074 and size
 * 834558, respectively.  As before, you should assume that item weights and the knapsack capacity are integers.
 *
 * This instance is so big that the straightforward iterative implemetation uses an infeasible amount of time and space.
 * So you will have to be creative to compute an optimal solution.  One idea is to go back to a recursive
 * implementation, solving subproblems --- and, of course, caching the results to avoid redundant work --- only on an
 * "as needed" basis.  Also, be sure to think about appropriate data structures for storing and looking up solutions
 * to subproblems.
 *
 * In the box below, type in the value of the optimal solution.
 *
 * ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases. And then
 * post them to the discussion forum!
 */
public class Knapsack_big {

    private static int knapsack(int weight, int[] values, int count, int[] weights) {

        if(weight == 0 || count == 0) return 0;
        if(weights[count - 1] > weight) {
            return knapsack(weight, values, count - 1, weights);
        } else {
            return Math.max(
                    knapsack(weight, values, count - 1, weights ),
                    knapsack(weight - weights[ count - 1], values, count - 1, weights)
            );
        }
    }

    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/knapsack_big.txt"));

        String[] line = scanner.nextLine().split(" ");
        int C = Integer.parseInt(line[0]);
        int item_count = Integer.parseInt(line[1]);

        List<Integer> values = new ArrayList<>(item_count);
        List<Integer> weights = new ArrayList<>(item_count);

        while(scanner.hasNext()) {
            String[] current_line = scanner.nextLine().split(" ");
            values.add(Integer.parseInt(current_line[0]));
            weights.add(Integer.parseInt(current_line[1]));
        }

        System.out.println("Knapsack value is: " + knapsack(C,
                values.stream().mapToInt(i -> i).toArray(),
                item_count,
                weights.stream().mapToInt(i -> i).toArray()
        ));
    }
}
