package test.TreeAlgorithms;

import main.TreeAlgorithms.MyBinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyBinarySearchTreeTest {
  @Test
  public void searchTest() {
    MyBinarySearchTree treeAlgorithms = new MyBinarySearchTree(5);
    treeAlgorithms.add(10);
    treeAlgorithms.add(7);
    treeAlgorithms.add(5);
    treeAlgorithms.add(3);
    treeAlgorithms.add(2);
    treeAlgorithms.add(8);

    assertTrue(treeAlgorithms.search(5));
    assertTrue(treeAlgorithms.search(10));
    assertTrue(treeAlgorithms.search(7));
    assertTrue(treeAlgorithms.search(3));
    assertTrue(treeAlgorithms.search(2));
    assertTrue(treeAlgorithms.search(8));

    assertFalse(treeAlgorithms.search(11));
    assertFalse(treeAlgorithms.search(1));
  }
}
