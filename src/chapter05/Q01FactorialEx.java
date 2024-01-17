package chapter05;

import java.util.Scanner;

public class Q01FactorialEx {
	//음이아닌 정수n의 팩토리얼값을 반환
	static int factorial(int n) {
		int result = 1;
		if( n > 0) {
			for(int i = n; i >= 1 ; i --) {
				result *= i;
			}
		}	
		return result ;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.: ");
		int x = scanner.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다");
		scanner.close();
	}
}
