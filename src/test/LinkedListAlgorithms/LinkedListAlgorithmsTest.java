package test.LinkedListAlgorithms;

import java.util.List;
import main.LinkedListAlgorithms.CustomLinkedList;
import main.LinkedListAlgorithms.GenericCustomLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;


public class LinkedListAlgorithmsTest {
  @Test
  public void CustomLinkedInListTest() {
    CustomLinkedList customLinkedList = new CustomLinkedList();
    customLinkedList.add("A");
    customLinkedList.add("B");
    customLinkedList.add("c");
    customLinkedList.add("b");
    customLinkedList.add("Z");

    assertEquals(5,customLinkedList.size());
    customLinkedList.removeFirst();
    assertEquals(4,customLinkedList.size());

    customLinkedList.reverse();
  }

  @Test
  public void GenericCustomLinkedInListTest() {
    GenericCustomLinkedList<String> genericCustomLinkedList1 = new GenericCustomLinkedList<>();
    genericCustomLinkedList1.add("A");
    genericCustomLinkedList1.add("B");
    genericCustomLinkedList1.add("c");
    genericCustomLinkedList1.add("b");
    genericCustomLinkedList1.add("Z");

    assertEquals(5,genericCustomLinkedList1.size());
    genericCustomLinkedList1.removeFirst();
    assertEquals(4,genericCustomLinkedList1.size());

    GenericCustomLinkedList<Integer> genericCustomLinkedList2 = new GenericCustomLinkedList<>();
    genericCustomLinkedList2.add(1);
    genericCustomLinkedList2.add(2);
    genericCustomLinkedList2.add(3);
    genericCustomLinkedList2.add(4);

    assertEquals(4,genericCustomLinkedList2.size());
    genericCustomLinkedList2.removeFirst();
    assertEquals(3,genericCustomLinkedList2.size());
  }

  @Test
  public void deleteBackHalfTest() {
    CustomLinkedList customLinkedList = new CustomLinkedList();
    customLinkedList.deleteBackHalf();
    assertEquals(0,customLinkedList.size());

    customLinkedList.add("A");
    customLinkedList.deleteBackHalf();
    assertEquals(1,customLinkedList.size());

    customLinkedList.add("B");
    customLinkedList.add("c");
    customLinkedList.add("b");
    customLinkedList.add("Z");

    assertEquals(5,customLinkedList.size());
    customLinkedList.deleteBackHalf();
    assertEquals(2,customLinkedList.size());

    customLinkedList = new CustomLinkedList();
    customLinkedList.deleteBackHalf_smarter();
    assertEquals(0,customLinkedList.size());

    customLinkedList.add("A");
    customLinkedList.deleteBackHalf_smarter();
    assertEquals(1,customLinkedList.size());

    customLinkedList.add("B");
    customLinkedList.add("c");
    customLinkedList.add("b");
    customLinkedList.add("Z");

    assertEquals(5,customLinkedList.size());
    customLinkedList.deleteBackHalf_smarter();
    assertEquals(2,customLinkedList.size());
  }

  @Test
  public void kthNodeFromEndTest() {
    GenericCustomLinkedList<Integer> genericCustomLinkedList = new GenericCustomLinkedList<>();
    genericCustomLinkedList.kthNodeFromEnd(1);
    assertArrayEquals(new Integer[]{}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.add(5);
    genericCustomLinkedList.add(7);
    genericCustomLinkedList.add(11);
    genericCustomLinkedList.add(2);
    genericCustomLinkedList.add(18);

    List<Integer> elements = genericCustomLinkedList.getElements();
    assertArrayEquals(new Integer[]{5, 7, 11, 2, 18}, elements.toArray());
    genericCustomLinkedList.kthNodeFromEnd(1);
    assertArrayEquals(new Integer[]{5, 7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd(4);
    assertArrayEquals(new Integer[]{7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd(2);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd(3);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd(0);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());
  }

  @Test
  public void kthNodeFromEnd_withoutExtraStorageTest() {
    GenericCustomLinkedList<Integer> genericCustomLinkedList = new GenericCustomLinkedList<>();
    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(1);
    assertArrayEquals(new Integer[]{}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.add(5);
    genericCustomLinkedList.add(7);
    genericCustomLinkedList.add(11);
    genericCustomLinkedList.add(2);
    genericCustomLinkedList.add(18);

    List<Integer> elements = genericCustomLinkedList.getElements();
    assertArrayEquals(new Integer[]{5, 7, 11, 2, 18}, elements.toArray());
    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(1);
    assertArrayEquals(new Integer[]{5, 7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(4);
    assertArrayEquals(new Integer[]{7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(2);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(3);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd_withoutExtraStorage(0);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());
  }

  @Test
  public void kthNodeFromEnd_prescribedSolutionTest() {
    GenericCustomLinkedList<Integer> genericCustomLinkedList = new GenericCustomLinkedList<>();
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(1);
    assertArrayEquals(new Integer[]{}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.add(5);
    genericCustomLinkedList.add(7);
    genericCustomLinkedList.add(11);
    genericCustomLinkedList.add(2);
    genericCustomLinkedList.add(18);

/*    genericCustomLinkedList.add(3);
    genericCustomLinkedList.add(4);
    genericCustomLinkedList.add(5);
    genericCustomLinkedList.add(6);
    genericCustomLinkedList.add(1);

    List<Integer> elements = genericCustomLinkedList.getElements();
    assertArrayEquals(new Integer[]{3, 4, 5, 6, 1}, elements.toArray());
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(2);
    assertArrayEquals(new Integer[]{3, 4, 5, 1}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(4);
    assertArrayEquals(new Integer[]{4, 5, 1}, genericCustomLinkedList.getElements().toArray()); */

    List<Integer> elements = genericCustomLinkedList.getElements();
    assertArrayEquals(new Integer[]{5, 7, 11, 2, 18}, elements.toArray());
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(1);
    assertArrayEquals(new Integer[]{5, 7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(4);
    assertArrayEquals(new Integer[]{7, 11, 2}, genericCustomLinkedList.getElements().toArray());
    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(2);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(3);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());

    genericCustomLinkedList.kthNodeFromEnd_prescribedSolution(0);
    assertArrayEquals(new Integer[]{7, 2}, genericCustomLinkedList.getElements().toArray());
  }
}
