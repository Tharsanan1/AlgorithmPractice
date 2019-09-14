package warm_hole_bst;

public class Node {
  Node parent;
  Node left;
  Node right;
  int val;
  int warmHoleLeftDestinationValue;
  int warmHoleRightDestinationValue;
  int warmHoleRightAdjacentVal;
  Node warmHoleLeftDestination;
  Node warmHoleRightDestination;
  Node warmHoleRightAdjacent;

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public int getWarmHoleLeftDestinationValue() {
    return warmHoleLeftDestinationValue;
  }

  public int getWarmHoleRightAdjacentVal() {
    return warmHoleRightAdjacentVal;
  }

  public void setWarmHoleRightAdjacentVal(int warmHoleRightAdjacentVal) {
    this.warmHoleRightAdjacentVal = warmHoleRightAdjacentVal;
  }

  public Node getWarmHoleRightAdjacent() {
    return warmHoleRightAdjacent;
  }

  public void setWarmHoleRightAdjacent(Node warmHoleRightAdjacent) {
    this.warmHoleRightAdjacent = warmHoleRightAdjacent;
  }

  public void setWarmHoleLeftDestinationValue(int warmHoleLeftDestinationValue) {
    this.warmHoleLeftDestinationValue = warmHoleLeftDestinationValue;
  }

  public Node getWarmHoleLeftDestination() {
    return warmHoleLeftDestination;
  }

  public void setWarmHoleLeftDestination(Node warmHoleLeftDestination) {
    this.warmHoleLeftDestination = warmHoleLeftDestination;
  }

  public int getWarmHoleRightDestinationValue() {
    return warmHoleRightDestinationValue;
  }

  public void setWarmHoleRightDestinationValue(int warmHoleRightDestinationValue) {
    this.warmHoleRightDestinationValue = warmHoleRightDestinationValue;
  }

  public Node getWarmHoleRightDestination() {
    return warmHoleRightDestination;
  }

  public void setWarmHoleRightDestination(Node warmHoleRightDestination) {
    this.warmHoleRightDestination = warmHoleRightDestination;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Node(int val){
    this.val = val;
  }
}
