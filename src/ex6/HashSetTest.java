package ex6;

import java.util.HashSet;

public class HashSetTest {
	
	public static void main(String[] args){
		HashSet<String> hs=new HashSet<String>();
		hs.add("Alice");
		hs.add("Bob");
		hs.add("Charlie");
		hs.add("Diana");
		hs.add("Elmo");
		hs.add("Fred");
		hs.add("Diana");
		hs.add("Bob");
		System.out.println(hs);
	}

}
