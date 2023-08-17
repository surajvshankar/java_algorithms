package test.TreeAlgorithms;

import java.util.Arrays;
import main.TreeAlgorithms.BinaryNode;
import main.TreeAlgorithms.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BinaryTreeTest {
  protected BinaryTree binaryTree;

  @Before
  public void setUp() {
    //        5
    //     2        4
    //   9    10  7
    BinaryNode<Integer> rootNode = new BinaryNode<>(5);
    BinaryNode<Integer> nodeTwo = new BinaryNode<>(2);
    BinaryNode<Integer> nodeFour = new BinaryNode<>(4);
    BinaryNode<Integer> nodeNine = new BinaryNode<>(9);
    BinaryNode<Integer> nodeTen = new BinaryNode<>(10);
    BinaryNode<Integer> nodeSeven = new BinaryNode<>(7);

    rootNode.setLeft(nodeTwo);
    rootNode.setRight(nodeFour);
    nodeTwo.setLeft(nodeNine);
    nodeTwo.setRight(nodeTen);
    nodeFour.setLeft(nodeSeven);

    binaryTree = new BinaryTree(rootNode);
  }

  @Test
  public void preOrderTraversalTest() {
    int[] result = new int[]{5, 2, 9, 10, 4, 7};
    int[] preOrderTraversedElements = binaryTree.preOrderTraversal().stream().mapToInt(r -> (int) r).toArray();

    System.out.println(Arrays.toString(preOrderTraversedElements));
    assertArrayEquals(result, preOrderTraversedElements);
  }

  @Test
  public void inOrderTraversalTest() {
    int[] result = new int[]{9, 2, 10, 5, 7, 4};
    int[] inOrderTraversedElements = binaryTree.inOrderTraversal().stream().mapToInt(r -> r).toArray();

    System.out.println(Arrays.toString(inOrderTraversedElements));
    assertArrayEquals(result, inOrderTraversedElements);
  }

  @Test
  public void postOrderTraversalTest() {
    int[] result = new int[]{9, 10, 2, 7, 4, 5};
    int[] postOrderTraversedElements = binaryTree.postOrderTraversal().stream().mapToInt(r -> r).toArray();

    System.out.println(Arrays.toString(postOrderTraversedElements));
    assertArrayEquals(result, postOrderTraversedElements);
  }
}
