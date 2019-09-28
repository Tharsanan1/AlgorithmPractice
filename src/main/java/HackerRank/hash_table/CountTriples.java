package HackerRank.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountTriples {
  public static void main(String[] args) {
    List<Long> arr = Arrays.asList(1l,2l,2l,4l);
    System.out.println(countTriplets(arr, 2));
  }
  static long countTriplets(List<Long> arr, long r) {
    ArrayList<Node> nodeArr = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      int count = 0;
      for (int j = 0; j < i; j++) {
        if(nodeArr.get(j).myMul == arr.get(i)){
          count++;
        }
      }
      nodeArr.add(new Node(arr.get(i) * r, count));
    }
    ArrayList<Integer> intArr = new ArrayList<>();
    int count = 0;
    int localCount = 0;
    for (int i = 0; i < nodeArr.size(); i++) {
      if(count == nodeArr.get(i).count){
        localCount++;
      }
      else{
        intArr.add(localCount);
        localCount = 1;
        count = nodeArr.get(i).count;
      }
    }
    intArr.add(localCount);
    int total = 0;
    for (int i = 0; i < intArr.size()-2; i++) {
      total += (intArr.get(i) * intArr.get(i+1) * intArr.get(i+2));
    }
    return total;
  }
}

class Node{
  long myMul;
  int count;

  public Node(long myMul, int count) {
    this.myMul = myMul;
    this.count = count;
  }
}
