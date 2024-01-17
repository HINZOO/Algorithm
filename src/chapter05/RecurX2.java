package chapter05;

import java.util.Scanner;

public class RecurX2 {
	static void recur(int n) {
//-- 원본 --//
//		if (n > 0) {
//			recur(n - 1);
//			System.out.println(n);
//			recur(n - 2);
//		}
		while(n > 0) {
			recur(n-1);
			System.out.println(n);
			n = n  - 2 ; //꼬리 재귀 제거 
						//n을 n-2로 업데이트 하고 메서드의 시작지점으로 돌아간다는 의미와 같기때문애
						//재귀를 이런식으로 없애줄 수 있다.
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
