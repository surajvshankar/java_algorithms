package test;

import java.util.Arrays;
import org.junit.Test;

import static main.ArrayAlgorithms.*;
import static org.junit.Assert.*;


public class ArrayAlgorithmsTest {
  @Test
  public void linearSearchTest() {
    assertEquals(4, (int) linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 4));
    assertEquals(-1, (int) linearSearch(new int[]{1, 2, 3, 4, 5, 6}, 22));

    assertTrue(linearSearch2(new int[]{1, 2, 3, 4, 5, 6}, 4).isPresent());
    assertFalse(linearSearch2(new int[]{1, 2, 3, 4, 5, 6}, 22).isPresent());
  }

  @Test
  public void binarySearchTest() {
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 50));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 7));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 92));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 0));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 50));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 7));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 92));
    assertTrue(binarySearch_bad(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 0));
    assertFalse(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 40));
    assertFalse(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 8));
    assertFalse(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, 93));
    assertFalse(binarySearch_bad(new int[]{0, 7, 10, 20, 39, 50, 92}, -1));

    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 50));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 7));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 92));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 0));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 50));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 7));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 92));
    assertTrue(binarySearch(new int[]{0, 7, 10, 20, 40, 39, 50, 92}, 0));
    assertFalse(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 40));
    assertFalse(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 8));
    assertFalse(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, 93));
    assertFalse(binarySearch(new int[]{0, 7, 10, 20, 39, 50, 92}, -1));


    int lookFor = 1800;
    /*
    int max = 201;
    Random rand = new Random();
    int[] samples = new int[max];
    samples[0] = lookFor;
    //samples = rand.ints(200, 1000, 2000).toArray();
    for (int i=1; i < samples.length; i++) {
      samples[i] = rand.nextInt(1000, 2000);
      System.out.printf(samples[i] + ",");
    }
    */

    int[] samples = new int[]{
        1538,1426,1814,1860,1849,1559,1125,1166,1881,1077,1785,1947,1938,1676,1305,1609,1921,1880,1613,1214,1276,1254,
        1081,1664,1630,1582,1665,1972,1512,1141,1488,1929,1304,1126,1297,1960,1907,1437,1886,1931,1326,1640,1782,1519,
        1034,1242,1296,1895,1646,1204,1462,1406,1718,1986,1902,1081,1073,1464,1874,1287,1641,1903,1895,1997,1292,1593,
        1698,1586,1991,1996,1190,1876,1217,1398,1147,1814,1157,1053,1192,1927,1970,1089,1929,1695,1141,1049,1971,1664,
        1942,1679,1052,1495,1504,1281,1256,1037,1865,1533,1967,1063,1393,1880,1218,1486,1808,1331,1915,1404,1136,1018,
        1716,1060,1618,1930,1896,1076,1748,1295,1015,1034,1352,1791,1573,1384,1151,1831,1089,1213,1204,1711,1754,1554,
        1350,1620,1885,1853,1397,1307,1148,1709,1470,1557,1193,1796,1433,1835,1545,1226,1240,1279,1443,1763,1738,1868,
        1967,1607,1445,1476,1019,1161,1113,1324,1937,1583,1289,1885,1549,1790,1061,1194,1137,1894,1075,1217,1315,1649,
        1837,1240,1151,1044,1963,1190,1158,1327,1145,1355,1856,1535,1411,1916,1373,1229,1284,1895,1207,1291,1695,1295,
        1171,1842,1800};
//    samples = Arrays.stream(samples).sorted().toArray();
//        System.out.println(Arrays.toString(samples));

    assertTrue(binarySearch_bad(samples, lookFor));
    assertTrue(binarySearch(samples, lookFor));
//    assertTrue(binarySearch_practice(samples, lookFor));
  }

  @Test
  public void findEvenNumsTest() {
    int[] arr1 = new int[]{-9, 3, 2, -8, 12, -16};
    int[] arr2 = new int[]{0, -3, -8, -35, 40, 20, 7};

    int[] result = new int[]{2, -8, 12, -16, 0, -8, 40, 20};
    assertArrayEquals(result, findEvenNums(arr1, arr2));
    assertArrayEquals(result, findEvenNums2(arr1, arr2));
  }

  @Test
  public void reverseTest() {
    int[] arrEven = new int[]{1,2,3,4,5,6};
    int[] arrOdd = new int[]{1,2,3,4,5,};
    assertArrayEquals(new int[]{6,5,4,3,2,1}, reverse(arrEven));
    assertArrayEquals(new int[]{5,4,3,2,1}, reverse(arrOdd));
    reverseInSitu(arrEven);
    reverseInSitu(arrOdd);
    assertArrayEquals(new int[]{6,5,4,3,2,1}, arrEven);
    assertArrayEquals(new int[]{5,4,3,2,1}, arrOdd);
  }

  @Test
  public void rotateAnArrayTest() {
    int[] testCase = new int[]{1,2,3,4,5,6};

    assertArrayEquals(new int[]{6,1,2,3,4,5}, rotateAnArrayRight(testCase, 1));
    assertArrayEquals(new int[]{2,3,4,5,6,1}, rotateAnArrayLeft(testCase, 1));

    // Multi-step
    assertArrayEquals(new int[]{5,6,1,2,3,4}, rotateAnArrayRight(testCase, 2));
    assertArrayEquals(new int[]{3,4,5,6,1,2}, rotateAnArrayLeft(testCase, 2));

    // In-place
    rotateRightInSitu(testCase, 1);
    assertArrayEquals(new int[]{6,1,2,3,4,5}, testCase);

    testCase = new int[]{1,2,3,4,5,6};
    rotateLeftInSitu(testCase, 1);
    assertArrayEquals(new int[]{2,3,4,5,6,1}, testCase);

    // Multi-step
    testCase = new int[]{1,2,3,4,5,6};
    rotateRightInSitu(testCase, 2);
    assertArrayEquals(new int[]{5,6,1,2,3,4}, testCase);

    testCase = new int[]{1,2,3,4,5,6};
    rotateLeftInSitu(testCase, 2);
    assertArrayEquals(new int[]{3,4,5,6,1,2}, testCase);

  }
}
