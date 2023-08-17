package main.LinkedListAlgorithms;

public class CustomLinkedList {
  private Node first;
  private Node last;

  public void add(String data) {
    if(first == null) {
      first = new Node(data);
    } else {
      Node next = first;
      Node prev = null;
      while (next != null) {
        prev = next;
        next = next.getNext();
      }
      Node node = new Node(data);
      node.setBefore(prev);
      prev.setNext(node);
      this.last = node;
    }
  }

  public int size() {
    Node next = first;
    int counter = 0;
    while(next != null) {
      ++counter;
      next = next.getNext();
    }
    return counter;
  }

  public void removeFirst() {
    this.first = first.getNext();
  }

  public void reverse() {
    Node earlier = last;
    while(earlier != null) {
      System.out.println(earlier.getData());
      earlier = earlier.getBefore();
    }
  }

  public void deleteBackHalf() {
    int counter = 1;
    int size = size();
    Node next = this.first;
    while (next != null) {
      if (counter == size / 2) {
        next.setNext(null);
      }
      next = next.getNext();
      counter++;
    }
  }

  public void deleteBackHalf_smarter() {
    if(first == null) {
      return;
    }
    Node slow = first;
    Node fast = first;
    Node prev = first;
    while(fast != null && fast.getNext() != null) {
      fast = fast.getNext().getNext();
      prev = slow;
      slow = slow.getNext();
    }
    prev.setNext(null);
  }

}
