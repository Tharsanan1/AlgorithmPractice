package HackerRank.BaseTwo;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseTwo {
  public static void main(String[] args) {
    ArrayList<Integer> intArr = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      intArr.add(i);
    }
    int count = 0;
    long t1 = System.currentTimeMillis();
    getBaseTwoStandard(intArr);
    long t2 = System.currentTimeMillis();
    System.out.println(t2 - t1);
    t1 = System.currentTimeMillis();
    getBaseTwoNormal(intArr);
    t2 = System.currentTimeMillis();
    System.out.println(t2 - t1);


//    for(String s : getBaseTwoNormal(intArr)){
//      System.out.println(s.equals(Integer.toString(count,2)) + " " + s);
//      count++;
//    }
  }

  public static ArrayList<String> getBaseTwo(ArrayList<Integer> intArr) {
    HashMap<Integer, String> intToBase = new HashMap<>();
    ArrayList<String> resultArr = new ArrayList<>();
    for (int i : intArr) {
      if (intToBase.containsKey(i)) {
        resultArr.add(intToBase.get(i));
      } else {
        int temp = i;
        StringBuilder baseStr = new StringBuilder();
        boolean shortCutFound = false;
        while (temp > 1) {
          baseStr.insert(0, temp % 2);
          temp = temp / 2;
          if (intToBase.containsKey(temp)) {
            baseStr.insert(0, intToBase.get(temp));
            shortCutFound = true;
            break;
          }
        }
        if (!shortCutFound) {
          baseStr.insert(0, temp);
        }
        String result = baseStr.toString();
        intToBase.put(i, result);
        resultArr.add(result);
      }
    }
    return resultArr;
  }

  public static ArrayList<String> getBaseTwoNormal(ArrayList<Integer> intArr) {
    ArrayList<String> resultArr = new ArrayList<>();
    for (int i : intArr) {
      int temp = i;
      StringBuilder baseStr = new StringBuilder();
      boolean shortCutFound = false;
      while (temp > 1) {
        baseStr.insert(0, temp % 2);
        temp = temp / 2;
      }
      if (!shortCutFound) {
        baseStr.insert(0, temp);
      }
      String result = baseStr.toString();
      resultArr.add(result);

    }
    return resultArr;
  }
  public static ArrayList<String> getBaseTwoStandard(ArrayList<Integer> intArr) {
    ArrayList<String> resultArr = new ArrayList<>();
    for (int i : intArr) {
      resultArr.add(Integer.toString(i, 2));
    }
    return resultArr;
  }
}
