package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inversions {
    public static int inversions = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/andrei/IdeaProjects/algo/general/src/algorithms/IntegerArray.txt"));
        List<Integer> numbers = new ArrayList<>(100000);
        String line = bufferedReader.readLine();

        while(line != null) {
            numbers.add(Integer.parseInt(line));

            line = bufferedReader.readLine();
        }

        System.out.printf("Number of inversions is %f ", inversions(numbers.stream().mapToInt(i->i).toArray()));
    }

    public static double mergeSort(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0; double count = 0;
        while(i < left.length || j < right.length) {
            if(i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length - i;
                j++;
            }
        }
        return count;
    }

    public static double inversions(int[] arr) {

        if(arr.length <= 1) {
            return 0;
        }

        int half = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, half);
        int[] right = Arrays.copyOfRange(arr, half, arr.length);

        return inversions(left) + inversions(right) + mergeSort(arr, left, right);
    }
}
