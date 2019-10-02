package HackerRank;

public class LowestCommonAncestor {
  public static Node lca(Node root, int v1, int v2) {
    // Write your code here.
    if(recursiveHeight(root,v1,v2).val == null){
      return searchForFirstAppearance(root, v1, v2).val;
    }
    return recursiveHeight(root,v1,v2).val;
  }

  static Detail searchForFirstAppearance(Node node, int v1, int v2){
    if(node == null){
      return new Detail(null, false, false);
    }
    else{
      if(node.data == v1){
        return new Detail(node, true, false);
      }
      else if(node.data == v2) {
        return new Detail(node, false, true);
      }
      else{
        Detail leftD = searchForFirstAppearance(node.left, v1,v2);
        if(leftD.val != null){
          return leftD;
        }
        Detail rightD = searchForFirstAppearance(node.right, v1, v2);
        if(rightD.val != null){
          return rightD;
        }
        return new Detail(null, false, false);
      }
    }
  }

  static Detail recursiveHeight(Node node, int v1, int v2){
    if(node == null){
      return new Detail(null, false, false);
    }
    else{
      if(node.data == v1){
        return new Detail(null, true, false);
      }
      else if(node.data == v2) {
        return new Detail(null, false, true);
      }
      else{
        Detail leftD = recursiveHeight(node.left, v1,v2);
        Detail rightD = recursiveHeight(node.right, v1, v2);
        if((leftD.v2 == leftD.v1 && leftD.v2)){
          return leftD;
        } if((rightD.v2 == rightD.v1 && rightD.v2)){
          return rightD;
        }
        if(leftD.v1 && rightD.v2){
          return new Detail(node, true, true);
        }
        else if(leftD.v2 && rightD.v1){
          return new Detail(node, true, true);
        }
        if(leftD.v1 || rightD.v1){
          return new Detail(null, true, false);
        }
        else if(leftD.v2 || rightD.v2){
          return new Detail(null, false, true);
        }
      }
    }
    return new Detail(null, false, false);
  }


}

class Detail{
  Node val;
  boolean v1;
  boolean v2;

  public Detail(Node val, boolean v1, boolean v2) {
    this.val = val;
    this.v1 = v1;
    this.v2 = v2;
  }
}
