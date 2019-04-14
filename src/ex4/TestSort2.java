package ex4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestSort2 {
	private final int n = 50000;
	private int[] array = new int[n];
	private int[] a = new int[n];
	private int[] b = new int[n];

	public TestSort2(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列arrayに入れる
		int count = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				array[count] = new Integer(line);
				a[count] = new Integer(line);
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
		if (l >= r) {
			return;
		}
		int v = partition(l, r);
		quicksort(l, v - 1);
		quicksort(v + 1, r);
	}

	public void qsort() {
		quicksort(0, a.length - 1);
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
		b = new int[a.length];
		mergesort(0, a.length - 1);
		b = null;
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "sorted.txt";
		String file3 = "reverse2.txt";
		String file4 = "same2.txt";

		TestSort2 bs1 = new TestSort2(file1);
		TestSort2 ss1 = new TestSort2(file1);
		TestSort2 is1 = new TestSort2(file1);
		TestSort2 qs1 = new TestSort2(file1);
		TestSort2 ms1 = new TestSort2(file1);
		TestSort2 bs2 = new TestSort2(file2);
		TestSort2 ss2 = new TestSort2(file2);
		TestSort2 is2 = new TestSort2(file2);
		TestSort2 qs2 = new TestSort2(file2);
		TestSort2 ms2 = new TestSort2(file2);
		TestSort2 bs3 = new TestSort2(file3);
		TestSort2 ss3 = new TestSort2(file3);
		TestSort2 is3 = new TestSort2(file3);
		TestSort2 qs3 = new TestSort2(file3);
		TestSort2 ms3 = new TestSort2(file3);
		TestSort2 bs4 = new TestSort2(file4);
		TestSort2 ss4 = new TestSort2(file4);
		TestSort2 is4 = new TestSort2(file4);
		TestSort2 qs4 = new TestSort2(file4);
		TestSort2 ms4 = new TestSort2(file4);

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
		qs1.qsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms1.msort();
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
		qs2.qsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms2.msort();
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
		qs3.qsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms3.msort();
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
		qs4.qsort();
		stop = System.currentTimeMillis();
		System.out.println("クイックソート:" + (stop - start) + "[ms]");
		start = System.currentTimeMillis();
		ms4.msort();
		stop = System.currentTimeMillis();
		System.out.println("マージソート:" + (stop - start) + "[ms]");
	}

}
