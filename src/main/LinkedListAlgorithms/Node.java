package main.LinkedListAlgorithms;

public class Node {
  private Node next;
  private Node before;

  private String data;

  public Node(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getBefore() {
    return before;
  }

  public void setBefore(Node before) {
    this.before = before;
  }
}
