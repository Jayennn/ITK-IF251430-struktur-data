package org.datastructures.sorting.sort;

import java.util.Arrays;

import org.datastructures.util.SleepUtil;

class SelectionSort {

  public void sort(int[] array) {
    int n = array.length;

    System.out.println("Initial Array: " + Arrays.toString(array));
    System.out.println("-------------------------------------");

    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      System.out.println("\n▶ Pass " + (i + 1) + ": Find min from index " + i + " to " + (n - 1));

      for (int j = i + 1; j < n; j++) {
        System.out.println("  Compare: array[" + j + "]=" + array[j] +
            " with current min array[" + min_idx + "]=" + array[min_idx]);

        if (array[j] < array[min_idx]) {
          min_idx = j;
          System.out.println("  ➤ New minimum found: " + array[min_idx] +
              " at index " + min_idx);
        }

        SleepUtil.sleepMillis(600);

      }

      if (min_idx != i) {
        System.out.println("  Swap: " + array[i] + " ↔ " + array[min_idx]);
        int temp = array[i];
        array[i] = array[min_idx];
        array[min_idx] = temp;
      } else {
        System.out.println("  No swap needed (already minimum).");
      }

      System.out.println("  Array after pass " + (i + 1) + ": " + Arrays.toString(array));
      System.out.println("-------------------------------------");
    }

    System.out.println("\nSorted Array: " + Arrays.toString(array));
  }

  public static void main(String[] args) {
    int[] data = { 5, 1, 4, 2, 8 };
    SelectionSort ss = new SelectionSort();
    ss.sort(data);
  }
}