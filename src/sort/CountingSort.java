package sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 0, 4, 3, 6, 5, 8, -2, 1, 3, 0, 3,6, 5, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //非基于比较的排序算法
    private static void sort(int[] arr) {
        System.out.println("original array: " + Arrays.toString(arr));
        int min = arr[0];
        int max = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
                continue;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        int newLen = max - min + 1;
        int[] count = new int[newLen];
        for (int i = 0; i < len; i++) {
            int j = arr[i] - min;
            count[j]++;
        }
        System.out.println("count array: " + Arrays.toString(count));
        int x = 0;
        for (int i = 0; i < newLen; i++) {
            for (int c = count[i]; c > 0; c--) {
                arr[x++] = i + min;
            }
        }
    }
}
