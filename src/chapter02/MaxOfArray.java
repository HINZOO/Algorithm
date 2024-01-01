package chapter02;

import java.util.Scanner;

//배열 요소의 최댓값 출력

public class MaxOfArray {
	
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1 ; i<a.length ; i++) {
			if( a[i] > max) {
				max = a[i];
			}
		}	
		return max;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = stdIn.nextInt();
		
		int height[] = new int[num];
		
		for(int i = 0; i < num ; i++) {
			System.out.print("height["+i+"] : ");
			height[i] = stdIn.nextInt();
		}
		
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
		stdIn.close();
	}

}
/*
 * 접근제한자 
 * 1) 종류 
 * 	public : 모든 접근 허용
 *  protected : 같은 패키지(폴더)의 객체, 상속 관계의 객체 허용
 *  default : 같은 패키지(폴더)의 객체 허용
 *  private : 현재의 객체 안에서만 허용
 *  
 * 2) 접근 제한자 사용
 *  클래스 : public , default
 *  생성자 : public, protected, default, private
 *  멤버 변수 : public, protected, default, private
 *  멤버 메소드 : public, protected, default, private
 *  지역 변수 : 접근 제한자를 사용할 수 없음.
 * */
 