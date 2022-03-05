package module3_greedy.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question 1
 * In this programming problem and the next you'll code up the knapsack algorithm from lecture.
 *
 * Let's start with a warm-up.  Download the text file below.
 *
 * knapsack1
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
 * For example, the third line of the file is "50074 659", indicating that the second item has value 50074 and size 659,
 * respectively.
 *
 * You can assume that all numbers are positive.  You should assume that item weights and the knapsack capacity are
 * integers.
 *
 * In the box below, type in the value of the optimal solution.
 *
 * ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases. And then
 * post them to the discussion forum!
 *
 */
public class Knapsack {
    private static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/knapsack_big.txt"));

        String first_line = scanner.nextLine();
        int C = Integer.parseInt(first_line.split(" ")[0]);
        int item_count = Integer.parseInt(first_line.split(" ")[1]);

        int[][] dp = new int[item_count+1][C+1];

        for(int i = 0; i < C; i++) {
            dp[0][i] = 0;
        }

        List<Item> items = new ArrayList<>();

        int i = 1;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            Item item = new Item(
                    Integer.parseInt(line.split(" ")[0]),
                    Integer.parseInt(line.split(" ")[1])
            );

            for (int j = 1; j <= C; j++) {
                if (item.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], item.value + dp[i - 1][Math.max(j - item.weight, 0)]);
                }
            }
            i++;
        }

        System.out.println("The answer is: " + dp[item_count][C]);
    }
}
