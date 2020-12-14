import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue();
		int queries = scanner.nextInt();
		for (int i = 0; i < queries; i++) {
			int task = scanner.nextInt();
			if(task == 1) {
				queue.enqueue(scanner.nextInt());
				//queue.printQueue();
			}
			else if(task == 2) {
				queue.dequeue();
				//queue.printQueue();
			}
			else if(task == 3) {
				queue.print();
				//queue.printQueue();
			}
		}
		scanner.close();
	}
	
	private static class Queue {
		private Deque<Integer> inbox;
		private Deque<Integer> outbox;
		private Integer firstToOut = null;
		
		public Queue() {
			this.inbox = new ArrayDeque<>();
			this.outbox = new ArrayDeque<>();
		}
		
		public void enqueue(int i) {
			if(inbox.isEmpty()) {
				fillInbox(outbox, inbox);
			}
			inbox.push(i);
			
		}
		
		public int dequeue() {
			if(outbox.isEmpty()) {
				fillOutbox(inbox, outbox);
			}
			return outbox.pop();
		}
		
		public void print() {
			if(this.firstToOut == null) {
				fillOutbox(inbox, outbox);
				System.out.println(this.firstToOut);
			}
			else if(!outbox.isEmpty()) {
				System.out.println(outbox.peek());
			}
			else {
				System.out.println(this.firstToOut);
			}
			
		}
		
		private void fillOutbox(Deque<Integer> inbox, Deque<Integer> outbox) {
			int stackSize = inbox.size();
			for (int i = 0; i < stackSize; i++) {
				outbox.push(inbox.pop());
			}
			this.firstToOut = outbox.peek();
		}
		
		private void fillInbox(Deque<Integer> outbox, Deque<Integer> inbox) {
			int stackSize = outbox.size();
			this.firstToOut = outbox.peek();
			for (int i = 0; i < stackSize; i++) {
				inbox.push(outbox.pop());
			}
		}
		
		public void printQueue() {
			System.out.println(inbox + " " + outbox);
		}
		
	}

}

