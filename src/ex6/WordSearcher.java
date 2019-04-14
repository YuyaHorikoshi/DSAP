package ex6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WordSearcher {

	public static void main(String[] args) {
		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("tomato", "トマト");
		hs.put("strawberry", "苺");
		hs.put("orange", "蜜柑");
		hs.put("onion", "玉葱");
		hs.put("apple", "林檎");
		hs.put("banana", "バナナ");
		System.out.println("英単語を入力してください。");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = reader.readLine()) != null) {
				if (hs.get(line) != null) {
					System.out.println(line + "の意味は[" + hs.get(line) + "]です。");
				} else {
					System.out.println(line + "という単語は見つかりません");
				}
			}
			reader.close();
		} catch (Exception e) {
		}
	}

}
