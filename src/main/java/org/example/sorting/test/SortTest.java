package org.example.sorting.test;

import java.util.Random;

public class SortTest {
  private int[] array;

  public SortTest(int size) {
    array = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = rand.nextInt(1_000_000);
    }
  }

  public int[] getArrayCopy() {
    return array.clone();
  }

  public void bubbleSort(int[] arr) {
    int n = arr.length;
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
      swapped = false;

      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }

  public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min_idx];
      arr[min_idx] = temp;
    }
  }

  public static void main(String[] args) {
    int size = 100_000; // jumlah elemen array
    SortTest sorter = new SortTest(size);

    // --- Selection Sort ---
    int[] arr1 = sorter.getArrayCopy();
    long start1 = System.currentTimeMillis();
    sorter.selectionSort(arr1);
    long end1 = System.currentTimeMillis();
    System.out.println("Selection Sort selesai dalam: " + (end1 - start1) + " ms");

    // --- Insertion Sort ---
    int[] arr2 = sorter.getArrayCopy();
    long start2 = System.currentTimeMillis();
    sorter.insertionSort(arr2);
    long end2 = System.currentTimeMillis();
    System.out.println("Insertion Sort selesai dalam: " + (end2 - start2) + " ms");
  }
}
