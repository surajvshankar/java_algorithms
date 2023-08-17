package main;

import java.util.Arrays;
import java.util.Stack;


public class StackAlgorithms {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    System.out.println("START: main");
    stack.push("main");
    System.out.println("START: builder");
    stack.push("builder");
    System.out.println("START: external-service");
    stack.push("external-service");
    System.out.println("END: " + stack.pop());
    System.out.println("LOOK: " + stack.peek());
    System.out.println("START: parse-external-service");
    stack.push("parse-external-service");
    System.out.println("END: " + stack.pop());
    System.out.println("END: " + stack.pop());
    System.out.println("END: " + stack.pop());

    System.out.println();
    nextGreaterElement(new int[]{4,5,2,35});
    System.out.println();
    nextGreaterElement(new int[]{0,-1,0,0});
    System.out.println();
    nextGreaterElement(new int[]{35,5,4,2});
    System.out.println();
    nextGreaterElement(new int[]{16,7,2,15});
    nextGreaterElement(new int[]{});
    System.out.println("---");
    nextGreaterElement_efficient(new int[]{16,7,2,15});
    System.out.println();
    nextGreaterElement_efficient(new int[]{4,5,2,35});
    System.out.println();
    nextGreaterElement_efficient(new int[]{0,-1,0,0});
    System.out.println();
    nextGreaterElement_efficient(new int[]{35,5,4,2});
    System.out.println();
    nextGreaterElement_efficient(new int[]{10,7,9,9,15});
    nextGreaterElement_efficient(new int[]{});
  }

  public static void nextGreaterElement(int[] arr) {
    Stack<Integer> elements = new Stack<>();
    int greatest;
    for(int i=0; i< arr.length; i++) {
      Arrays.stream(arr).forEach(elements::push);
      greatest = -1;
      for(int p=0; p< arr.length - i; p++) {
        int element = elements.pop();
        if (element > arr[i]) {
          greatest = element;
        }
      }
      System.out.println(arr[i] + " -> " + greatest);
    }
  }

  public static void nextGreaterElement_efficient(int[] arr) {
    if(arr.length == 0) {
      return;
    }
    Stack<Integer> highest = new Stack<>();
    highest.push(arr[0]);
    for(int i=1; i< arr.length; i++) {
      int next = arr[i];
      if(next < highest.peek()) {
        highest.push(next);
      } else {
        while(!highest.isEmpty() && next > highest.peek()) {
            System.out.println(highest.pop() + " -> " + next);
        }
        highest.push(next);
      }
    }
    while(!highest.isEmpty()) {
      System.out.println(highest.pop() + " -> " + -1);
    }
  }

  public static boolean isParenthesesMatching(String paragraph) {
    Stack<Character> parentheses = new Stack<>();
    char character;
    for(int i=0; i<paragraph.length(); i++) {
      character = paragraph.charAt(i);
      if(character == '(') {
        parentheses.push(character);
      } else if (character == ')'){
        if (parentheses.isEmpty()) {
          return false;
        } else {
          parentheses.pop();
        }
      }
    }
    return parentheses.isEmpty();
  }

  public static boolean isParenthesesMatching_usingInteger(String paragraph) {
    int count = 0;
    char character;
    for(int i=0; i<paragraph.length(); i++) {
      character = paragraph.charAt(i);
      if(character == '(') {
        count++;
      } else if (character == ')'){
        if (count <= 0) {
          return false;
        } else {
          count--;
        }
      }
    }
    return (count == 0);
  }
}
