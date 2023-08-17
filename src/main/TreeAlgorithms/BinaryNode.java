package main.TreeAlgorithms;

public class BinaryNode<T>{
  protected BinaryNode<T> left;
  protected BinaryNode<T> right;
  protected T data;

  public BinaryNode(T data) {
    this.data = data;
  }

  public BinaryNode<T> getLeft() {
    return left;
  }

  public void setLeft(BinaryNode<T> data) {
    this.left = data;
  }

  public BinaryNode<T> getRight() {
    return right;
  }

  public void setRight(BinaryNode<T> data) {
    this.right = data;
  }

  public T getData() {
    return data;
  }
}
