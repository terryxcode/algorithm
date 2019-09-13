package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int x = arr[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (j > i) {
                    if (arr[j] < x) {
                        arr[i] = arr[j];
                        break;
                    }
                    j--;
                }
                while (i < j) {
                    if (arr[i] > x) {
                        arr[j] = arr[i];
                        break;
                    }
                    i++;
                }
            }
            arr[i] = x;
            sort(arr, l, i - 1);
            sort(arr, i + 1, r);
        }
    }
}
