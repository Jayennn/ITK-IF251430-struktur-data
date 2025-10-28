package org.datastructures.sorting.sort;

import java.util.Arrays;
import org.datastructures.util.SleepUtil;

public class BubbleSort {

    public void sort(int[] array) {
        int n = array.length;
        boolean swapped;

        System.out.println("Initial Array: " + Arrays.toString(array));
        System.out.println("-------------------------------------");

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("\n▶ Pass " + (i + 1));

            for (int j = 0; j < n - i - 1; j++) {
                System.out.println(
                    "  Comparing " + array[j] + " and " + array[j + 1]
                );

                if (array[j] > array[j + 1]) {
                    System.out.println(
                        "    Swapping -> " + array[j] + " and " + array[j + 1]
                    );

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    SleepUtil.sleepMillis(800);

                    System.out.println(
                        "    Array after swap: " + Arrays.toString(array)
                    );
                    swapped = true;
                }
            }

            if (!swapped) {
                System.out.println(
                    "  No swaps in this pass → Array is sorted early!"
                );
                break;
            }
            System.out.println("-------------------------------------");
        }

        System.out.println("\n✅ Sorted Array: " + this.toString());
    }

    public static void main(String[] args) {
        int[] data = { 5, 1, 4, 2, 8 };
        BubbleSort bs = new BubbleSort();
        bs.sort(data);
    }
}
