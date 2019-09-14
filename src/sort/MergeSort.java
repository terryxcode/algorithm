package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        int[] sorted = sort(arr);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] sort(int[] arr) {
        System.out.println("sort: " + Arrays.toString(arr));
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        int[] left = Arrays.copyOf(arr, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        System.out.println("merge");
        System.out.println("left: " + Arrays.toString(left));
        System.out.println("right: " + Arrays.toString(right));
        int lLen = left.length;
        int rLen = right.length;
        int len = lLen + rLen;
        int[] result = new int[len];
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < lLen && r < rLen) {
            if (left[l] < right[r]) {
                result[i++] = left[l++];
                continue;
            }
            if (left[l] == right[r]) {
                result[i++] = left[l++];
                result[i++] = right[r++];
                continue;
            }
            if (left[l] > right[r]) {
                result[i++] = right[r++];
            }
        }
        if (l < lLen) {
            while (i < len) {
                result[i++] = left[l++];
            }
        }
        if (r < rLen) {
            while (i < len) {
                result[i++] = right[r++];
            }
        }
        return result;
    }
}
