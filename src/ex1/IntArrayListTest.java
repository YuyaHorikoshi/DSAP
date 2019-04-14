package ex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayListTest {
	public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	      // 整数を要素とするArrayListの宣言と生成
	      ArrayList<Integer> intList = new ArrayList<Integer>();
	      try {
	         System.out.println("整数値を入力してください。整数以外を入力するまで繰り返します。");
	         // 入力部分
	         // ここを作る
	         while(true){
	        	 intList.add(scanner.nextInt());
	         }


	      } catch (InputMismatchException e) {
	         System.out.println("入力が完了しました。データの数は" + intList.size());
	      }             
	      // 入力された値を表示する
	      System.out.println("入力された値は");
	      // ここを作る
	      for(int numbers:intList){
	      System.out.print(numbers+"　　");
	      }

	      // 合計を表示する
	      // ここを作る
	      int sum=0;
	      for(int numbers:intList){
	    	  sum+=numbers;
	      }
	      System.out.println("合計は"+sum);

	      // 平均を表示する
	      // ここを作る
	      float ave=sum/intList.size();
	      System.out.println("平均は"+ave);
	    		  

	      // scannerを閉じる
	      scanner.close();
	   }

}
