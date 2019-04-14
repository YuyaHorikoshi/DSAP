package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BubbleSort {
	private final int n = 50000;
	private int[] array = new int[n];

	public BubbleSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列arrayに入れる
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				array[count] = new Integer(line);
				count++;
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public void sort() {
		// ここを作る
		// バブルソートを実装する
		// 配列arrayの中身をソートする
		int num = array.length;
		for (int i = 0; i < num - 1; i++) {
			for (int j = num - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列arrayをファイルに出力する
		// 1行に1レコード
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for (int line : array) {
				writer.println(line);
			}
			writer.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "result_ex3-1_rand2.txt";

		BubbleSort bs = new BubbleSort(file1);
		long start,stop;
		start=System.currentTimeMillis();
		bs.sort();
		stop=System.currentTimeMillis();
		System.out.println((stop-start)+"[ms]");
		bs.output(file2);
	}

}
