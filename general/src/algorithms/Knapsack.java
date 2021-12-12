package algorithms;

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
 * For example, the third line of the file is "50074 659", indicating that the second item has value 50074 and size 659, respectively.
 *
 * You can assume that all numbers are positive.  You should assume that item weights and the knapsack capacity are integers.
 *
 * In the box below, type in the value of the optimal solution.
 *
 * ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases. And then post them to the discussion forum!
 *
 */
public class Knapsack {
    public static void main(String[] args) {
        class Item {
            public int value, weight;
            Item(int value, int weight) {
                this.value = value;
                this.weight = weight;
            }
        }
        try {
            Scanner scanner = new Scanner(new File("general/resources/knapsack.txt"));

            String[] firstLine = scanner.nextLine().split(" ");
            int C = Integer.parseInt(firstLine[0]);
            int item_count = Integer.parseInt(firstLine[1]);
            List<Item> items = new ArrayList<>(item_count+1);

            int[][] A = new int[item_count+1][C+1];

            for(int i = 0; i <= C; i++) {
                A[0][i] = 0;
            }

            items.add(new Item(0,0));

            while(scanner.hasNext()) {
                String[] currentLine = scanner.nextLine().split(" ");
                items.add(new Item(Integer.parseInt(currentLine[0]), Integer.parseInt(currentLine[1])));
            }

            for(int i = 1; i <= item_count; i++) {
                for(int j = 0; j <= C; j++) {
                    Item item = items.get(i);
                    if(item.weight > j) {
                        A[i][j] = A[i-1][j];
                    } else {
                        A[i][j] = Math.max(A[i - 1][j], A[i - 1][Math.max(j - item.weight, 0)] + item.value);
                    }
                }
            }

            for(int i = 1; i <= item_count; i++) {
                Item item = items.get(i);
                System.out.printf("Item [%d] has value [%d] and weight [%d]\n", i, item.value, item.weight);
            }

            System.out.println("Result of max knapsack: " + A[item_count][C]);
        } catch (FileNotFoundException e) {
            // ignore
        }
    }
}
