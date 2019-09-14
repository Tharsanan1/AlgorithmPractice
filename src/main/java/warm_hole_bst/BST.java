package warm_hole_bst;

import java.util.ArrayList;

public class BST {
  Node root;
  int warmHoleDistance;

  public BST() {

  }

  public BST(Node node) {
    this.root = node;
  }

  public BST(int val){
    Node node = new Node(val);
    this.root = node;
  }

  public int getWarmHoleDistance() {
    return warmHoleDistance;
  }

  public void setWarmHoleDistance(int warmHoleDistance) {
    this.warmHoleDistance = warmHoleDistance;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  public void insert(int val){
    int lastFoundWarmHoleDistance = 1;
    Node lastFoundWarmHole = root;
    boolean tookRight = false;
    Node node = new Node(val);
    if(root == null){
      root = node;
      return;
    }
    Node parent = root;
    if(parent.val > node.val){
      tookRight = false;
    }
    else{
      tookRight = true;
    }
    while(true){
      if(parent.val > node.val){
        if(parent.left == null){
          parent.left = node;
          if(lastFoundWarmHoleDistance == warmHoleDistance){
            if(tookRight){
              if(lastFoundWarmHole.warmHoleRightDestination == null){
                lastFoundWarmHole.warmHoleRightDestination = node;
              }
              else{
                fitThisNodeOnRightHole(lastFoundWarmHole, node);
              }
            }
            else{
              if(lastFoundWarmHole.warmHoleLeftDestination == null) {
                lastFoundWarmHole.warmHoleLeftDestination = node;
              }
              else{
                fitThisNodeOnLeftHole(lastFoundWarmHole, node);
              }
            }
          }
          return;
        }
        else {
          if(lastFoundWarmHoleDistance == warmHoleDistance){
            tookRight = false;
            lastFoundWarmHole = parent;
          }
          parent = parent.left;
        }
      }
      else{
        if(parent.right == null){
          parent.right = node;
          if(lastFoundWarmHoleDistance == warmHoleDistance){
            if(tookRight){
              if(lastFoundWarmHole.warmHoleRightDestination == null){
                lastFoundWarmHole.warmHoleRightDestination = node;
              }
              else{
                fitThisNodeOnRightHole(lastFoundWarmHole, node);
              }
            }
            else{
              if(lastFoundWarmHole.warmHoleLeftDestination == null) {
                lastFoundWarmHole.warmHoleLeftDestination = node;
              }
              else{
                fitThisNodeOnLeftHole(lastFoundWarmHole, node);
              }
            }
          }
          return;
        }
        else {
          if(lastFoundWarmHoleDistance == warmHoleDistance){
            lastFoundWarmHole = parent;
            tookRight = true;
          }
          parent = parent.right;
        }
      }
      lastFoundWarmHoleDistance++;
    }
  }

  private void fitThisNodeOnLeftHole(Node lastFoundWarmHole, Node node) {
    Node pointer = lastFoundWarmHole.warmHoleLeftDestination;
    if(pointer.val > node.val){
      lastFoundWarmHole.warmHoleLeftDestination = node;
      node.warmHoleRightAdjacent = pointer;
      return;
    }
    while(true){
      if(pointer.warmHoleRightAdjacent != null){
        if(pointer.warmHoleRightAdjacent.val > node.val){
          Node temp = pointer.warmHoleRightAdjacent;
          pointer.warmHoleRightAdjacent = node;
          node.warmHoleRightAdjacent = temp;
          return;
        }
        else{
          pointer = pointer.warmHoleRightAdjacent;
        }
      }
      else{
        pointer.warmHoleRightAdjacent = node;
        return;
      }
    }
  }

  private void fitThisNodeOnRightHole(Node lastFoundWarmHole, Node node) {
    Node pointer = lastFoundWarmHole.warmHoleRightDestination;
    if(pointer.val > node.val){
      lastFoundWarmHole.warmHoleRightDestination = node;
      node.warmHoleRightAdjacent = pointer;
      return;
    }
    while(true){
      if(pointer.warmHoleRightAdjacent != null){
        if(pointer.warmHoleRightAdjacent.val > node.val){
          Node temp = pointer.warmHoleRightAdjacent;
          pointer.warmHoleRightAdjacent = node;
          node.warmHoleRightAdjacent = temp;
          return;
        }
        else{
          pointer = pointer.warmHoleRightAdjacent;
        }
      }
      else{
        pointer.warmHoleRightAdjacent = node;
        return;
      }
    }
  }

  public void getValuesUsingDepthFirst(ArrayList<Integer> list, Node node){
    getValuesUsingDepthFirstRecursively(list, node);
  }

  public void getValuesUsingDepthFirst(ArrayList<Integer> list){
    getValuesUsingDepthFirstRecursively(list, root);
  }

  private void getValuesUsingDepthFirstRecursively(ArrayList<Integer> list, Node node){
    if(node != null){
      getValuesUsingDepthFirstRecursively(list, node.left);
      list.add(node.val);
      getValuesUsingDepthFirstRecursively(list, node.right);
    }
  }

}
