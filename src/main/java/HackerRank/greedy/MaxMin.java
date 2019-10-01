package HackerRank.greedy;

import java.util.Arrays;

public class MaxMin {
  public static void main(String[] args) {

  }
  static int maxMin(int k, int[] arr) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    if(arr.length == 2){
      return arr[1] - arr[0];
    }
    for (int i = 0; i < arr.length - k; i++) {
      if(arr[k+i-1] - arr[i] < min){
        min = arr[k+i-1] - arr[i];
      }
    }
    return min;
  }
}
