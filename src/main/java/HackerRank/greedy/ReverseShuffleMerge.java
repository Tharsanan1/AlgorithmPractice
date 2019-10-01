package HackerRank.greedy;

import sun.awt.X11.XSystemTrayPeer;

public class ReverseShuffleMerge {
  public static void main(String[] args) {
    reverseShuffleMerge("eggegg");

    System.out.println(reverse("abcdefgabcdefg"));
  }
  static String reverseShuffleMerge(String s) {
    int[] letterArr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      letterArr[s.charAt(i) - 97]++;
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < letterArr[i]/2; j++) {
        result.append((char)(i + 97));
      }
    }
    return recursiveCheck(result.toString(), reverse(s) );
  }

  static String reverse(String s){
    char[] c = s.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = c.length-1; i > -1; i--) {
      stringBuilder.append(c[i]);
    }
    return stringBuilder.toString();
  }

  static String recursiveCheck(String source, String target){
    if(source.length() > target.length()){
      return null;
    }
    else if(source.length() == target.length()){
      if(source.equals(target)){
        return source;
      }
      else {
        return null;
      }
    }
    if(source.length() == 1 && target.contains(source)){
      return source;
    }
    else if(source.length() == 1){
      return null;
    }
    for (int i = 0; i < source.length(); i++) {
      int index = target.indexOf(source.substring(i,i+1));
      if(index > -1) {
        String result = recursiveCheck(source.substring(0,i) + source.substring(i+1), target.substring(index+1));
        if(result != null){
          return source.substring(i,i+1) + result;
        }
      }
    }
    return null;
  }
}
