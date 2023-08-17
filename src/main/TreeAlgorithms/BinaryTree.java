package main.TreeAlgorithms;

import java.util.ArrayList;
import java.util.List;


public class BinaryTree {
  /**
   * NOT a search Tree.
   */
  public BinaryNode<Integer> root;
  protected List<Integer> preOrderTraversedElements;
  protected List<Integer> inOrderTraversedElements;
  protected List<Integer> postOrderTraversedElements;

  public BinaryTree(BinaryNode<Integer> root) {
    this.root = root;
    preOrderTraversedElements = new ArrayList<>();
    inOrderTraversedElements = new ArrayList<>();
    postOrderTraversedElements = new ArrayList<>();
  }


  /**
   * PreOrderTraversal => Root -> Left -> Right
   * Sequential - as inserted.
   */
  public List<Integer> preOrderTraversal() {
    preOrderTraversal(this.root);
    return preOrderTraversedElements;
  }

  public void preOrderTraversal(BinaryNode<Integer> root) {
    if (root != null) {
      // System.out.print(root.getData() + " ");
      preOrderTraversedElements.add(root.getData());
      preOrderTraversal(root.getLeft());
      preOrderTraversal(root.getRight());
    }
  }

  /**
   * Left -> Root -> Right
   */
  public List<Integer> inOrderTraversal() {
    inOrderTraversal(this.root);
    return inOrderTraversedElements;
  }

  public void inOrderTraversal(BinaryNode<Integer> root) {
    if (root != null) {
      inOrderTraversal(root.getLeft());
      inOrderTraversedElements.add(root.getData());
//      System.out.print(root.getData() + " ");
      inOrderTraversal(root.getRight());
    }
  }


  /**
   * PostOrderTraversal =>  Left -> Right -> Root
   * Leaves and then the root.
   */
  public List<Integer> postOrderTraversal() {
    postOrderTraversal(this.root);
    return postOrderTraversedElements;
  }

  public void postOrderTraversal(BinaryNode<Integer> root) {
    if (root != null) {
      postOrderTraversal(root.getLeft());
      postOrderTraversal(root.getRight());
      // System.out.print(root.getData() + " ");
      postOrderTraversedElements.add(root.getData());
    }
  }
}
