package chapter03;

import java.util.Arrays;
import java.util.Comparator;

//클래스 X의 내부에서 COMPARATOR를 정의하는 방법 
//(클래스 밖에서 정의해도 무관하다)
public class X {
	//필드, 메서드 등
	public static final Comparator<T> COMPARATOR = new Comp();
	
	private static  class Comp implements Comparator<T>{
		public int compare(T d1, T d2) {
			// d1 > d2 양수반환
			// d1 < d2 음수반환
			// d1 == d2 0반환
		}
	}
	public static void main(String[] args) {
		Arrays.binarySearch(T[] a, T key , X.COMPARATOR); //이런식으로 사용한다.
	}
	
	
}
