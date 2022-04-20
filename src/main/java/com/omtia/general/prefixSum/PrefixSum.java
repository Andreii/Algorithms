/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.prefixSum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer target, find a subarray that sums to target and return the start and end
 * indices of the subarray. It's guaranteed to have a unique solution.
 *
 * Input:
 *
 * 1 -20 -3 30 5 4
 * 7
 * Output: 1 4
 *
 * Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive).
 */
public class PrefixSum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        // val: index
        Map<Integer,Integer> prefix = new HashMap<>();

        int n = arr.size();
        int sum = 0;

        prefix.put(0, 0);

        for(int i = 0; i < n; i++) {
            sum += arr.get(i);

            int compl = sum - target;
            if(prefix.containsKey(compl)) {
                return List.of(prefix.get(compl), i+1);
            } else {
                prefix.put(sum, i + 1);
            }
        }

        return List.of();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = subarraySum(arr, target);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
