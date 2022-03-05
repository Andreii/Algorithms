package experimenting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 5, 4, 6, 0, 1, 19};

        test = mergeSort(test);

        for(int e : test) {
            System.out.print(e + ", ");
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        } else if (arr.length == 2) {
            return new int[] { Math.min(arr[0], arr[1]), Math.max(arr[0], arr[1]) };
        } else {
            int half = arr.length/2;
            int[] left = Arrays.copyOfRange(arr, 0, half);
            int[] right = Arrays.copyOfRange(arr, half, arr.length);

            left = mergeSort(left);
            right = mergeSort(right);

            int[] result = new int[arr.length];

            // merge
            int i = 0;
            int j = 0;
            while(i < left.length || j < right.length) {
                if(i == left.length) {
                    result[i+j] = right[j++];
                } else if(j == right.length) {
                    result[i+j] = left[i++];
                } else if(left[i] <= right[j]) {
                    result[i+j] = left[i++];
                } else {
                    result[i+j] = right[j++];
                }
            }

            return result;
        }
    }
}
