import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		ArrayDeque<Node> stack = new ArrayDeque<>();
		int queries = scanner.nextInt();
		for (int i = 0; i < queries; i++) {
			int task = scanner.nextInt();
			if(task == 1) {
				String data = scanner.nextLine().trim();
//				System.out.println("\n*" + data + "*");
				stack.push(new Node(data));
			}
			else if(task == 2) {
				int deleteLen = scanner.nextInt();
				stack.push(new Node(deleteLen));
			}
			else if(task == 3) {
				int printLen = scanner.nextInt();
				System.out.println(getKthChar(printLen - 1, stack));
			}
			else if(task == 4) {
				stack.pop();
			}
		}
		scanner.close();
	}
	
	private static char getKthChar(int k, ArrayDeque<Node> stack) {
		StringBuilder s = new StringBuilder();
		Iterator<Node> itr = stack.descendingIterator();
		while(itr.hasNext()) {
			Node node = itr.next();
			if(node.indicator == 0) {
				s.append(node.data);
			}
			else {
				s = new StringBuilder(s.substring(0, s.length() - node.deleteLen));
			}
//			System.out.println("\n***** " + s);
		}
		return s.charAt(k);
	}
	
	private static class Node {
		public int indicator;
		public String data;
		public int deleteLen;
		
		public Node(String data) {
			this.data = data;
			this.indicator = 0;
		}
		
		public Node(int deleteLen) {
			this.indicator = 1;
			this.deleteLen = deleteLen;
		}
	}

}

