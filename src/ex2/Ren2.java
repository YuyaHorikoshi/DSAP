package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ren2 {
	public static void main(String[] args) {
	    // ここを作る
	    // IntegerのArrayListを作る
		ArrayList<Integer> array=new ArrayList<Integer>();
	    
	    for (int i = 0; i < 30; i++) {
	      array.add(new Random().nextInt(999));
	    }

	    System.out.println("ソート前");
	    for (Integer n : array) {
	      System.out.println(n);
	    }

	    // ここを作る
	    // Collections.sortメソッドを使ってソートする
	    Collections.sort(array);
	    Collections.reverse(array);

	    System.out.println("ソート後");
	    for (Integer n : array) {
	      System.out.println(n);
	    }

	  }


}
