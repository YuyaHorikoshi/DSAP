package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertionSort {
	private final int n = 50000;
	  private int[] array = new int[n];

	  public InsertionSort(String filename) {
	    // ここを作る
	    // ファイル名を引数とする
	    // ファイルを開いて全て読み込んで配列arrayに入れる
		  String line;
		  int count=0;
		  try{
			  BufferedReader reader=new BufferedReader(new FileReader(filename));
			  while((line=reader.readLine())!=null){
				  array[count]=new Integer(line);
				  count++;
			  }
			  reader.close();
		  }catch(FileNotFoundException e){
			  
		  }catch(IOException e){
			  
		  }
	  }
	  public void sort() {
	    // ここを作る
	    // 挿入ソートを実装する
	    // 配列arrayの中身をソートする
		  int num=array.length;
		  for(int i=1;i<num;i++){
			  int j=i;
			  while(j>=1 && array[j-1]>array[j]){
				  int temp=array[j];
				  array[j]=array[j-1];
				  array[j-1]=temp;
				  j--;
			  }
		  }
		  
	  }
	  public void output(String filename) {
	    // ここを作る
	    // ファイル名を引数とする
	    // 配列arrayをファイルに出力する
	    // 1行に1レコード
		  try{
			  PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			  for(int line:array){
				  writer.println(line);
			  }
			  writer.close();
		  }catch(FileNotFoundException e){
			  
		  }catch(IOException e){
			  
		  }
	  }

	  public static void main(String[] args) {
	    String file1 = "rand2.txt";
	    String file2 = "result_ex3-3_rand2.txt";

	    InsertionSort is = new InsertionSort(file1);
	    long start,stop;
	    start=System.currentTimeMillis();
	    is.sort();
	    stop=System.currentTimeMillis();
	    System.out.println((stop-start)+"[ms]");
	    is.output(file2);
	  }

}
