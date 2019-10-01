package HackerRank.Braces;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Braces {
  public static void main(String[] args) {
    System.out.println(checkBalanced(new char[]{'{', '}', '(', ')'}));
  }
  static boolean checkBalanced(char[] braceArr){
    if(braceArr.length%2 == 1){
      return false;
    }
    HashMap<Character, Character> braceMap = new HashMap<>();
    braceMap.put(')','(');
    braceMap.put(']','[');
    braceMap.put('}','{');
    Stack<Character> braceIncome = new Stack<>();
    for (int i = 0; i < braceArr.length; i++) {

      if(braceIncome.size() > 0 && braceIncome.lastElement() == braceMap.get(braceArr[i])){
        braceIncome.pop();
      }
      else{
        braceIncome.push(braceArr[i]);
      }
    }
    if(braceIncome.empty()){
      return true;
    }
    else{
      return false;
    }
  }

  static String isBalanced(String s) {
    if(checkBalanced(s.toCharArray())){
      return "YES";
    }
    return "NO";

  }
}
