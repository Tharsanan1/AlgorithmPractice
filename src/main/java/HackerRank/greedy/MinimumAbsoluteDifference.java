package HackerRank.greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
  static int minimumAbsoluteDifference(int[] arr) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      int diff = arr[i] - arr[i-1];
      if(diff < min){
        min = diff;
      }
    }

    return min;
  }
}
