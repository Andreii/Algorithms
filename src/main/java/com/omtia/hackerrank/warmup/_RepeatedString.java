/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.hackerrank.warmup;


import java.io.*;
import java.util.*;

public class _RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long countA = 0;
        // O(n)
        long  r = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') countA++;
        }

        countA *= n / s.length();
        r = n % s.length();

        for(char c : s.substring(0, (int) r).toCharArray()) {
            if (c == 'a') countA++;
        }

        return countA;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();


        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);


        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();


        scanner.close();
    }
}
