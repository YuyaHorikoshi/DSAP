package ex10;

public class BTNode2 {
	private String label;
	private BTNode2 left;
	private BTNode2 right;

	public BTNode2(String label, BTNode2 left, BTNode2 right) {
		this.label = label;
		this.left = left;
		this.right = right;
	}

	public void printNode() {
		printNode("");
	}

	public void printNode(String prefix) {
		// ここを作る
		System.out.println(prefix+this);
		if(left!=null){
			left.printNode(prefix+"\t");
		}
		//System.out.println(prefix+this);
		if(right!=null){
			right.printNode(prefix+"\t");
		}
		//System.out.println(prefix+this);

	}

	public BTNode2 search(String name) {
		// ここを作る
		if (this.label == name) {
			return this;
		} else if (left != null && left.search(name) != null) {
			return left.search(name);
		} else if (right != null && right.search(name) != null) {
			return right.search(name);
		}

		return null;
	}



	public String toString() {
		return "[" + label + "]";
	}

	public static void main(String[] args) {
		BTNode2 tree = new BTNode2("A", new BTNode2("B", new BTNode2("C", null, null), new BTNode2("E", null, null)),
				new BTNode2("D", new BTNode2("F", null, null), new BTNode2("G", null, null)));
		tree.printNode();
		System.out.println("Aを探す");
		System.out.println("あった? " + tree.search("A"));
		System.out.println("Bを探す");
		System.out.println("あった? " + tree.search("B"));
		System.out.println("Cを探す");
		System.out.println("あった? " + tree.search("C"));
		System.out.println("Dを探す");
		System.out.println("あった? " + tree.search("D"));
		System.out.println("Eを探す");
		System.out.println("あった? " + tree.search("E"));
		System.out.println("Fを探す");
		System.out.println("あった? " + tree.search("F"));
		System.out.println("Gを探す");
		System.out.println("あった? " + tree.search("G"));
		System.out.println("Zを探す");
		System.out.println("あった? " + tree.search("Z"));
	}
}