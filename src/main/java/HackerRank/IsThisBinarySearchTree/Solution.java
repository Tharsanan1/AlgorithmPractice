package HackerRank.IsThisBinarySearchTree;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        return recursiveCheckBST(root,Integer.MIN_VALUE);
    }

    boolean recursiveCheckBST(Node root, int lastTraversed){
        if(root != null){
            boolean leftResult = recursiveCheckBST(root.left, lastTraversed);
            if(!leftResult){
                return false;
            }
            if(lastTraversed > root.data){
                return false;
            }
            lastTraversed = root.data;
            boolean rightResult = recursiveCheckBST(root.right, lastTraversed);
            if(!rightResult){
                return false;
            }
            return true;
        }
        return true;
    }


}
