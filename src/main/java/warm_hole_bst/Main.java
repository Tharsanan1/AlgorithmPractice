package warm_hole_bst;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    BST bst = new BST(10);
    bst.setWarmHoleDistance(3);
    bst.insert(1);
    bst.insert(11);
    bst.insert(15);
    bst.insert(5);
    bst.insert(2);
    bst.insert(22);
    bst.insert(23);
    bst.insert(14);
    ArrayList<Integer> toOut = new ArrayList<>();
    bst.getValuesUsingDepthFirst(toOut);
    printList(toOut);
  }

  public static void printList(ArrayList<Integer> list){
    for (int i : list) {
      System.out.println(i);
    }
  }
}
