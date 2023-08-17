package test.TreeAlgorithms;

import main.TreeAlgorithms.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.*;


public class BinarySearchTreeTest {
  @Test
  public void insertTest() {
    BinarySearchTree treeAlgorithms = new BinarySearchTree();
    treeAlgorithms.insert(5);
    treeAlgorithms.insert(10);
    treeAlgorithms.insert(7);
    treeAlgorithms.insert(5);
    treeAlgorithms.insert(3);
    treeAlgorithms.insert(2);
    treeAlgorithms.insert(8);

    assertTrue(treeAlgorithms.search(5));
    assertTrue(treeAlgorithms.search(10));
    assertTrue(treeAlgorithms.search(7));
    assertTrue(treeAlgorithms.search(3));
    assertTrue(treeAlgorithms.search(2));
    assertTrue(treeAlgorithms.search(8));

    assertFalse(treeAlgorithms.search(11));
    assertFalse(treeAlgorithms.search(1));
  }

  @Test
  public void searchTest() {
    BinarySearchTree treeAlgorithms = new BinarySearchTree();
    treeAlgorithms.insert(2);
    treeAlgorithms.insert(1);
    treeAlgorithms.insert(3);
    treeAlgorithms.insert(4);

    assertTrue(treeAlgorithms.search(1));
    assertTrue(treeAlgorithms.search(2));
    assertTrue(treeAlgorithms.search(3));
    assertTrue(treeAlgorithms.search(4));

    assertFalse(treeAlgorithms.search(5));
    assertFalse(treeAlgorithms.search(-4));
    assertFalse(treeAlgorithms.search(0));
    assertFalse(treeAlgorithms.search(6));
  }
}
