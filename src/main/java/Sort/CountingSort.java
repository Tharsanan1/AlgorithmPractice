package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class CountingSort {
  public static void main(String[] args) {
    int[] arr = new int[1000];
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      arr[i] = random.nextInt(10);
    }
    for(int i : getSortedList(getCountMap(arr))){
      System.out.println(i);
    }
  }

  static HashMap<Integer, Integer> getCountMap(int[] arr){
    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      countMap.computeIfPresent(arr[i], (key,val) -> {
        return val + 1;
      });
      countMap.putIfAbsent(arr[i], 1);
    }
    return countMap;
  }

  static ArrayList<Integer> getSortedList(HashMap<Integer, Integer> countMap){
    ArrayList<Integer> uniqueVals = new ArrayList<>(countMap.keySet());
    Collections.sort(uniqueVals);
    ArrayList<Integer> sortedArray = new ArrayList<>();
    for (int i = 0; i < uniqueVals.size(); i++) {
      for (int j = 0; j < countMap.get(uniqueVals.get(i)); j++) {
        sortedArray.add(uniqueVals.get(i));
      }
    }
    return sortedArray;
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
