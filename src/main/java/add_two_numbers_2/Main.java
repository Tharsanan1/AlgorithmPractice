package add_two_numbers_2;

import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    StringBuilder integer1 = new StringBuilder("hh");
    integer1.insert(0, 1);
    integer1.insert(0, 2);
    String total  = String.format("%.0f",(Double.parseDouble("10000000000000000000000001000000000001") + Double.parseDouble("9")));
    int indexOfDot = total.indexOf(".");
    total = total.substring(0,indexOfDot);
    System.out.println(total);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int total = l1.val + l2.val;
    int localTotal = total;
    ListNode toReturn = new ListNode(total%10);
    ListNode temp = toReturn;
    while(l1.next != null || l2.next != null){
      localTotal = localTotal / 10;
      if(l1.next != null){
        localTotal += l1.next.val;
        l1 = l1.next;
      }
      if(l2.next != null){
        localTotal += l2.next.val;
        l2 = l2.next;
      }
      temp.next = new ListNode(localTotal%10);
//      if(localTotal >= 10){
//        shifted = 1;
//        temp.next = new ListNode(localTotal - 10);
//      }
//      else{
//        shifted = 0;
//        temp.next = new ListNode(localTotal);
//      }
      temp = temp.next;
    }
    if(localTotal >= 10){
      temp.next = new ListNode(localTotal/10);
    }
    return toReturn;
  }
}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}