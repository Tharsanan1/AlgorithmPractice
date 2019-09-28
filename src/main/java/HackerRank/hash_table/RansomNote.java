package HackerRank.hash_table;

import java.util.HashMap;

public class RansomNote {
  public static void main(String[] args) {

  }
  static void checkMagazine(String[] magazine, String[] note) {
    HashMap<String, Integer> hashMap = new HashMap<>();
    for (String s : note) {
      if(hashMap.containsKey(s)){
        int  i = hashMap.get(s);
        hashMap.replace(s, i+1);
      }
      else{
        hashMap.put(s,1);
      }
    }
    for (String s : magazine) {
      if(hashMap.containsKey(s)){
        int i = hashMap.get(s) - 1;
        hashMap.replace(s,i);
      }
    }
    for (Integer i : hashMap.values()) {
      if(i > 0){
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}
