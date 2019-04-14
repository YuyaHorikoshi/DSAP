package ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByNumeric2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String file1 = "rand2.txt";
		String file2 = "result_ex2-5.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		System.out.println("ソート前");
		for (String str : list) {
			System.out.println(str);
		}

		Collections.sort(list);

		System.out.println("ソート後");
		for (String str : list) {
			System.out.println(str);
		}

		Collections.sort(list, new NumericComparator2());

		System.out.println("順序付けを変更後");
		for (String str : list) {
			System.out.println(str);
		}
		try{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(file2)));
		for(String line:list){
			writer.println(line);
		}
		writer.close();
		}
		catch(FileNotFoundException e){
		}
		catch(IOException e){
		}
		}
	}


class NumericComparator2 implements Comparator<String> {
	// ここを作る
	// Stringのソートは辞書順になるが，
	// 数値順となるように順序付けする
	public int compare(String str1, String str2) {
		return new Integer(str1).compareTo(new Integer(str2));
	}
}