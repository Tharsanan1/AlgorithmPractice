package HackerRank.hash_table;

import java.util.HashMap;

public class IceCreamParlor {
  public static void main(String[] args) {

  }
  static void whatFlavors(int[] cost, int money) {
    HashMap<Integer, Integer> costForcast = new HashMap<>();
    for (int i = 0; i < cost.length; i++) {
      if(cost[i] >= money){
        continue;
      }
      else{
        if(costForcast.containsKey(cost[i])){
          System.out.println(costForcast.get(cost[i]) + " " + i);
          return;
        }
        int finalI = i;
        costForcast.computeIfAbsent(money - cost[i] , (key) -> {
          return finalI;
        });
      }
    }

  }
}
