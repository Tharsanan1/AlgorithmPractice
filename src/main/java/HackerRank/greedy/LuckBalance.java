package HackerRank.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class LuckBalance {
  static int luckBalance(int k, int[][] contests) {
    ArrayList<Integer> arrayList = new ArrayList<>(contests.length / 2);
    int luckBal = 0;
    for (int i = 0; i < contests.length; i++) {
      if(contests[i][1] == 0){
        luckBal += contests[i][0];
      }
      else{
        arrayList.add(contests[i][0]);
      }
    }
    int shouldWin = arrayList.size() - k;
    Collections.sort(arrayList);
    for (int i = 0; i < arrayList.size(); i++) {
      if(i < shouldWin){
        luckBal -= arrayList.get(i);
      }
      else{
        luckBal+=arrayList.get(i);
      }
    }
    return luckBal;
  }
}
