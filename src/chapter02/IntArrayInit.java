package chapter02;

//구성요소의 자료형이 int형인 배열 
public class IntArrayInit {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};//배열을 선언하고 즉시 초기화 
		
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println("a["+i+"] = "+a[i]);		}
	}
	
}
