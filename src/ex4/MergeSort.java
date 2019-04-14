package ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeSort {
	private final int n = 50000;
	private int[] a = new int[n];
	private int[] b = new int[n];

	public MergeSort(String filename) {
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

	private void mergesort(int low, int high) {
		// ここを作る
		// マージソートを実装する
		// 配列aの中身をソートする
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergesort(low, mid);
		mergesort(mid + 1, high);
		System.arraycopy(a, low, b, low, mid - low + 1);

		for (int i = mid + 1, j = high; i <= high; i++, j--) {
			b[i] = a[j];
		}
		int i = low;
		int j = high;
		for (int k = low; k <= high; k++) {
			if (b[i] <= b[j]) {
				a[k] = b[i++];
			} else {
				a[k] = b[j--];
			}
		}
	}

	public void sort() {
		b=new int[a.length];
		mergesort(0, a.length - 1);
		b=null;
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列aをファイルに出力する
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
		String file1 = "rand2.txt";
		String file2 = "result_ex4-2_rand2.txt";

		MergeSort ms = new MergeSort(file1);
		long start,stop;
		start=System.currentTimeMillis();
		ms.sort();
		stop=System.currentTimeMillis();
		System.out.println((stop-start)+"[ms]");
		
		ms.output(file2);
	}
}