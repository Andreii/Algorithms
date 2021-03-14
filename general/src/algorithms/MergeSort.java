package algorithms;

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
            int[] left = new int[half];
            int[] right = new int[half];

            // build left member array
            for(int i = 0; i < half; i++) {
                left[i] = arr[i];
            }
            // build right member array
            for(int i = 0; i < half; i++) {
                right[i] = arr[half + i];
            }

            left = mergeSort(left);
            right = mergeSort(right);

            int[] result = new int[arr.length];

            // merge
            int i = 0;
            int j = 0;
            int k = 0;
            while(i < half && j < half) {
                if(left[i] <= right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
                k++;
            }

            while(i < half) {
                result[k] = left[i];
                i++; k++;
            }

            while(j < half) {
                result[k] = right[j];
                j++; k++;
            }

            return result;
        }
    }
}
