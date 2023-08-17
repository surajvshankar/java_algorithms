package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Algorithms {
  /**
   * Find the maximum among three numbers.
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static int findMaximum(int a, int b, int c) {
    if (a > b) {
      if (a > c) {
        return a;
      } else {
        return c;
      }
    }
    if (b > c) {
      return b;
    }
    return c;
  }

  /**
   * Using a placeholder (more space, less conditions)
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static int findMaximum2(int a, int b, int c) {
    int max = a;
    if(b > max) {
      max = b;
    }
    if(c > max) {
      max = c;
    }
    return max;
  }

  /**
   * Using streams (and sort).
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static int my_findMaximum(int a, int b, int c) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(a, b, c));
    return nums.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
  }

  /**
   * Using stream and Max
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static int my_findMaximum_betterStill(int a, int b, int c) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(a, b, c));
    return nums.stream().max(Integer::compareTo).get();
  }

  public static void main(String[] args) {
    System.out.println(findMaximum(1, 2, 3));
    System.out.println(findMaximum(8, 8, 1));
    System.out.println(findMaximum(3, 2, 3));
    System.out.println(findMaximum(1, 1, 9));
    System.out.println(findMaximum(1, 9, 9));
  }
}
