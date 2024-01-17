package chapter05;

import java.util.Scanner;

public class Recur {
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
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
//순수 재귀 : 메서드안에 재귀호출을 여러번 실행하는 메서드
//상향식이나 하향식 방법으로 분석한다.
//실제 분석시에는 상향식이 좀더 이해가 쉬운것같다..(..개인의견)