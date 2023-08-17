package main.TreeAlgorithms;

public class BinarySearchTree {
  /**
   * Using Recursion.
   */
  protected BinaryNode<Integer> root;

  public void insert(int data) {
    this.root = insert(this.root, data);
  }

  private BinaryNode<Integer> insert(BinaryNode<Integer> root, int data) {
    if(root == null) {
      root = new BinaryNode<>(data);
    } else if (data > root.getData()) {
      root.setRight(insert(root.getRight(), data));
    } else if(data < root.getData()) {
      root.setLeft(insert(root.getLeft(), data));
    }
    return root;
  }

  // Challenge 6
  public boolean search(int data) {
    return search(root, data);
  }

  private boolean search(BinaryNode<Integer> root, int data) {
    if (root == null) {
      return false;
    } else if(root.getData() == data) {
      return true;
    } else if (data > root.getData()) {
      return search(root.getRight(), data);
    }
    return search(root.getLeft(), data);
  }
}
