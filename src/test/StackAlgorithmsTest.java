package test;

import org.junit.Test;

import static main.StackAlgorithms.*;
import static org.junit.Assert.*;


public class StackAlgorithmsTest {
  @Test
  public void isParenthesesMatchingTest() {
    assertTrue(isParenthesesMatching("((algorithm()))"));
    assertTrue(isParenthesesMatching("()(algorithm())"));
    assertTrue(isParenthesesMatching("((algorithm))"));
    assertTrue(isParenthesesMatching("(algorithm)"));
    assertFalse(isParenthesesMatching("(algorithm("));
    assertFalse(isParenthesesMatching(")algorithm)"));
    assertFalse(isParenthesesMatching(")algorithm("));
    assertFalse(isParenthesesMatching("algorithm(("));
    assertFalse(isParenthesesMatching("(algorithm"));
    assertFalse(isParenthesesMatching("((algorithm)"));

    assertTrue(isParenthesesMatching_usingInteger("((algorithm()))"));
    assertTrue(isParenthesesMatching_usingInteger("()(algorithm())"));
    assertTrue(isParenthesesMatching_usingInteger("((algorithm))"));
    assertTrue(isParenthesesMatching_usingInteger("(algorithm)"));
    assertFalse(isParenthesesMatching_usingInteger("(algorithm("));
    assertFalse(isParenthesesMatching_usingInteger(")algorithm)"));
    assertFalse(isParenthesesMatching_usingInteger(")algorithm("));
    assertFalse(isParenthesesMatching_usingInteger("algorithm(("));
    assertFalse(isParenthesesMatching_usingInteger("(algorithm"));
    assertFalse(isParenthesesMatching_usingInteger("((algorithm)"));
  }
}
