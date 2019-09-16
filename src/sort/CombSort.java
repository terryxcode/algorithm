package sort;

import java.util.Arrays;

public class CombSort {
    public static void main(String[] args) {
        int[] arr = {5,3,9,12,6,1,7,2,4,11,8,10};
        sort(arr, 1.24);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, double factor) {
        int len = arr.length;
        Double gap = Math.floor(len / factor);
        while (gap >= 1) {
            for (int i = 0; i < len - gap; i++) {
                if (arr[i] > arr[i + gap.intValue()]) {
                    swap(arr, i, i + gap.intValue());
                }
            }

            if (gap > 3) {
                gap = Math.floor(gap / factor);
            } else {
                gap -= 1;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
