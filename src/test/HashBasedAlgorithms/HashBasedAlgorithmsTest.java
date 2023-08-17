package test.HashBasedAlgorithms;

import main.LinkedListAlgorithms.GenericCustomLinkedList;
import main.LinkedListAlgorithms.GenericNode;
import org.junit.Test;

import static main.HashBasedAlgorithms.HashBasedAlgorithms.*;
import static org.junit.Assert.*;


public class HashBasedAlgorithmsTest {
  @Test
  public void presentInFirstNotSecondTest() {
    assertArrayEquals(new int[]{1, 3}, presentInFirstNotSecond(new int[] {8, 0, 1, 7, 3}, new int[]{5, 7, 8, 0, 2}));
    assertArrayEquals(new int[]{1, 3}, presentInFirstNotSecond(new int[] {8, 0, 1, 7, 3}, new int[]{5, 5, 7, 8, 0, 2}));
    assertArrayEquals(new int[]{2, 4}, presentInFirstNotSecond(new int[] {1, 2, 3, 4}, new int[]{1, 3}));
  }

  /**
   * 5 -> 4 -> 3
   *      ^    ^
   *      |    |
   *      1 <- 2
   */
  @Test
  public void isLLCyclicTest() {
    GenericCustomLinkedList<Integer> linkedList = new GenericCustomLinkedList<>();
    linkedList.add(5);
    linkedList.add(4);
    linkedList.add(3);
    linkedList.add(2);
    linkedList.add(1);

    assertFalse(isLLCyclic(linkedList));

    GenericNode<Integer> two = linkedList.getNode(2);
    GenericNode<Integer> five = linkedList.getNode(5);
    five.setNext(two);

    assertTrue(isLLCyclic(linkedList));
  }
}
