package HackerRank.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FrequencyQueries {
  public static void main(String[] args) {
    int i = 1000000000;
  }
  static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < queries.size(); i++) {
      int a = queries.get(i).get(0);
      int b = queries.get(i).get(1);
      if(a == 1){
        hashMap.computeIfPresent(b, (k,v) -> {
          countMap.putIfAbsent(v + 1, 1);
          countMap.computeIfPresent(v + 1, (key,val) -> {
            return val + 1;
          });
          countMap.computeIfPresent(v, (key, val) -> {
            return val - 1;
          });
          return v+1;
        });
        hashMap.computeIfAbsent(b, k -> {
          countMap.putIfAbsent(1,1);
          countMap.computeIfPresent(1, (key,val) -> {
            return val + 1;
          });
          return 1;
        });

      }
      else if(a == 2) {
        hashMap.computeIfPresent(b, (key, val) -> {
          if(val - 1 > 0){
            countMap.computeIfPresent(val , (key1,val1) -> {
              return val1 - 1;
            });
            countMap.computeIfPresent(val - 1, (key1, val1) -> {
              return val1 + 1;
            });
            countMap.computeIfAbsent(val - 1 , (key1) -> {
              return 1;
            });
          }
          return val - 1;
        });
      }
      else if(a == 3){
        if(countMap.containsKey(b)){
          if(countMap.get(b) > 0)list.add(1);
          else{
            list.add(0);
          }
        }
        else{
          list.add(0);
        }
      }
    }
    return list;
  }
}
