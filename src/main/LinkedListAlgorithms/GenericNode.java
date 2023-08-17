package main.LinkedListAlgorithms;

public class GenericNode<T> {
  private GenericNode<T> next;

  private T data;

  public GenericNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public GenericNode<T> getNext() {
    return next;
  }

  public void setNext(GenericNode<T> next) {
    this.next = next;
  }

}
