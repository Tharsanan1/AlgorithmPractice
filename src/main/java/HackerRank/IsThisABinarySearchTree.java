package HackerRank;

public class IsThisABinarySearchTree {
  boolean checkBST(Node root) {
    return isItBinSea(root);
  }

  static boolean isItBinSea(Node node){
    boolean b1 = false;
    boolean b2 = false;
    if(node.left != null){
      if(node.left.data < node.data){
        b1 = isItBinSea(node.left);
      }
      else{
        return false;
      }
    }
    else{
      b1 = true;
    }
    if(node.right != null){
      if(node.right.data > node.data){
        b2 = isItBinSea(node.right);
      }
      else{
        return false;
      }
    }
    else{
      b2 = true;
    }
    return b1 && b2;

  }
}
