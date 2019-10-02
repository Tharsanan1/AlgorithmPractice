package HackerRank;

public class HeightOfBinaryTree {
  public static int height(Node root) {
    // Write your code here.
    return recursiveHeight(root) - 1;
  }

  static int recursiveHeight(Node node){
    if(node == null){
      return 0;
    }
    else{
      return Math.max(recursiveHeight(node.left), recursiveHeight(node.right)) + 1;
    }
  }
}

class Node{
    int data;
    Node left;
    Node right;
}