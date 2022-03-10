package module1_divide_and_conquer.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The file contains all of the integers between 1 and 10,000 (inclusive, with no repeats) in unsorted order.
 * The integer in the i^{th}i
 * th
 *   row of the file gives you the i^{th}i
 * th
 *   entry of an input array.
 *
 *  Your task is to compute the total number of comparisons used to sort the given input file by QuickSort. As you know,
 *  the number of comparisons depends on which elements are chosen as pivots, so we'll ask you to explore three
 *  different pivoting rules.
 *
 * You should not count comparisons one-by-one.  Rather, when there is a recursive call on a subarray of length mm,
 * you should simply add m-1m−1 to your running total of comparisons.  (This is because the pivot element is compared
 * to each of the other m-1m−1 elements in the subarray in this recursive call.)
 *
 * WARNING: The Partition subroutine can be implemented in several different ways, and different implementations can
 * give you differing numbers of comparisons.  For this problem, you should implement the Partition subroutine exactly
 * as it is described in the video lectures (otherwise you might get the wrong answer).
 *
 * DIRECTIONS FOR THIS PROBLEM:
 *
 * For the first part of the programming assignment, you should always use the first element of the array as the pivot
 * element.
 *
 * HOW TO GIVE US YOUR ANSWER:
 *
 * Type the numeric answer in the space provided.
 *
 * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / other
 * punctuation marks. You have 5 attempts to get the correct answer.
 *
 * (We do not require you to submit your code, so feel free to use the programming language of your choice, just type
 * the numeric answer in the following space.)
 */
public class QuickSort {
    public static int switches = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("algorithms_illuminated/resources/1_QuickSort.txt"));

        int[] arrToSort = new int[10_000];
        List<Integer> arrList = new ArrayList<>(10_000);
        String line = bufferedReader.readLine();
        while(line != null) {
            arrList.add(Integer.parseInt(line));
            line = bufferedReader.readLine();
        }
        arrToSort = arrList.stream().mapToInt(i->i).toArray();
        quicksort(arrToSort, 0, arrToSort.length -1);
        System.out.printf("Amount of comparisons: %d \n", switches);
        for (int e : arrToSort) {
            System.out.printf("%d, ", e);
        }
        System.out.println();
    }

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int i = choosePartition(arr, l, r);
            int z = arr[i];
            arr[i] = arr[l];
            arr[l] = z;
            int j = partition(arr,l,r);
            quicksort(arr, l, j - 1);
            quicksort(arr, j + 1, r);
        }
    }

    private static int choosePartition(int[] arr, int l, int r) {
        int m = (int) (l + (Math.floor((r-l)/2)));
        List<Map.Entry<Integer, Integer>> medianList = new ArrayList<>(3);
        medianList.add(new AbstractMap.SimpleEntry<Integer, Integer>(l, arr[l]));
        medianList.add(new AbstractMap.SimpleEntry<Integer, Integer>(m, arr[m]));
        medianList.add(new AbstractMap.SimpleEntry<Integer, Integer>(r, arr[r]));

        medianList.sort(Map.Entry.comparingByValue());


        //System.out.printf("Array is %d, %d, %d \n", arr[l], arr[m], arr[r]);
        //System.out.printf("Median is: %d \n", medianList.get(1).getValue());

        return r;
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l+1, z = 1;

        for(int j = l+1; j <= r; j++) {
            if(arr[j] <= arr[l]) {
                if(i != j) {
                    z = arr[i];
                    arr[i] = arr[j];
                    arr[j] = z;
                }
                i++;
            }
        }

        switches += r-l;

        z = arr[i-1];
        arr[i-1] = arr[l];
        arr[l] = z;

        return i-1;
    }
}
