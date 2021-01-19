package interview.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class _CountingValleys {
    public static void main(String[] args) throws IOException {

        int result = countingValleys(8, "UDDDUDUU");

        System.out.println("Result: " + result);
    }

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int v = 0;

        // U
        // D
        int altitude = 0;
        for ( int step : path.toCharArray()) {

            if (step == 'U') {
                if (altitude == -1) {
                    v ++;
                }
                altitude++;
            } else {
                altitude--;
            }
        }

        return v;
    }
}
