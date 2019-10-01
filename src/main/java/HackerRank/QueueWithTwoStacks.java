package HackerRank;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class QueueWithTwoStacks {
  ArrayDeque<Integer> arrayDequeA;
  ArrayDeque<Integer> arrayDequeB;
  QueueWithTwoStacks(){
    arrayDequeA = new ArrayDeque<>();
    arrayDequeB = new ArrayDeque<>();
  }
  public void add(int i){
    arrayDequeA.addLast(i);
  }

  public int remove(){
    if(arrayDequeB.isEmpty()){
      while (!arrayDequeA.isEmpty()){
        arrayDequeB.addLast(arrayDequeA.removeLast());
      }
    }
    return arrayDequeB.removeLast();
  }

  public int peek(){
    if(arrayDequeB.isEmpty()){
      while (!arrayDequeA.isEmpty()){
        arrayDequeB.addLast(arrayDequeA.removeLast());
      }
    }
    return arrayDequeB.getLast();
  }
}
