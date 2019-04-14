package ex7;

public class Node {
	private Node next;
	private String date;

	public Node(String date){
		this.date=date;
	}

	public Node setNext(Node node){
		next=node;
		return next;
	}

	public Node getNext(){
		return next;
	}

	public String getDate(){
		return date;
	}

	public String toString(){
		return "["+getDate()+"]";
	}

	public static void main(String[] args) {
	      Node alice   = new Node("Alice");
	      Node bob     = new Node("Bob");
	      Node charlie = new Node("Charlie");
	      Node diana   = new Node("Diana");
	      Node elmo    = new Node("Elmo");
	      Node fred    = new Node("Fred");
	      alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

	      Node p = alice;
	      while (p != null) {
	         System.out.print(p + " -> ");
	         p = p.getNext();
	      }
	   }
}
