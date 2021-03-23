package algorithms;

public class QuickSort {
    private static int switches = 0;

    public static void main(String[] args) {
        int[] arrToSort = new int[]{ 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3},
            arrToSort2 = new int[]{ 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3},
            arrToSort3 = new int[]{ 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3, 5, 1, 4, 6, 9, 10, 20, 2, 3};

        quicksort(arrToSort, 0, arrToSort.length-1);
        System.out.printf("Amount of switches: %d \n", switches);
        switches = 0;
        quicksortLeft(arrToSort2, 0, arrToSort2.length-1);
        System.out.printf("Amount of switches: %d \n", switches);
        switches = 0;
        quicksortRight(arrToSort3, 0, arrToSort3.length-1);
        System.out.printf("Amount of switches: %d \n", switches);

        for (int e : arrToSort) {
            System.out.printf("%d, ", e);
        }
        System.out.println();
        for (int e : arrToSort2) {
            System.out.printf("%d, ", e);
        }
        System.out.println();

        for (int e : arrToSort3) {
            System.out.printf("%d, ", e);
        }
        System.out.println();

    }

    private static void quicksortLeft(int[] arr, int l, int r) {
        if (l < r) {
            int j = partition(arr,l,r);
            quicksort(arr, l, j - 1);
            quicksort(arr, j + 1, r);
        }
    }

    private static void quicksortRight(int[] arr, int l, int r) {
        if (l < r) {
            int z = arr[r];
            arr[r] = arr[l];
            arr[l] = z;
            int j = partition(arr,l,r);
            quicksort(arr, l, j - 1);
            quicksort(arr, j + 1, r);
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
        int i = l+1, z = 1;

        for(int j = l+1; j <= r; j++) {
            if(arr[j] <= arr[l]) {
                if(i != j) {
                    z = arr[i];
                    arr[i] = arr[j];
                    arr[j] = z;
                    switches++;
                }
                i++;
            }
        }

        z = arr[i-1];
        arr[i-1] = arr[l];
        arr[l] = z;

        return i-1;
    }
}
