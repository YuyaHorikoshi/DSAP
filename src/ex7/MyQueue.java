package ex7;

public class MyQueue {
	private Node head; // 先頭のノードを入れるフィールド

	public MyQueue() {
		head = null; // 最初は空っぽ
	}

	public void offer(String str) {
		// 末尾にstrをデータとするノードを追加する
		// ここを作る
		Node node = new Node(str);
		Node pNode = head;
		if (head == null) {
			head = node;
		} else {
			while (pNode.getNext() != null) {
				pNode = pNode.getNext();
			}
			pNode.setNext(node);
		}
	}

	public String peek() {
		// 先頭のノードを参照して、データを返す
		// ここを作る
		if (head == null) {
			return null;
		} else {
			return head.getDate();
		}
	}

	public String poll() {
		// 先頭のノードを取り出して削除し、データを返す
		// ここを作る
		if (head == null) {
			return null;
		}
		String date = head.getDate();
		head = head.getNext();
		return date;
	}

	public void print() {
		// ノードを先頭から最後までたどってデータを表示
		System.out.print("キューの中身: ");
		print(head);
	}

	public void print(Node p) {
		// 再帰呼び出しでノードをたどってデータを表示
		// ここを作る
		while (p != null) {
			System.out.print(p + "=>");
			p = p.getNext();
		}
		if (p == null) {
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		// キューを作って、いろいろやってみる
		MyQueue queue = new MyQueue();
		queue.print();
		queue.offer("abc");
		queue.print();
		queue.offer("def");
		queue.print();
		queue.offer("ghi");
		queue.print();
		queue.offer("jkl");
		queue.print();
		queue.offer("mno");
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
	}

}
