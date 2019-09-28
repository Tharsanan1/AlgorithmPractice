package HackerRank.hash_table;

import java.util.HashMap;

public class Pairs {
  public static void main(String[] args) {
pairs(2, new int[]{1,5,3,4,2});
  }
  static int pairs(int k, int[] arr) {
    HashMap<Integer, Integer> forcastMap = new HashMap<>();
    int possibilities = 0;
    for (int i = 0; i < arr.length; i++) {
      int forcast1 = arr[i];
      int forcast2 = forcast1 - k;
      forcast1 = forcast1 + k;
      forcastMap.computeIfPresent(forcast1 , (key, val) -> {
        return val + 1;
      });
      forcastMap.computeIfPresent(forcast2, (key,val) -> {
        return val + 1;
      });
      forcastMap.putIfAbsent(forcast1, 1);
      forcastMap.putIfAbsent(forcast2, 1);
      if(forcastMap.containsKey(arr[i])){
        possibilities += forcastMap.get(arr[i]);
      }
    }
    return possibilities;
  }
}
