package HackerRank.hash_table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ActivityNotification {
  public static void main(String[] args) {

    activityNotifications(new int[]{10, 20, 30, 40, 50}, 3);
  }

  static int activityNotifications(int[] expenditure, int d) {
    HashMap<Integer, Integer> countMap = getCountMap(expenditure, d);

    int count = 0;
    for (int i = d; i < expenditure.length; i++) {
      float f;
      if(d%2 == 0){
        f = getMedian(countMap, true, (d/2) - 1);
      }
      else{
        f = getMedian(countMap, false, d/2);
      }
      if(f * 2 <= expenditure[i]){
        count++;
      }
      addToCountMap(countMap, expenditure[i]);
      leaveFromCountMap(countMap, expenditure[i-d]);
    }
    return count;
  }

  static HashMap<Integer, Integer> getCountMap(int[] arr, int d){
    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < d; i++) {
      countMap.computeIfPresent(arr[i], (key,val) -> {
        return val + 1;
      });
      countMap.putIfAbsent(arr[i], 1);
    }
    return countMap;
  }


  static float getMedian(HashMap<Integer, Integer> countMap, boolean isEven, int medIndex){
    ArrayList<Integer> uniqueVals = new ArrayList<>(countMap.keySet());
    Collections.sort(uniqueVals);
    int index = -1;
    for (int i = 0; i < uniqueVals.size(); i++) {
      int temp = index;
      index += countMap.get(uniqueVals.get(i));
      if(temp < medIndex && medIndex < index){
        return uniqueVals.get(i);
      }
      else if(medIndex == index){
        if(isEven){
          return (uniqueVals.get(i) + uniqueVals.get(i+1)) / (float)2.0;
        }else {
          return uniqueVals.get(i);
        }
      }
    }
    return 0;
  }


  static void addToCountMap(HashMap<Integer, Integer> countMap, int i){
    countMap.computeIfPresent(i , (key, val) -> {
      return val + 1;
    });
    countMap.putIfAbsent(i , 1);
  }

  static void leaveFromCountMap(HashMap<Integer, Integer> countMap, int i){
    countMap.computeIfPresent(i , (key, val) -> {
      if(val > 0) {
        return val - 1;
      }
      else{
        return val;
      }
    });
  }


}
