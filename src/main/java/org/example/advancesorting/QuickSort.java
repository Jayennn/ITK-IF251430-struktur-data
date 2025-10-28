package advancesorting;

import java.util.Arrays;
import util.SleepUtil;

public class QuickSort {

    public QuickSort() {}

    static void swap(int[] arr, int smallerElementIndex, int currentIndex) {
        int temp = arr[smallerElementIndex];
        arr[smallerElementIndex] = arr[currentIndex];
        arr[currentIndex] = temp;
    }

    static int partition(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[endIndex];
        int smallerElementIndex = startIndex - 1;

        System.out.println("\n Pivot chosen: " + pivotValue);
        System.out.println(
            "   Subarray: " +
                Arrays.toString(
                    Arrays.copyOfRange(arr, startIndex, endIndex + 1)
                )
        );

        for (
            int currentIndex = startIndex;
            currentIndex < endIndex;
            currentIndex++
        ) {
            System.out.println(
                "   Comparing " +
                    arr[currentIndex] +
                    " with pivot " +
                    pivotValue
            );
            SleepUtil.sleepMillis(1000);

            if (arr[currentIndex] < pivotValue) {
                smallerElementIndex++;
                if (smallerElementIndex != currentIndex) {
                    System.out.println(
                        "   → Swapping " +
                            arr[smallerElementIndex] +
                            " and " +
                            arr[currentIndex]
                    );
                    swap(arr, smallerElementIndex, currentIndex);
                    SleepUtil.sleepMillis(1000);
                    System.out.println(
                        "     Array after swap: " + Arrays.toString(arr)
                    );
                }
            }
        }

        swap(arr, smallerElementIndex + 1, endIndex);
        System.out.println(
            "   Placing pivot " + pivotValue + " at correct position"
        );
        SleepUtil.sleepMillis(1000);
        System.out.println(
            "   Array after pivot placement: " + Arrays.toString(arr)
        );
        System.out.println("-------------------------------------");
        SleepUtil.sleepMillis(1000);

        return smallerElementIndex + 1;
    }

    // Fungsi utama rekursif QuickSort
    public void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            System.out.println(
                "\n Sorting range: " +
                    Arrays.toString(
                        Arrays.copyOfRange(arr, startIndex, endIndex + 1)
                    )
            );
            SleepUtil.sleepMillis(1000);

            int pivotIndex = partition(arr, startIndex, endIndex);

            System.out.println(
                "   Pivot " + arr[pivotIndex] + " fixed at index " + pivotIndex
            );
            SleepUtil.sleepMillis(1000);

            sort(arr, startIndex, pivotIndex - 1); // kiri
            sort(arr, pivotIndex + 1, endIndex); // kanan
        }
    }
}
