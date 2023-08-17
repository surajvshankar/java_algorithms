package test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import static main.StringAlgorithms.*;
import static org.junit.Assert.*;


public class StringAlgorithmsTest {
  @Test
  public void isUpperCaseTest() {
    Map<String, Boolean> testCases = new HashMap<>();
    testCases.put("erww", false);
    testCases.put("ERWW", true);
    testCases.put("erWw", false);
    testCases.put("ERW!W", false);
    testCases.put("er!ww", false);
    testCases.put("", true);


    Map<String, Boolean> testCases_isLower = new HashMap<>();
    testCases_isLower.put("erww", true);
    testCases_isLower.put("ERWW", false);
    testCases_isLower.put("erWw", false);
    testCases_isLower.put("ERW!W", false);
    testCases_isLower.put("er!ww", true); // Behaves differently - Nonematch
    testCases_isLower.put("", true);  // "" isLower and isUpper

    for (Map.Entry<String, Boolean> testCase : testCases.entrySet()) {
      System.out.println("Testing isUpperCase: " + testCase.getKey());
      assertEquals(testCase.getValue(), isUpperCase(testCase.getKey()));
      System.out.println("Testing isUpperCaseStream: " + testCase.getKey());
      assertEquals(testCase.getValue(), isUpperCaseStream(testCase.getKey()));
      System.out.println("Testing isLowerCase: " + testCase.getKey());
      assertEquals(testCases_isLower.get(testCase.getKey()), isLowerCase(testCase.getKey()));
    }
  }

  @Test
  public void isPasswordStrongTest() {
    assertTrue(isPasswordStrong("he1 lloWor!d"));
    assertTrue(isPasswordStrong("Hell0"));
    assertFalse(isPasswordStrong("Hello"));
    assertFalse(isPasswordStrong("hellO"));
    assertFalse(isPasswordStrong("HeLLo"));
    assertFalse(isPasswordStrong("hello"));
    assertFalse(isPasswordStrong(" "));
  }

  @Test
  public void normalizeTest() {
    assertEquals("hello // world//", normalize(" Hello /,/ World/,/ "));
  }

  @Test
  public void isAtEvenIndexTest() {
    String s = "HeLLo";
    assertTrue(isAtEvenIndex(s, 'L'));
    assertFalse(isAtEvenIndex(s, 'T'));
    assertTrue(isAtEvenIndex(s, 'H'));
    assertFalse(isAtEvenIndex("", 'H'));
    assertFalse(isAtEvenIndex(null, 'H'));
  }

  @Test
  public void reverseTest() {
    Map<String, String> testCases = new HashMap<>();
    testCases.put("HelloWorld", "dlroWolleH");
    testCases.put("", "");
    testCases.put(null, null);
    testCases.put("Hello!World", "dlroW!olleH");

    for(Map.Entry<String, String> testCase : testCases.entrySet()) {
      assertEquals(testCase.getValue(), reverse(testCase.getKey()));
      assertEquals(testCase.getValue(), reverse2(testCase.getKey()));
    }
  }

  @Test
  public void reverseEachWordTest() {
    Map<String, String> testCases = new HashMap<>();
    testCases.put(null, null);
    testCases.put("", "");
    testCases.put(" ", " ");
    testCases.put("sally is a great worker", "yllas si a taerg rekrow");
    testCases.put("racer racecar madam", "recar racecar madam");
    testCases.put("what can I do today", "tahw nac I od yadot");
    testCases.put("what can !I do today", "tahw nac I! od yadot");
    testCases.put(" what can !I do today ", " tahw nac I! od yadot ");
    testCases.put(" what can  !I do today ", " tahw nac  I! od yadot ");

    for (Map.Entry<String, String> testCase: testCases.entrySet()) {
      assertEquals(testCase.getValue(), reverseEachWord(testCase.getKey()));
    }
  }
}
