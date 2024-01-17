package chapter05;

import java.util.Scanner;

public class Q04Recur2 {
	//--- 재귀 메서드 ---//
	static void recur(int n) {
		if (n > 0) {
			recur(n - 2);
			System.out.println(n);
			recur(n - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = scanner.nextInt();

		recur(x);
		scanner.close();
	}
}
