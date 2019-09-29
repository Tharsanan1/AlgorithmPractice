package HackerRank.String;

import java.util.ArrayList;
import java.util.LinkedList;

public class SpecialStringAgain {
  public static void main(String[] args) {
    substrCount(7, "abcbaba");
    LinkedList<Integer> lList = new LinkedList<>();
    
  }
  static long substrCount(int n, String s) {
    ArrayList<Integer> freqSeq = new ArrayList<>();
    ArrayList<Character> letterSeq = new ArrayList<>();
    char c = s.charAt(0);
    int count = 0;
    for(int i = 0; i < n; i++){
      if(i == 0){
        count++;
      }
      else{
        if(s.charAt(i) == c){
          count++;
        }
        else{
          freqSeq.add(count);
          letterSeq.add(c);
          count = 1;
          c = s.charAt(i);
        }
      }
    }
    freqSeq.add(count);
    letterSeq.add(c);
    int total = 0;
    for(int i = 0; i < freqSeq.size(); i++){
      total += (freqSeq.get(i) * (freqSeq.get(i)+1)) / 2;
    }
    for(int i = 0; i < freqSeq.size(); i++){
      if(freqSeq.get(i) == 1){
        if(i > 0 && i < freqSeq.size() - 1){
          if(letterSeq.get(i-1) == letterSeq.get(i+1)){
            total+=Math.min(freqSeq.get(i-1),freqSeq.get(i+1));
          }
        }
      }
    }
    return total;

  }
}
