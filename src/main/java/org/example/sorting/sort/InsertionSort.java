package sorting.sort;

import java.util.Arrays;

import util.SleepUtil;

public class InsertionSort {
  public void sort(int[] array) {
    int n = array.length;

    System.out.println("Initial Array: " + Arrays.toString(array));
    System.out.println("-------------------------------------");

    for (int i = 1; i < n; i++) {
      int key = array[i];
      int j = i - 1;

      System.out.println("\n▶ Pass " + i + ": Insert key [" + key + "]");

      while (j >= 0 && array[j] > key) {
        System.out.println("  Shifting: " + array[j] + " → position " + (j + 1));

        array[j + 1] = array[j];
        j--;

        SleepUtil.sleepMillis(800);
        System.out.println("  Current state: " + Arrays.toString(array));
      }
      array[j + 1] = key;

      System.out.println("  Insert key " + key + " at position " + (j + 1));
      System.out.println("  Array after insertion: " + Arrays.toString(array));
      System.out.println("-------------------------------------");

    }

    System.out.println("\n Sorted Array: " + Arrays.toString(array));
  }

  public static void main(String[] args) {
    int[] data = { 5, 1, 4, 2, 8 };
    InsertionSort is = new InsertionSort();
    is.sort(data);

  }
}
