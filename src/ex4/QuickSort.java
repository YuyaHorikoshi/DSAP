package ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuickSort {
	private final int n = 50000;
	private int[] a = new int[n];

	public QuickSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列aに入れる
		String line;
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				a[count] = new Integer(line);
				count++;
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	private int partition(int l, int r) {
		// ここを作る
		// クイックソートにおける分割を行う
		int i = l - 1;
		int j = r;
		int pivot = a[r];
		while (true) {
			while (a[++i] < pivot)
				;
			while (i < --j && pivot < a[j])
				;
			if (i >= j) {
				break;
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;

		}
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
		return i;
	}

	private void quicksort(int l, int r) {
		// ここを作る
		// クイックソートを実装する
		// 配列aの中身をソートする
		if(l>=r){
			return;
		}
		int v=partition(l,r);
		quicksort(l,v-1);
		quicksort(v+1,r);
	}

	public void sort() {
		quicksort(0, a.length - 1);
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列arrayをファイルに出力する
		// 1行に1レコード
		try{
			PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(int line:a){
				writer.println(line);
			}
			writer.close();
		}catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}
	}

	public static void main(String[] args) {
		String file1 = "sorted2.txt";
		String file2 = "result_ex4-1_sorted2.txt";

		QuickSort qs = new QuickSort(file1);
		long start,stop;
		start=System.currentTimeMillis();
		qs.sort();
		stop=System.currentTimeMillis();
		System.out.println((stop-start)+"[ms]");
		qs.output(file2);
	}
}