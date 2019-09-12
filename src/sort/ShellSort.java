package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5,3,9,12,6,1,7,2,4,11,8,10};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int length = arr.length;
        int inc = arr.length;
        while (inc > 1) {
            inc = inc / 2;
            System.out.println(inc);
            for (int j = 0; j < inc; j++) {
                for (int i = j + inc; i < length; i = i + inc) {
                    for (int h = i - inc; h >= 0 && arr[h] > arr[h + inc]; h = h - inc) {
                        int tmp = arr[h];
                        arr[h] = arr[h + inc];
                        arr[h + inc] = tmp;
                    }
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }
}
