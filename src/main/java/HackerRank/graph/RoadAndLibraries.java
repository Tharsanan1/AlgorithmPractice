package HackerRank.graph;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RoadAndLibraries {
  public static void main(String[] args) {
//    int[][] temp = new int[][]{{2, 1},
//        {5, 3},
//        {5, 1},
//        {3, 4},
//        {3, 1},
//        {5, 4},
//        {4, 1},
//        {5 ,2},
//        {4, 2}};

    int[][] temp = new int[][]{{2, 1},
        {4, 3},
        {5, 6},
        {1,3}
    };

    System.out.println(roadsAndLibraries(7, 2, 1, temp));
  }
  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    ArrayList<HashSet<Integer>> connectedCities = new ArrayList<>();
    ArrayList<Integer> numberOfRoadsNeeded = new ArrayList<>();
    HashMap<Integer, Integer> cityIndexMap = new HashMap<>();
    boolean[] bitSet = new boolean[n];
    for (int i = 0; i < cities.length; i++) {
      int indexA = -1;
      int indexB = -1;
      int city1 = cities[i][0];
      int city2 = cities[i][1];
      bitSet[city1 - 1] = true;
      bitSet[city2 - 1] = true;
      if(cityIndexMap.containsKey(city1)){
        indexA = cityIndexMap.get(city1);
      }
      if(cityIndexMap.containsKey(city2)){
        indexB = cityIndexMap.get(city2);
      }
      if(indexA == -1 && indexB == -1){
        HashSet<Integer> tempSet = new HashSet<>();
        tempSet.add(city1);
        tempSet.add(city2);
        connectedCities.add(tempSet);
        numberOfRoadsNeeded.add(1);
        cityIndexMap.put(city1, connectedCities.size() - 1);
        cityIndexMap.put(city2, connectedCities.size() - 1);
      }
      if(indexB != indexA){
        if(indexA == -1){
          connectedCities.get(indexB).add(city1);
          cityIndexMap.put(city1, indexB);
          numberOfRoadsNeeded.set(indexB, numberOfRoadsNeeded.get(indexB) + 1);
        }
        else if(indexB == -1){
          connectedCities.get(indexA).add(city2);
          cityIndexMap.put(city2, indexA);
          numberOfRoadsNeeded.set(indexA, numberOfRoadsNeeded.get(indexA) + 1);
        }
        else{
          if(indexA > indexB){
            int temp = indexA;
            indexA = indexB;
            indexB = temp;
          }
          connectedCities.get(indexA).addAll(connectedCities.get(indexB));
          connectedCities.remove(indexB);
          numberOfRoadsNeeded.set(indexA, (numberOfRoadsNeeded.get(indexA) + numberOfRoadsNeeded.get(indexB) + 1));
          numberOfRoadsNeeded.remove(indexB);
          int finalIndexB = indexB;
          int finalIndexA = indexA;
          List<Integer> keySet = new ArrayList<>(cityIndexMap.keySet());
          for (int j = 0; j < keySet.size(); j++) {
            cityIndexMap.computeIfPresent(keySet.get(j), (key, val) -> {
              if(val == finalIndexB){
                return finalIndexA;
              }
              else{
                if(val > finalIndexB){
                  return finalIndexB - 1;
                }
                else{
                  return val;
                }
              }
            });
          }
        }
      }
    }
    long total = 0;
    if(c_lib <= c_road){
      return n * c_lib;
    }
    else{
      for (int i = 0; i < numberOfRoadsNeeded.size(); i++) {
        total += c_lib;
        total += numberOfRoadsNeeded.get(i) * c_road;
      }
    }
    for (int i = 0; i < bitSet.length; i++) {
      if(!bitSet[i]){
        total += c_lib;
      }
    }
    return total;

  }
}
