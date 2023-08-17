package main.HashBasedAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import main.LinkedListAlgorithms.GenericCustomLinkedList;
import main.LinkedListAlgorithms.GenericNode;


public class HashBasedAlgorithms {
  public static void main(String[] args) {
    Employee employee1 = new Employee(1234, "Suraj", "Technology");
    Employee employee2 = new Employee(4444, "G", "Quality");
    Employee employee3 = new Employee(2222, "AndAnother", "Marketing");

    // Non-synchronized - therefore, thread unsafe.
    // Allows one null key and any number of null values.
    Map<Integer, Employee> employeesById = new HashMap<>();
    // Hashtable == synchronized
    employeesById.put(employee1.id, employee1);
    employeesById.put(employee2.id, employee2);
    employeesById.put(employee3.id, employee3);

    Employee retrievedEmployee = employeesById.get(4444);

    if (retrievedEmployee != null) {
      System.out.println(retrievedEmployee.name + " : " + retrievedEmployee.department);
    }

    System.out.println(employeesById.containsValue("Suraj"));


    Set<String> productCodes = new HashSet<>();
    productCodes.add("2T26B");
    productCodes.add("9K42P");
    productCodes.add("H5J781");

    System.out.println(productCodes.contains("H5J781"));
    System.out.println(productCodes.contains("9KTYP"));

    displayFreqOfEachElement(new int[]{4, 1, 3, 4, 5, 8, 3, 4, 4, 4, 4, 6, 5});
  }

  public static int[] presentInFirstNotSecond(int[] first, int[] second) {
    Set<Integer> secondSet = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    for(int element: second){
      secondSet.add(element);
    }
    for(int element: first) {
      if(!secondSet.contains(element)) {
        result.add(element);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void displayFreqOfEachElement(int[] arr) {
    Map<Integer, Integer> freqOfEachElement = new HashMap<>();
    for(int element : arr) {
      if(freqOfEachElement.containsKey(element)) {
        freqOfEachElement.put(element, freqOfEachElement.get(element) + 1);
      } else {
        freqOfEachElement.put(element, 1);
      }
    }
//    for(Map.Entry<Integer, Integer> freq : freqOfEachElement.entrySet()) {
//      System.out.println(freq.getKey() + " -> " + freq.getValue());
//    }
    freqOfEachElement.forEach((k, v) -> System.out.println(k + " -> " + v));
  }

  // Challenge 5

  /**
   * Determine if a LinkedList is cyclic. Linear time => O(n) and Linear space.
   * @return
   */
  public static boolean isLLCyclic(GenericCustomLinkedList<Integer> linkedList) {
    Set<GenericNode<Integer>> pointers = new HashSet<>();

    Iterator<GenericNode<Integer>> it = linkedList.iterator();
    while(it.hasNext()) {
      GenericNode<Integer> next = it.next();
      if(pointers.contains(next)) {
        return true;
      }
      pointers.add(next);
    }
    return false;
  }
}
