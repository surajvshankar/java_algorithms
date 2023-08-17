package main;

import java.util.LinkedList;
import java.util.Queue;


public class QueueAlgorithms {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(2);
    queue.add(3);
    queue.add(19);
    queue.add(20);

//    while(!queue.isEmpty()) { // Will not exit
//      System.out.println(queue.peek());
//    }
    while(!queue.isEmpty()) {
      System.out.println(queue.remove()); // Remove vs Poll: When empty, Remove throws an exception / Poll returns null.
      // Both, Remove and Poll returns the Head element and removes it from the FIFO queue.
      // (peek does Not remove the element from the queue)
    }

    printBinary(15);
    printBinary(-5);
    printBinary(0);
  }

  /**
   * Print N binary numbers.
   * @param n
   */
  public static void printBinary(int n) {
    if (n <= 0) {
      return;
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    for(int i=0; i < n; ++i) {
      int current = queue.remove();
      System.out.println(current);

      queue.add(current * 10);
      queue.add(current * 10 + 1);
    }
  }
}
