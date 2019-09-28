package HackerRank.hash_table;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class SherlokAndAnagram {
  public static void main(String[] args) {
    System.out.println(sherlockAndAnagrams("cdcd"));
  }

  static int sherlockAndAnagrams(String s) {
    ArrayList<String> subStrList = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length() + 1; j++) {
        subStrList.add(s.substring(i,j));
      }
    }

    int count = 0;
    for (int i = 0; i < subStrList.size(); i++) {
      for (int j = i + 1; j < subStrList.size(); j++) {
        if(subStrList.get(i).length() == subStrList.get(j).length()){
          if(isAnag(subStrList.get(i), subStrList.get(j))){
            count ++;
          }
        }
      }
    }
    return count;
  }

  static boolean isAnag(String s1, String s2){
    HashMap<Character, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if(hashMap.containsKey(c)){
        hashMap.replace(c, hashMap.get(c) + 1);
      }else {
        hashMap.put(c, 1);
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if(hashMap.containsKey(c)){
        int temp = hashMap.get(c)  - 1;
        if(temp < 0){
          return false;
        }
        hashMap.replace(c,  temp);
      }else {
        return false;
      }
    }
    for (int i : hashMap.values()) {
      if(i != 0){
        return false;
      }
    }
    return true;
  }

}
