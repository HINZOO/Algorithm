package chapter08;

class A {
	// toString 정의안함
}

class B {
	int x;

	// 생성자
	B(int x) {
		this.x = x;
	}

	// toString 오버라이드
	public String toString() {
		return "B[" + x + "]";
	}
}

public class ToStringTester {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		B b1 = new B(18);
		B b2 = new B(55);

		System.out.println("a1 = " + a1.toString());
		System.out.println("a2 = " + a2.toString());
		System.out.println("b1 = " + b1.toString());
		System.out.println("b2 = " + b2.toString());
	}
}
//toString을 정의하지않으면 자바 내부의 해시값을 정의한다 Object 클래스의  toString 참고
//Object obj = new Object(); 클래스 내 의 toString 함수 정의 내용 --->
//public String toString() {
//    return getClass().getName() + "@" + Integer.toHexString(hashCode());
//}
//a1 = chapter08.A@18bf3d14 
//a2 = chapter08.A@4fb64261
//b1 = B[18]
//b2 = B[55]
