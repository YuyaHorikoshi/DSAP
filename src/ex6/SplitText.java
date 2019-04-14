package ex6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SplitText {
	public static void main(String[] args) {
		String filename = "english.txt";
		String line;
		String[] word;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				word = line.split(" ");
				for (int i = 0; i < word.length; i++) {
					System.out.println(word[i]);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

}
