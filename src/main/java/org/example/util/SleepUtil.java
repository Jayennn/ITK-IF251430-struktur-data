package org.example.util;

public class SleepUtil {

   public static void sleepMillis(long millis) {
      try {
         Thread.sleep(millis);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
         System.out.println("Sleep terganggu: " + e.getMessage());
      }
   }
}