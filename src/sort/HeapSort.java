package sort;

import java.util.Arrays;

//一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。它的左右子结点下标分别为2 * i + 1和2 * i + 2
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {57, 40, 38, 11, 13, 34, 48, 75, 6, 19, 9, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i <= len; i++) {
            heaping(arr, 0, len - i);
            swap(arr, 0, len - i);
        }
    }

    private static void heaping(int[] arr, int start, int end) {
        while (start <= end) {
            order(arr, start);
            start++;
        }
    }

    private static void order(int[] arr, int i) {
        int father = (i - 1) / 2;
        if (arr[i] > arr[father]) {
            swap(arr, i, father);
            order(arr, father);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
