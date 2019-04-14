package ex14;

public class BinarySearchTree {
	private class BTNode {
		Integer data;
		BTNode left;
		BTNode right;

		public BTNode(Integer data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public void printNode() {
			printNode("");
		}

		public void printNode(String prefix) {
			if (right != null) {
				right.printNode(prefix + "\t");
			}
			System.out.println(prefix + this.data);
			if (left != null) {
				left.printNode(prefix + "\t");
			}
		}
		
	}
	
	public void result(){
		System.out.println("最小の要素:"+min().data);
		System.out.println("最大の要素:"+max().data);
		traverse(this.root);
	}

	private BTNode root;

	public BinarySearchTree() {
		root = null;
	}

	public BTNode search(Integer key) {
		// keyで示されるノードを探索する
		// keyが見つかればそのノードを返し，
		// 見つからなければnullを返す
		BTNode p = root;
		while (p != null) {
			int n = key.compareTo(root.data);
			if (n < 0) {
				p = p.left;
			}
			if (n > 0) {
				p = p.right;
			}
			if (n == 0) {
				return p;
			}
		}
		return null;
	}

	public BTNode add(Integer key) {
		// keyを二分探索木に追加する
		// ここを作成する
		// どこに追加するか
		// 左部分木に追加するか
		// 右部分木に追加するか
		BTNode p = root;
		BTNode parent = null;
		boolean isLeftChild = false;

		while (p != null) {
			int n = key.compareTo(p.data);
			if (n < 0) {
				parent = p;
				isLeftChild = true;
				p = p.left;
			}
			if (n > 0) {
				parent = p;
				isLeftChild = false;
				;
				p = p.right;
			}
			if (n == 0) {
				return null;
			}
		}

		BTNode nNode = new BTNode(key);
		// System.out.println(nNode);
		if (parent == null) {
			root = nNode;
		} else if (isLeftChild) {
			parent.left = nNode;
		} else {
			parent.right = nNode;
		}
		return nNode;
	}

	public boolean remove(Integer key) {
		// keyを二分探索木から探し，あれば削除する
		// ここを作成する
		// 1. 子を持たない場合
		// 2. 子を1つだけ持つ場合
		// 3. 左右の子を持つ場合（右部分木で最小のノードで置き換える）
		BTNode p = root;
		BTNode parent = null;
		boolean isLeftChild = false;
		while (p != null) {
			int n = key.compareTo(p.data);
			if (n == 0) {
				if (p.left == null && p.right == null) {
					if (parent == null) {
						root = null;
					} else if (isLeftChild) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				} else if (p.left == null) {
					if (parent == null) {
						root = p.right;
					} else if (isLeftChild) {
						parent.left = p.right;
					} else {
						parent.right = p.right;
					}
				} else if (p.right == null) {
					if (parent == null) {
						root = p.left;
					} else if (isLeftChild) {
						parent.left = p.left;
					} else {
						parent.right = p.left;
					}
				} else {
					BTNode s = removeMin(p, p.right);
					if (parent == null) {
						parent = s;
					} else if (isLeftChild) {
						parent.left = s;
					} else {
						parent.right = s;
					}
					s.right = p.right;
					s.left = p.left;
				}
				return true;
			} else if (n < 0) {
				parent = p;
				isLeftChild = true;
				p = p.left;
			} else {
				parent = p;
				isLeftChild = false;
				p = p.right;
			}
		}
		return false;
	}

	private BTNode removeMin(BTNode parent, BTNode p) {
		// 削除すべきノードが左右の子を持っているときに
		// 最小のノードを探し出すメソッド
		// ここを作成する
		boolean isLeftChild = false;
		while (p.left != null) {
			parent = p;
			isLeftChild = true;
			p = p.left;
		}
		if (isLeftChild) {
			parent.left = p.right;
		} else {
			parent.right = p.right;
		}
		return p;
	}

	public BTNode min() {
		BTNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

	public BTNode max() {
		BTNode p = root;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	public void traverse(BTNode n) {
		if (n.left != null) {
			traverse(n.left);
		}
		System.out.print(n.data + "->");
		if (n.right != null) {
			traverse(n.right);
		}
	}

	public void printNode() {
		root.printNode("");
	}

	public static void main(String[] args) {
		System.out.println("二分探索木の作成");
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(13);
		bst.add(5);
		bst.add(21);
		bst.add(15);
		bst.add(7);
		bst.add(2);
		bst.add(6);

		bst.printNode();

		BTNode result;
		System.out.print("ノード3を探索:");
		result = bst.search(3);
		if (result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("探索失敗");
		}

		System.out.print("ノード5を探索:");
		result = bst.search(5);
		if (result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("探索失敗");
		}

		System.out.println("ノード8を追加");
		bst.add(8);
		bst.printNode();
		bst.result();

		System.out.println("子を1つだけ持ったノードの削除");
		BinarySearchTree bst2 = new BinarySearchTree();

		bst2.add(9);
		bst2.add(14);
		bst2.add(5);
		bst2.add(3);
		bst2.add(4);
		bst2.add(1);
		bst2.add(14);
		bst2.printNode();
		bst2.result();

		System.out.println("ノード5を削除");
		if (bst2.remove(5)) {
			System.out.println("削除成功");
		}
		bst2.printNode();

		System.out.println("子を2つ持ったノードの削除");
		BinarySearchTree bst3 = new BinarySearchTree();

		bst3.add(20);
		bst3.add(23);
		bst3.add(29);
		bst3.add(7);
		bst3.add(18);
		bst3.add(4);
		bst3.add(2);
		bst3.add(5);
		bst3.add(10);
		bst3.add(15);
		bst3.printNode();
		bst3.result();

		System.out.println("ノード7を削除");
		if (bst3.remove(7)) {
			System.out.println("削除成功");
		}
		bst3.printNode();
	}
}