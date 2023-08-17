package main.LinkedListAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GenericCustomLinkedList<T> {
  private GenericNode<T> first;

  public void add(T data) {
    if (first == null) {
      first = new GenericNode<T>(data);
    } else {
      GenericNode<T> next = first;
      GenericNode<T> prev = null;
      while (next != null) {
        prev = next;
        next = next.getNext();
      }
      GenericNode<T> node = new GenericNode<T>(data);
      prev.setNext(node);
    }
  }

  public int size() {
    GenericNode<T> next = first;
    int counter = 0;
    while (next != null) {
      ++counter;
      next = next.getNext();
    }
    return counter;
  }

  public void removeFirst() {
    this.first = first.getNext();
  }

  // Challenge 3
  /**
   * Remove the kth Node from the end.
   * @param k
   */
  public void kthNodeFromEnd(int k) {
    if (k <= 0) {
      System.out.println("Error: k needs to be greater than 0!");
      return;
    }
    if (first == null) {
      return;
    }
    // Using only forward pointer
    GenericNode<T> next = first;
    List<GenericNode<T>> nodes = new ArrayList<>();
    while (next != null) {
      nodes.add(next);
      next = next.getNext();
    }
    if (k > nodes.size()) {
      System.out.printf("Error: k needs to be less than size: %d!%n", nodes.size());
      return;
    }
    if (k == nodes.size()) {
      first = first.getNext();
    } else {
      GenericNode<T> prev = nodes.get(nodes.size() - k - 1);
      prev.setNext(nodes.get(nodes.size() - k).getNext());
    }
  }

  /**
   * Remove the kth Node from the end: by iterating the entire LinkedList twice.
   * @param k
   */
  public void kthNodeFromEnd_withoutExtraStorage(int k) {
    if (k <= 0) {
      return;
    }
    GenericNode<T> next = first;
    int count = 0;
    while (next != null) {
      ++count;
      next = next.getNext();
    }
    if (k > count) {
      return;
    } else if (first != null && k == count) {
      first = first.getNext();
      return;
    }
    next = first;
    while (next != null) {
      if (--count - k == 0) {
        next.setNext(next.getNext().getNext());
        return;
      }
      next = next.getNext();
    }
  }

  /**
   *  Remove the kth Node from the end: by maintaining two pointers, walking k elements, then finding the complement of
   * k (from the beginning), by walking the 2nd pointer until the first pointer reached the end.
   * @param k
   */
  public void kthNodeFromEnd_prescribedSolution(int k) {
    if (first == null || k == 0) {
      return;
    }
    GenericNode<T> follower = first;
    GenericNode<T> leader = first;
    for (int i = 0; i < k; i++) {
//      leader = leader.getNext();
      if (leader.getNext() == null) {
        if (i == k - 1) {
          first = first.getNext();
        }
        return;
      }
      leader = leader.getNext();
    }
    while (leader.getNext() != null) {
      follower = follower.getNext();
      leader = leader.getNext();
    }
    follower.setNext(follower.getNext().getNext());
  }

  public List<T> getElements() {
    List<T> elements = new ArrayList<>();
    GenericNode<T> next = first;
    while (next != null) {
      elements.add(next.getData());
      next = next.getNext();
    }
    return elements;
  }

  // (For) Challenge 5
  public GenericNode<T> getNode(int pos) {
    int count = 0;
    GenericNode<T> next = first;
    while (next != null) {
      if (++count == pos) {
        return next;
      }
      next = next.getNext();
    }
    return null;
  }

  public Iterator<GenericNode<T>> iterator() {
    return new Iterator<>() {
      GenericNode<T> current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public GenericNode<T> next() {
        if(hasNext()) {
          GenericNode<T> placeHolder = current;
          current = current.getNext();
          return placeHolder;
        }
        return null;
      }
    };
  }
}
