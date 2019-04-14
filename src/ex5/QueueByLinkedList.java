package ex5;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByLinkedList{
	public static void main(String[] args){
		Deque<String> deque=new LinkedList<String>();
		
		deque.addFirst("Alice");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		deque.addFirst("Bob");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		deque.addFirst("Charlie");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		deque.addFirst("Diana");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		deque.addFirst("Elmo");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		deque.addFirst("Fred");
		System.out.println(((LinkedList<String>) deque).get(0)+"が追加されました。offer後のdeque="+deque);
		int n=deque.size();
		for(int i=0;i<n;i++){
			System.out.println(deque.peekLast()+"が取り出されました。");
			System.out.println(deque.removeLast()+"現在のdequeの中身："+deque);
		}
	}
}
