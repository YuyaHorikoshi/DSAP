package ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestSort {
	private final int n = 50000;
	private int[] array,a,b = new int[n];

	public TestSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列arrayに入れる
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				array[count] = new Integer(line);
				a[count]=new Integer(line);
				count++;
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public void bsort() {
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

	public void ssort() {
		int num = array.length;
		for (int i = 0; i < n - 1; i++) {
			int lowest = i;
			int lowkey = array[i];
			for (int j = i + 1; j < n; j++) {
				if (array[j] < lowkey) {
					lowest = j;
					lowkey = array[j];
				}
			}
			int temp = array[i];
			array[i] = array[lowest];
			array[lowest] = temp;
		}
	}

	public void isort() {
		int num = array.length;
		for (int i = 1; i < n; i++) {
			int j = i;
			while (j >= 1 && array[j - 1] > array[j]) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
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

	public void msort() {
		b=new int[a.length];
		mergesort(0, a.length - 1);
		b=null;
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "sorted.txt";
		String file3 = "reverse2.txt";
		String file4 = "same2.txt";

		TestSort bs1 = new TestSort(file1);
		TestSort ss1 = new TestSort(file1);
		TestSort is1 = new TestSort(file1);
		TestSort qs1 = new TestSort(file1);
		TestSort ms1 = new TestSort(file1);
		TestSort bs2 = new TestSort(file2);
		TestSort ss2 = new TestSort(file2);
		TestSort is2 = new TestSort(file2);
		TestSort qs2 = new TestSort(file1);
		TestSort ms2 = new TestSort(file1);
		TestSort bs3 = new TestSort(file3);
		TestSort ss3 = new TestSort(file3);
		TestSort is3 = new TestSort(file3);
		TestSort qs3 = new TestSort(file1);
		TestSort ms3 = new TestSort(file1);
		TestSort bs4 = new TestSort(file4);
		TestSort ss4 = new TestSort(file4);
		TestSort is4 = new TestSort(file4);
		TestSort qs4 = new TestSort(file1);
		TestSort ms4 = new TestSort(file1);

		long start, stop;

		System.out.println("rand2.txtのソート");
		start = System.currentTimeMillis();
		bs1.bsort();
		stop = System.currentTimeMillis();
		System.out.println("バブルソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ss1.ssort();
		stop = System.currentTimeMillis();
		System.out.println("選択ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		is1.isort();
		stop = System.currentTimeMillis();
		System.out.println("挿入ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		qs1.bsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms1.ssort();
		stop = System.currentTimeMillis();
		System.out.println("マージソート:" + (stop - start) + "[ms]");

		System.out.println("reverse2.txtのソート");
		start = System.currentTimeMillis();
		bs2.bsort();
		stop = System.currentTimeMillis();
		System.out.println("バブルソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ss2.ssort();
		stop = System.currentTimeMillis();
		System.out.println("選択ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		is2.isort();
		stop = System.currentTimeMillis();
		System.out.println("挿入ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		qs2.bsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms2.ssort();
		stop = System.currentTimeMillis();
		System.out.println("マージソート:" + (stop - start) + "[ms]");

		System.out.println("sorted2.txtのソート");
		start = System.currentTimeMillis();
		bs3.bsort();
		stop = System.currentTimeMillis();
		System.out.println("バブルソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ss3.ssort();
		stop = System.currentTimeMillis();
		System.out.println("選択ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		is3.isort();
		stop = System.currentTimeMillis();
		System.out.println("挿入ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		qs3.bsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms3.ssort();
		stop = System.currentTimeMillis();
		System.out.println("マージソート:" + (stop - start) + "[ms]");

		System.out.println("same2.txtのソート");
		start = System.currentTimeMillis();
		bs4.bsort();
		stop = System.currentTimeMillis();
		System.out.println("バブルソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ss4.ssort();
		stop = System.currentTimeMillis();
		System.out.println("選択ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		is4.isort();
		stop = System.currentTimeMillis();
		System.out.println("挿入ソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		qs4.bsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms4.ssort();
		stop = System.currentTimeMillis();
		System.out.println("マージソート:" + (stop - start) + "[ms]");
	}

}
