package chapter02;

//구성요소의 자료형이 int형인 배열
public class IntArray {
	public static void main(String[] args) {
		int[] a = new int[5];
		
		a[1] = 37;
		a[2] = 37;
		a[4] = a[1]*2;
		
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println("a["+i+"] = "+a[i]);
		
		}
		//정의하지 않은 배열의 값은 0으로 초기화 된다.
		//char와 참조형은  null, boolean은 false 가 된다.
		
	}
}
