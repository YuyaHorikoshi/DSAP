package ex5;

;

public class MyStack {
	private String[] stack;
	private int sp;
	private static final int MAX_SIZE = 10;

	public MyStack() {
		stack = new String[MAX_SIZE];
		sp = 0;
	}

	public void push(String str) {
		if (sp >= MAX_SIZE) {
			System.out.println("スタックが満杯です。push("+str+")");
		}else{
		stack[sp++] = str;
		}
	}

	public String pop() {
		if (sp <= 0) {
			System.out.println("スタックは空です。pop()");
			return null;
		} else {
			String value = stack[--sp];
			stack[sp] = null;
			return value;
		}
	}

	public String peek() {
		if (sp <= 0) {
			System.out.println("スタックは空です。peek()");
			return null;
		} else {
			String value = stack[sp - 1];
			return value;
		}
	}

	public boolean empty() {
		return sp == 0;
	}

	public String toString() {
		String str = "aMyStack(";
		for (int i = 0; i < sp; i++) {
			str = str + stack[i] + " ";
		}
		str = str + ")";
		return str;

	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		System.out.println("スタックにプッシュ");
		System.out.println(stack);
		stack.push("abc");
		stack.push("def");
		stack.push("ghi");
		stack.push("jkl");
		System.out.println(stack);
		stack.push("mno");
		stack.push("pqr");
		System.out.println(stack);
		System.out.println("peekしてみる: " + stack.peek());
		System.out.println("スタックからポップ");
		while (!stack.empty()) {
			System.out.println(stack.pop() + "を取り出した。");
			System.out.println(stack);
		}
		// 以下はエラーチェック用
		System.out.println("エラーを出してみる。");
		System.out.println(stack);
		stack.pop(); // 空のはずなのにpop!
		stack.peek(); // 空のはずなのにpeek!
		System.out.println(stack);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.push("8");
		stack.push("9");
		System.out.println(stack);
		stack.push("10");
		System.out.println(stack);
		stack.push("11"); // 一杯なはずなのにpush!
		System.out.println(stack);

	}

}
