package ex7;

public class Factorial2 {
	public static int factorial(int x) {
		if (x == 0) {
			return 1;
		} else {
			return x * factorial(x - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("再帰を使って階乗を求めます。");
		for (int i = 0; i < 6; i++) {
			System.out.println(i + "の階乗は" + factorial(i));
		}
	}
}
