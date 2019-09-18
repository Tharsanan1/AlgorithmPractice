package HackerRank.ArrayManupulation;

import java.util.ArrayList;

public class ArrayManupulation {
  public static void main(String[] args) {
    int[][] queries = new int[4][3];
    System.out.println(queries.length);
    queries[0] = new int[]{2, 6, 8};
    queries[1] = new int[]{3, 5, 7};
    queries[2] = new int[]{1, 8, 1};
    queries[3] = new int[]{5, 9, 15};
    System.out.println(arrayManipulation(10, queries));
  }
  static long arrayManipulation(int n, int[][] queries) {
    int entries = queries.length;
    long[] values = new long[n];
    int firstIndex;
    int lastIndex;
    int valueToBeAdded;
    for (int i = 0; i < entries; i++) {
      firstIndex = queries[i][0] - 1;
      lastIndex = queries[i][1] - 1;
      valueToBeAdded = queries[i][2];
      values[firstIndex] = values[firstIndex] + valueToBeAdded;
      if(lastIndex < n - 1){
        values[lastIndex + 1] = values[lastIndex + 1] - valueToBeAdded;
      }
    }
    long totalValue = 0;
    long max = 0;
    for (int i = 0; i < n; i++) {
      totalValue += values[i];
      if(max < totalValue){
        max = totalValue;
      }
    }
    return max;
  }
}
