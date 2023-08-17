package main.LinkedListAlgorithms;

import java.util.LinkedList;


public class LinkedListAlgorithms {
  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("A");
    linkedList.add("B");
    linkedList.add("c");
    linkedList.add("b");
    linkedList.add("Z");

    System.out.println(linkedList.contains("Bo"));
    System.out.println(linkedList.size());

    linkedList.removeFirst();

    for(String item: linkedList) {
      System.out.print(item + " -> ");
    }
    System.out.println();

    linkedList.forEach(System.out::println);
  }
}
