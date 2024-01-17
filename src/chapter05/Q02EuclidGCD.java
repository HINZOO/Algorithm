package chapter05;

import java.util.Scanner;

public class Q02EuclidGCD {
	static int gcd (int x, int y) {
	 while(y != 0){
		
		int temp = x;
		x = y;
		y = temp % y;
			
	}
		return x;
			
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("두 정수의 최대공약수를 구합니다.");
		
		System.out.print("정수를 입력하세요: "); int x = scanner.nextInt();
		System.out.print("정수를 입력하세요: "); int y = scanner.nextInt();
		
		System.out.println("최대 공약수는 "+ gcd(x, y) + "입니다.");
		scanner.close();
	}
}
