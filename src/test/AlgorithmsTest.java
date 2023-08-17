package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import static main.Algorithms.*;
import static org.junit.Assert.assertEquals;

public class AlgorithmsTest {
  @Test
  public void findMaximumTest() {
    HashMap<List<Integer>, Integer> testCases = new HashMap<>();
    testCases.put(new ArrayList<>(Arrays.asList(1, 2, 3)), 3);
    testCases.put(new ArrayList<>(Arrays.asList(8, 8, 1)), 8);
    testCases.put(new ArrayList<>(Arrays.asList(3, 2, 3)), 3);
    testCases.put(new ArrayList<>(Arrays.asList(1, 1, 9)), 9);
    testCases.put(new ArrayList<>(Arrays.asList(1, 9, 9)), 9);

    for (Map.Entry<List<Integer>, Integer> testCase : testCases.entrySet() ) {
      List<Integer> nums = testCase.getKey();
      // Cast it to avoid:
      // Ambiguous method call Both assertEquals(Object, Object) in Assert and assertEquals(long, long) in Assert match:
      assertEquals((int) testCase.getValue(), findMaximum(nums.get(0), nums.get(1), nums.get(2)));
      assertEquals((int) testCase.getValue(), findMaximum2(nums.get(0), nums.get(1), nums.get(2)));
      assertEquals((int) testCase.getValue(), my_findMaximum(nums.get(0), nums.get(1), nums.get(2)));
      assertEquals((int) testCase.getValue(), my_findMaximum_betterStill(nums.get(0), nums.get(1), nums.get(2)));
    }
  }
}
