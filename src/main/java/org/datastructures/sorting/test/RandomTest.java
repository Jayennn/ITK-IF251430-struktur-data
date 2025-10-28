package org.datastructures.sorting.test;

public class RandomTest {
  public static void main(String[] args) {

    int size = 100_000;

    SortTest sorter = new SortTest(size);

    int[] arr1 = sorter.getArrayCopy();
    long start1 = System.currentTimeMillis();
    sorter.selectionSort(arr1);
    long end1 = System.currentTimeMillis();
    System.out.println("Selection Sort selesai dalam: " + (end1 - start1) + " ms");

    int[] arr2 = sorter.getArrayCopy();
    long start2 = System.currentTimeMillis();
    sorter.insertionSort(arr2);
    long end2 = System.currentTimeMillis();
    System.out.println("Insertion Sort selesai dalam: " + (end2 - start2) + " ms");

    int[] arr3 = sorter.getArrayCopy();
    long start3 = System.currentTimeMillis();
    sorter.bubbleSort(arr3);
    long end3 = System.currentTimeMillis();
    System.out.println("Bubble Sort selesai dalam: " + (end3 - start3) + " ms");

  }
}
