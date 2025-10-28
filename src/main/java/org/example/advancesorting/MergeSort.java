package org.example.advancesorting;

import java.util.Arrays;
import org.example.util.SleepUtil;

public class MergeSort {

    public MergeSort() {}

    // Fungsi untuk menggabungkan dua subarray
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        System.out.println("\n🔹 Merging:");
        System.out.println("   Left : " + Arrays.toString(leftArr));
        System.out.println("   Right: " + Arrays.toString(rightArr));
        SleepUtil.sleepMillis(1000);

        int leftIndex = 0,
            rightIndex = 0;
        int mergeIndex = left;

        while (leftIndex < n1 && rightIndex < n2) {
            System.out.println(
                "   Comparing " +
                    leftArr[leftIndex] +
                    " and " +
                    rightArr[rightIndex]
            );
            SleepUtil.sleepMillis(1000);

            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[mergeIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[mergeIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            mergeIndex++;

            System.out.println(
                "   Current merged part: " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, mergeIndex))
            );
            SleepUtil.sleepMillis(1000);
        }

        while (leftIndex < n1) {
            arr[mergeIndex] = leftArr[leftIndex];
            leftIndex++;
            mergeIndex++;
            System.out.println(
                "   Adding remaining left → " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, mergeIndex))
            );
            SleepUtil.sleepMillis(1000);
        }

        while (rightIndex < n2) {
            arr[mergeIndex] = rightArr[rightIndex];
            rightIndex++;
            mergeIndex++;
            System.out.println(
                "   Adding remaining right → " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, mergeIndex))
            );
            SleepUtil.sleepMillis(1000);
        }

        System.out.println(
            "After Merge: " +
                Arrays.toString(Arrays.copyOfRange(arr, left, right + 1))
        );
        System.out.println("-------------------------------------");
        SleepUtil.sleepMillis(1000);
    }

    // Fungsi rekursif untuk membagi dan mengurutkan array
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            System.out.println(
                "\n Dividing: " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, right + 1))
            );
            System.out.println(
                "   Left  → " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, mid + 1))
            );
            System.out.println(
                "   Right → " +
                    Arrays.toString(Arrays.copyOfRange(arr, mid + 1, right + 1))
            );
            SleepUtil.sleepMillis(1000);

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
}
