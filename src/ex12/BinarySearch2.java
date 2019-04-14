package ex12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch2 {
	 private final int n = 9999;
	  private int[] table = new int[n];
	  ArrayList<Integer> list=new ArrayList<Integer>();

	  public BinarySearch2(String filename) {
	    try {
	    	BufferedReader reader=new BufferedReader(new FileReader(filename));
	    	String line;
	    	while((line=reader.readLine())!=null){
	    		list.add(Integer.parseInt(line));
	    	}
	      // ここを作る
	    	reader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println(filename + "が見つかりません。");
	    } catch (IOException e) {
	      System.out.println(e);
	    }
	    
	    Collections.sort(list);
	    int i=0;
	    for(int num:list){
	    	table[i]=num;
	    	i++;
	    }
	    //System.out.println(table);
	  }
	  
	  public void search(int key) {
	    // ここを作る
	    // 二分探索でkeyを探す
		  
		  int low=0;
		  int high=n-1;
		  int i=1;
		  
		  while(low<=high){
			  int mid=(int)(high+low)/2;
			  //System.out.println(mid);
			  if(key==table[mid]){
				  System.out.println(i+"回の探索で"+key+"が見つかりました");
			  return;
			  }
			  if(key<table[mid]){
				  high=mid-1;
			  }else{
				  low=mid+1;
			  }
			  i++;
		  }
		  System.out.println((i-1)+"回探索しましたが"+key+"は見つかりませんでした");
	  }
	  public void show() {
	    // ここを作る
	    // 表の要素を全て表示する
		  for(int i=0;i<n;i++){
			  System.out.println(i+"="+table[i]);
		  }
	  }

	  public static void main(String[] args) {
	    String filename = "rand.txt";
	    BinarySearch2 table = new BinarySearch2(filename);

	    table.show();
	    System.out.println("key=1000を探索");
	    table.search(1000);
	    System.out.println("key=9412を探索");
	    table.search(9412);
	    System.out.println("key=2を探索");
	    table.search(2);
	    System.out.println("key=10000を探索");
	    table.search(10000);
	  }
	
	
}
