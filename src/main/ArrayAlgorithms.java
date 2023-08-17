package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;


public class ArrayAlgorithms {
  public static Integer linearSearch(int[] arr, int item) {
    return Arrays.stream(arr).filter(r -> r == item).findFirst().orElse(-1);
  }

  public static OptionalInt linearSearch2(int[] arr, int item) {
    return Arrays.stream(arr).filter(r -> r == item).findFirst();
  }

  public static boolean binarySearch_bad(int[] arr, int item) {
    // O(log(n)) time
    int[] sorted = Arrays.stream(arr).sorted().toArray();
    int index = sorted.length / 2;
    int prevIndex = -1;
    int iterations = 0;

    if (item < sorted[0] || item > sorted[sorted.length - 1]) {
      System.out.println("Element outside bounds!");
      return false;
    }

    while (true) {
      int element = sorted[index];
      ++iterations;
      if (element == item) {
        System.out.printf("Found at %d: %d%n", index, iterations);
        return true;
      }
      if (element < item) { // Move right
        prevIndex = index;
        index = index + (sorted.length - index) / 2;
      } else { // Move left
        //index = index / 2;
        index = prevIndex + ((index - prevIndex) / 2);
        if (index == prevIndex) {
          System.out.printf("Giving up at %d%n", index);
          break;
        }
      }
    }
    return false;
  }

  public static boolean binarySearch(int[] arr, int item) { // Equivalent of Arrays.binarySearch(arr, item)
    // Sorting should be done, outside the search.
    // Depending on the size, sorting can become costly.
    // Therefore, useful when data can be sorted once and searched multiple times (different elements).
    int[] sorted = Arrays.stream(arr).sorted().toArray();
    // O(log(n)) time
    int min = 0;
    int max = sorted.length - 1;
    int iterations = 0;

    while (min <= max) {
      int mid = (min + max) / 2;
      //  This (above) will fail for large values of min, max - Specifically, it fails if the sum min + max is greater
      // than the maximum positive value of int (2^31 - 1). The sum overflows to a -ve value, and the value stays -ve
      // when divided by 2. This causes an array index out-of-bounds. Use (below) instead:
      //int mid = min + (max - min) / 2;
      // OR faster:
      //int mid = (min + max) >>> 1;

      int element = sorted[mid];
      ++iterations;
      if (element == item) {
        System.out.printf("Found at %d: %d%n", mid, iterations);
        return true;
      } else if (item < element) { // Move left
        max = mid - 1;
      } else { // Move right
        min = mid + 1;
      }
    }
    return false;
  }

  /**
   * Find even numbers in two arrays.
   * @param arr1
   * @param arr2
   * @return
   */
  public static int[] findEvenNums(int[] arr1, int[] arr2) {
//    int[] result = new int[arr1.length + arr2.length];
    List<Integer> result = new ArrayList<>();

    for (int element : arr1) {
      if (element % 2 == 0) {
        result.add(element);
      }
    }
    for (int element : arr2) {
      if (element % 2 == 0) {
        result.add(element);
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * Using filter.
   * @param arr1
   * @param arr2
   * @return
   */
  public static int[] findEvenNums2(int[] arr1, int[] arr2) {
    return Stream.of(arr1, arr2).flatMapToInt(Arrays::stream).filter(r -> r % 2 == 0).toArray();
  }

  public static int[] reverse(int[] arr) {
    int[] result = new int[arr.length];
    for(int i=0; i < arr.length; i++){
      result[arr.length-i-1] = arr[i];
    }
    return result;
  }

  public static void reverseInSitu(int[] arr) {
    for(int i=0; i < arr.length/2; i++){
      int temp = arr[i];
      arr[i] = arr[arr.length-i-1];
      arr[arr.length-i-1] = temp;
    }
  }


  // Challenge 2
  public static int[] rotateAnArrayRight(int[] arr, int shiftBy) {
    int[] result = new int[arr.length];
    for (int i = shiftBy; i < arr.length + shiftBy; i++) {
      result[i % arr.length] = arr[i - shiftBy];
    }
    return result;
  }

  public static int[] rotateAnArrayLeft(int[] arr, int shiftBy) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[(shiftBy + i) % arr.length];
    }
    return result;
  }

  public static void rotateRightInSitu(int[] arr, int shiftBy) {
    int temp;
//    {1,2,3,4,5,6}
//    {6,1,2,3,4,5}
//    {5,6,1,2,3,4}
//    for (int i=arr.length-1; i>0; i--) {
//      temp = arr[i];
//      arr[i] = arr[(i+1)%arr.length];
//      arr[(i+1)%arr.length] = temp;
//    }
    do {
      for (int i = arr.length - 1; i > 0; i--) {
        temp = arr[i];
        arr[i] = arr[(i + 1) % arr.length];
        arr[(i + 1) % arr.length] = temp;
      }
    } while (--shiftBy > 0);
  }

  public static void rotateLeftInSitu(int[] arr, int shiftBy) {
//    {1,2,3,4,5,6}
//    {2,3,4,5,6,1}
    do {
      int temp;
      for (int i = 0; i < arr.length - 1; i++) {
        temp = arr[i];
        arr[i] = arr[(i + 1) % arr.length];
        arr[(i + 1) % arr.length] = temp;
      }
    } while (--shiftBy > 0);
  }
}