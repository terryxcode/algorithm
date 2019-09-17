package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        int[][] bucket = new int[10][len];
        int[] count = new int[10];
        int max = getMaxNum(arr);
        int loopTimes = getLoopTimes(max);
        int pos = 1;
        while (loopTimes > 0) {
            for (int n : arr) {
                int numInPos = getNumInPos(n, pos);
                bucket[numInPos][count[numInPos]++] = n;
            }
            for (int i = 0, k = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    if (bucket[i][j] > 0) {
                        arr[k++] = bucket[i][j];
                        bucket[i][j] = 0;
                    }
                }
            }

            pos++;
            loopTimes--;
        }
    }

    private static int getLoopTimes(int max) {
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        return time;
    }

    private static int getMaxNum(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int getNumInPos(int num, int pos) {
        int factor = 1;
        while (pos > 1) {
            factor *= 10;
            pos--;
        }

        return (num / factor) % 10;
    }
}
