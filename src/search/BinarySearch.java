package search;

import sort.HeapSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {57, 40, 38, 11, 13, 34, 48, 75, 6, 19, 9, 7};
        HeapSort.sort(arr);
        int dist = 119;
        int result = search(arr, dist, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }


    private static int search(int[] arr, int dist, int l, int r) {
        int len = (l + r) / 2;
        if (arr[len] == dist) {
            return len;
        }
        if (arr[len] > dist) {
            if (len == 0) {
                return -1;
            }
            return search(arr, dist, l, len);
        } else {
            if (len == arr.length - 1) {
                return -1;
            }
            return search(arr, dist, len, r);
        }
    }
}
