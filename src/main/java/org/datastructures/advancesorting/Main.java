package org.datastructures.advancesorting;

import org.datastructures.advancesorting.MergeSort;
import org.datastructures.advancesorting.QuickSort;
import org.datastructures.advancesorting.ShellSort;
public class Main {

    public static void main(String[] args) {
        int[] array = { 8, 3, 5, 2, 7 };

        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        ShellSort ss = new ShellSort();

        int[] arr1 = array.clone();
        qs.sort(arr1, 0, arr1.length - 1);

        int[] arr2 = array.clone();
        ms.sort(arr2, 0, arr2.length - 1);

        int[] arr3 = array.clone();
        ss.sort(arr3);
    }
}
