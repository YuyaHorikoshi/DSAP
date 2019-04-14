package ex6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordCounter {
	public static void main(String[] args) {
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		String filename = "english.txt";
		String line;
		String[] word;
		int count=1;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				word = line.split(" ");
				for (String list:word) {
					if(hs.containsKey(list)){
						count=hs.get(list)+1;
					}else if(!hs.containsKey(list)){
					count=1;
					}
					hs.put(list, count);
				System.out.println(list+"　=>　"+count);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}
}
