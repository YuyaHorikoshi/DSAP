package ex5;

import java.util.Deque;
import java.util.LinkedList;

public class StackByLinkedList {
	public static void main(String[] args){
		Deque<String> stack=new LinkedList<String>();
		
		stack.push("Alice");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		stack.push("Bob");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		stack.push("Charlie");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		stack.push("Diana");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		stack.push("Elmo");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		stack.push("Fred");
		System.out.println(stack.getFirst()+"が追加されました。追加後のstack="+stack);
		int n=stack.size();
		for(int i=0;i<n;i++){
			System.out.println(stack.peek()+"が取り出されました。");
			stack.pop();
			System.out.println("現在のstackの中身："+stack);
		}
	}

}
