package chapter05;

import java.util.Scanner;

// 재귀(recursive) :  어떤 사건이 자기자신을 포함하고 있거나 또는 자기자신을 사용하여 정의하고 있을때를 의미
//팩토리얼을 활용해 재귀를 사용해보기
// 10! = 10 * 9! 
// 9! = 9 * 8! 임를 이용해 재귀함수 만들기
public class Factorial {
	
	//음이아닌 정수n의 팩토리얼값을 반환
	static int factorial(int n) {
//		if(n>0) {
//			return n * factorial(n-1);
//		}else {
//			return 1;
//		}
		return (n > 0) ? n*factorial(n-1) : 1 ;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.: ");
		int x = scanner.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다");
		scanner.close();
	}
}
//직접재귀와 간접재귀
//1) 직접재귀 : 자신과 동일한 메서드를 호출하는것
//2) 간접재귀 : 메서드 a가 메서드 b를 호출하고 다시 메서드 b가 메서드 a를 호출하는 구조

