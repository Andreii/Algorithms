package algorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrToSort = new int[]{ 5, 1, 4, 6, 9, 10, 20, 2, 3};

        quicksort(arrToSort, 0, arrToSort.length-1);

        for (int e : arrToSort) {
            System.out.printf("%d, ", e);
        }
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
        return l + (int) (Math.random() * (r-l));
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l+1, j = l+1, z = 1;

        while(j <= r) {
            if(arr[j] <= arr[l]) {
                if(i != j) {
                    z = arr[i];
                    arr[i] = arr[j];
                    arr[j] = z;
                }
                i++;
            }
            j++;
        }

        z = arr[i-1];
        arr[i-1] = arr[l];
        arr[l] = z;

        return i-1;
    }
}
