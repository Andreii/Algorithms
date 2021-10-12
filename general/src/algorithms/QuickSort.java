package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class QuickSort {
    private static int switches = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("general/resources/1_QuickSort.txt"));

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

    private static void quicksort(int[] arr, int l, int r) {
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
