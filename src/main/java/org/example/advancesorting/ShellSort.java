package advancesorting;

import java.util.Arrays;
import util.SleepUtil;

public class ShellSort {

    public ShellSort() {}

    public void sort(int[] arr) {
        int n = arr.length;

        System.out.println("Initial Array: " + Arrays.toString(arr));
        System.out.println("=====================================");

        // Mulai dengan gap besar, lalu mengecil
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\n🔹 Current Gap: " + gap);
            SleepUtil.sleepMillis(1000);

            // Lakukan insertion sort dengan jarak 'gap'
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                System.out.println(
                    "   Considering element " + temp + " at index " + i
                );
                SleepUtil.sleepMillis(1000);

                // Geser elemen yang lebih besar sejauh gap
                while (j >= gap && arr[j - gap] > temp) {
                    System.out.println(
                        "   ↔ " +
                            arr[j - gap] +
                            " > " +
                            temp +
                            " → moving " +
                            arr[j - gap] +
                            " to index " +
                            j
                    );
                    arr[j] = arr[j - gap];
                    j -= gap;
                    System.out.println(
                        "     Array now: " + Arrays.toString(arr)
                    );
                    SleepUtil.sleepMillis(1000);
                }

                // Tempatkan elemen di posisi yang tepat
                arr[j] = temp;
                System.out.println("   Placed " + temp + " at index " + j);
                System.out.println("   Current array: " + Arrays.toString(arr));
                SleepUtil.sleepMillis(1000);
            }

            System.out.println("-------------------------------------");
        }

        System.out.println("\n Final Sorted Array: " + Arrays.toString(arr));
    }
}
