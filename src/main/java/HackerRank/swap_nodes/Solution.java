package HackerRank.swap_nodes;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        ArrayDeque<TreeNode> children = new ArrayDeque<>();
        TreeNode root = new TreeNode(1);
        children.addLast(root);
        for (int i = 0; i < indexes.length; i++) {
            TreeNode first = children.removeFirst();
            if(indexes[i][0] != -1){
                TreeNode temp = new TreeNode(indexes[i][0]);
                first.left = temp;
                children.addLast(temp);
            }
            if(indexes[i][1] != -1){
                TreeNode temp = new TreeNode(indexes[i][1]);
                first.right = temp;
                children.addLast(temp);
            }
        }
        int[][] twoDArray = new int[queries.length][indexes.length];
        int count = 0;
        for (int i : queries) {
            swap(i, root, 1);
            ArrayDeque<Integer> order = new ArrayDeque<>();
            inorderTraversal(root, order);
            int size = order.size();
            for (int j = 0; j < size; j++) {
                twoDArray[count][j] = order.removeFirst();
            }
            count++;
        }
        return twoDArray;
    }

    static void swap(int depth, TreeNode root, int pointer){
        if(root == null){
            return;
        }
        if(pointer%depth == 0){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        swap(depth, root.left, pointer+1);
        swap(depth, root.right, pointer+1);

    }

    static void inorderTraversal(TreeNode root, ArrayDeque<Integer> order){
        if(root != null){
            inorderTraversal(root.left, order);
            order.addLast(root.data);
            inorderTraversal(root.right, order);
        }
    }

    private static class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
