/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.hackerrank.warmup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _salesByMatch {
    //Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> sockPairs = new HashMap<Integer, Integer>();


        for( int sock : ar) {
            if(sockPairs.containsKey(sock)) {
                Integer count = (Integer) sockPairs.get(sock);
                sockPairs.put(sock, ++count);
            } else {
                sockPairs.put(sock, 1);
            }
        }

        int sumSocks = 0;
        for(Map.Entry<Integer, Integer> sockKV : sockPairs.entrySet()) {
            if (sockKV.getValue() % 2 == 0) {
                sumSocks += sockKV.getValue() / 2;
            }
        }

        return sumSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int result = sockMerchant(9, new int[] {10,20,20,10,10,30,50,10,20});

        System.out.println("Result " + result);
    }
}
