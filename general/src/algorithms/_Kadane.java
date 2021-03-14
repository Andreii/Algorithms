package algorithms;

import java.util.HashMap;

public class _Kadane {
    public static void main(String[] args) {
        int[] array = new int[] { -2,1,-3,4,-1,2,1,-5,4 };

        System.out.printf("Maximum sum subarray is %d\n", maxSubArray(array));
        System.out.printf("Maximum sum subarray is %d, start [%d] end [%d]\n",
                maxSubArrayWithIndexes(array)[0],
                maxSubArrayWithIndexes(array)[1],
                maxSubArrayWithIndexes(array)[2]
        );
    }

    static int maxSubArray(int[] arr) {
        int sum = 0; // -2, -1
        int maxSum = Integer.MIN_VALUE;

        for (int elem : arr) {
            sum = Math.max(elem, elem + sum);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    // something is wrong here
    //
    // doesn't work for [ -1, -2 ]
    // Result is: 0
    // Expected : -1
    static int[] maxSubArrayWithIndexes(int[] arr) {
        int sum = 0; // -2, 1, -2, 4, 3, 5, 6, -1, 4
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0, lastIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] > arr[i] + sum) {
                sum = arr[i];
                startIndex = i;
            } else {
                sum = arr[i] + sum;
            }

            if (sum > maxSum) {
                maxSum = sum;
                lastIndex = i;
            }
        }

        int totalSum = 0;
        for ( int i = startIndex; i <= lastIndex; i++) {
            totalSum += arr[i];
        }

        return new int[] { maxSum, startIndex, lastIndex };
    }
}
