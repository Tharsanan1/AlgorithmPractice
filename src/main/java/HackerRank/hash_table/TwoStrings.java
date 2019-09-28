package HackerRank.hash_table;

public class TwoStrings {
  public static void main(String[] args) {

  }

  static String twoStrings(String s1, String s2) {
    boolean[] hitArr = new boolean[26];
    for (int i = 0; i < s1.length(); i++) {
      hitArr[s1.charAt(i)-97] = true;
    }
    for(int i = 0; i < s2.length(); i++){
      if(hitArr[s2.charAt(i)]){
        return "YES";
      }
    }
    return "NO";
  }


}
