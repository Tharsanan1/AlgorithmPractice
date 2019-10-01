package HackerRank.greedy;

import java.util.Arrays;

public class GreedyFlorist {
  public static void main(String[] args) {
    getMinimumCost(2, new int[]{2,5,6});
  }
  static int getMinimumCost(int k, int[] c) {
    Arrays.sort(c);
    int mod = c.length%k;
    int times = c.length/k;
    int cost = 0;
    for (int i = 0; i < mod; i++) {
      cost += c[i] * (times + 1);
    }
    for (int i = mod; i < c.length; i = i + k) {
      for (int j = 0; j < k; j++) {
        cost+=(times*c[i+j]);
      }
      times--;
    }
    return cost;
  }
}
