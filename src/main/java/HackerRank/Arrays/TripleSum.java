package HackerRank.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TripleSum {
  public static void main(String[] args) {
    activityNotifications(new int[]{10, 20, 30, 40, 50}, 3);
  }
  static int activityNotifications(int[] expenditure, int d) {
    ArrayList<Integer> intArr = new ArrayList<>();
    int count = 0;
    for(int i = 0; i < expenditure.length; i++){
      if(i>=d){
        Collections.sort(intArr);
        int size = intArr.size();
        if(size%2 == 0){
          if(expenditure[i] >= (intArr.get(size/2) + intArr.get((size/2)-1))){
            count++;
          }
        }
        else{
          if(expenditure[i] >= (intArr.get(size/2) * 2)){
            count++;
          }
        }
        Integer in = new Integer(expenditure[i-d]);
        intArr.remove(in);
      }
      intArr.add(expenditure[i]);
    }
    return count;
  }


  static long triplets(int[] a, int[] b, int[] c) {
    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);
    ArrayList<Integer> arrayList = new ArrayList<>();
    int lena = a.length;
    int lenb = b.length;
    int lenc = c.length;
    int pointerA = 0;
    int pointerB = 0;
    int pointerC = 0;
    int count = 0;
    for (int i = 0; i < b.length; i++) {
      int countA = 0;
      int countC = 0;
      if(i > 0 && b[i] == b[i-1]){
        continue;
      }
      for (int j = 0; j < lena; j++) {
        if(j > 0 && a[j] == a[j-1]){
          continue;
        }
        if(b[i]>=a[j]){
          countA++;
        }
        else{
          break;
        }
      }
      for (int j = 0; j < lenc; j++) {
        if(j > 0 && c[j] == c[j-1]){
          continue;
        }
        if(b[i] >= c[j]){
          countC++;
        }
        else {
          break;
        }
      }
      count += countA * countC;
    }
    return count;
  }
}
