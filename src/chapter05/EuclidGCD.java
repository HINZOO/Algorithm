package chapter05;

import java.util.Scanner;

//유클리드 호제법
//최대공약수를 구하는 대표적인 알고리즘.
//2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), 
//a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 
//이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 
//다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다
public class EuclidGCD {
	// 정수 x,y의 최대공약수를 구하여 반환 
	static int gcd (int x, int y) {
		if(y == 0) 
			return x;
		else 		
			return gcd(y, x % y);
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
