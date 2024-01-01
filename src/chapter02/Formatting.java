package chapter02;

//문자형식지정자 %d : 숫자 %s : string

public class Formatting {
	public static void main(String[] args) {
		int n = 10;
		int r = 55;
		int x = 1234;
		System.out.printf(String.format("%%2d | %%2d\n", n), r, x);
		System.out.println( String.format("%%2d | %%2d\n", n));
		System.out.println( String.format("%%2d | %%%dd\n", n));
		System.out.printf( String.format("%%2d | %%%dd\n", n),r,x);
		
		//String.format 자체에서 %%를 붙여야 %으로 인식
		//%%dd = %2d 와 같다.
		//System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
		//String.format("%%2d | %%%dd\n", n) 을 출력하면.%2d | %10d 로 출력 이를
		System.out.printf("%2d | %10d" ,r,x);// 와 같은 의미로 출력됨.

		
	}
}
