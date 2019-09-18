package HackerRank.CycleDetection;

import java.util.HashSet;

public class CycleDetection {
  public static void main(String[] args) {

  }

  static boolean hasCycle(SinglyLinkedListNode head) {
    if(head == null){
      return false;
    }
    else{
      SinglyLinkedListNode temp = head;
      HashSet<Integer> traversed = new HashSet<>();
      while(temp.next != null){
        if(traversed.add(System.identityHashCode(temp.next))){
          temp = temp.next;
        }
        else{
          return true;
        }
      }
      return false;
    }

  }
}

class SinglyLinkedListNode {
  int data;
  SinglyLinkedListNode next;
}
