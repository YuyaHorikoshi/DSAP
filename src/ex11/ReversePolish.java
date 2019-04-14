package ex11;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolish {
  private static Deque<String> stack = new LinkedList<String>();

  private String label;
  private ReversePolish left;
  private ReversePolish right;
  
  public ReversePolish(String label, ReversePolish left, ReversePolish right) {
    this.label = label;
    this.left = left;
    this.right = right;
  }
  public void printNode() {
    printNode("");
  }
  public void printNode(String prefix) {
    if (right != null) {
      right.printNode(prefix + "\t");
    }
    System.out.println(prefix + this);
    if (left != null) {
      left.printNode(prefix + "\t");
    }
  }
  public String toString() {
    return "[" + label + "]";
  }
  public int result() {
    // ここを作る
    // スタックに結果が残っているはず
	  //System.out.println(stack);
	  return Integer.parseInt(stack.peek());
	  
  
  }
  public void calc(String label) {
    // ここを作る
    // なぞったノードで演算を行う
    // ノードのlabelが演算子であれば・・・
    // ノードのlabelが数字であれば・・・
    // Java7以降ならswitch文が便利、スタックも有効に使おう
	  
	  System.out.println(stack);

	  int x=0;
	  int y=0;
	  //System.out.println(stack);

	  switch(stack.pop()){
	  case "-":
		  x=Integer.parseInt(stack.pop());
		  y=Integer.parseInt(stack.pop());
		  stack.push(String.valueOf(x-y));
		  break;
	  case "+":
		  x=Integer.parseInt(stack.pop());
		  y=Integer.parseInt(stack.pop());
		  stack.push(String.valueOf(x+y));
		  break;
	  case "*":
		  x=Integer.parseInt(stack.pop());
		  y=Integer.parseInt(stack.pop());
		  stack.push(String.valueOf(x*y));
		  break;
	  default:
		  stack.push(label);
		  break;
	  
}
  }
  public void traversePostorder(ReversePolish n) {
    // ここを作る（帰りがけ順のなぞりでcalc()を呼び出す）
	  //stack.push(n.label);
	  
	  if(n==null){
		  return;
	  }
	  traversePostorder(n.right);
	  traversePostorder(n.left);
	  stack.push(n.label);
	  System.out.println(stack);
	  calc(n.label);
	  

  }
  public static void main(String[] args) {
    ReversePolish tree =
          new ReversePolish("*", new ReversePolish("+", new ReversePolish("3", null, null), new ReversePolish("5", null, null)), new ReversePolish("-", new ReversePolish("6", null, null), new ReversePolish("2", null, null)));
    System.out.println("数式の木");
    tree.printNode();
    tree.traversePostorder(tree);
    System.out.println("計算結果");
    System.out.println(tree.result());
  }
}