package main.TreeAlgorithms;

public class MyBinarySearchTree {
  final private BinaryNode<Integer> root;

  public MyBinarySearchTree(int data) {
    root = new BinaryNode<>(data);
  }

  public void add(int data) {
    BinaryNode<Integer> thisPtr = root;
    while(thisPtr != null) {
      if (data > thisPtr.getData()) {
        if(thisPtr.getRight() == null) {
          thisPtr.setRight(new BinaryNode<>(data));
          return;
        }
        thisPtr = thisPtr.getRight();
      } else if (data < thisPtr.getData()) {
        if(thisPtr.getLeft() == null) {
          thisPtr.setLeft(new BinaryNode<>(data));
          return;
        }
        thisPtr = thisPtr.getLeft();
      } else {
        System.out.println("Data already in String");
        return;
      }
    }
  }

  public boolean search(int data) {
    BinaryNode<Integer> thisPtr = root;
    while(thisPtr != null) {
      if(thisPtr.getData() == data) {
        return true;
      } else if (data > thisPtr.getData()) {
        thisPtr = thisPtr.getRight();
      } else {
        thisPtr = thisPtr.getLeft();
      }
    }
    return false;
  }
}
