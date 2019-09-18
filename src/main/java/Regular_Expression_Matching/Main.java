package Regular_Expression_Matching;

public class Main {
  public static void main(String[] args) {
    String s = "hellor";
    System.out.println(isMatch("aaa", "a*a"));
    double t = 0;
    for (int i = 60; i > 0 ; i--) {
      t += (i * 15.0/12);
    }
    System.out.println(t);
  }

  public static boolean isMatch(String s, String p) {
    int indexS = 0;
    int indexP = 0;
    char astr = '*';
    char dot = '.';
    StringBuilder stringBuilder  = new StringBuilder(p);
    for (int i = 2; i < p.length(); i++) {
      if((p.charAt(i-2) == p.charAt(i)) && (p.charAt(i-1) == astr)){
        stringBuilder.setCharAt(i-1, p.charAt(i));
        stringBuilder.setCharAt(i, astr);
      }
    }
    p = stringBuilder.toString();
    while (true) {
      if((indexP >= p.length()) && (indexS < s.length())){
        return false;
      }
      if((indexS == s.length()) && (indexP == p.length())){
        return true;
      }
      if((indexS == s.length()) && (indexP == p.length() - 1)){
        if(p.charAt(indexP) == astr) {
          return true;
        }
        else{
          return false;
        }
      }
      if((indexS == s.length()) && (indexP < p.length() - 1)){
        return false;
      }
      char current = s.charAt(indexS);
      char pCurrent = p.charAt(indexP);
      if (current == pCurrent) {
        indexP++;
        indexS++;
      } else {
        if(pCurrent == dot){
          indexP++;
          indexS++;
        }
        else if(pCurrent == astr){
          if((current == p.charAt(indexP - 1)) || (p.charAt(indexP - 1) == dot)){
            indexS++;
          }
          else{
            indexP++;
          }
        }
        else{
          indexP++;
        }
      }
    }
  }
}
