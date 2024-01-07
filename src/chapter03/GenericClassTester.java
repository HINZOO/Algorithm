package chapter03;
//제네릭 클래스의 예
public class GenericClassTester {
	//제네릭 클래스의 매개변수를 T라고 작성함
	static class GenericClass<T>{
		private T xyz;
		
		//생성자
		public GenericClass(T t) {
			this.xyz = t;
		}
		
		T getXyzT () {
			return xyz ;
		}
	}
	
	public static void main(String[] args) {
		//매개변수에 여러타입을 넘길수 있다.
		GenericClass<String>  s  = new GenericClass<String>("ABC");
		GenericClass<Integer>  n  = new GenericClass<Integer>(123);
		
		System.out.println(s.getXyzT());
		System.out.println(n.getXyzT());
	}
}

//제네릭스;Generics 는 처리 대상의 자료형에 의존하지 않도록 클래스(인터페이스)를 구현하는 기능이다.
//제네릭 클래스는 자료형에 의존하징 ㅏㄶ기 때문에 자유롭고 안전하다. 
//클래스와 인터페이스 바로 뒤에 <Type> 형식의 매개변수를 붙여 사용한다.
// class 클래스명 <매개변수1,매개변수2,... > {} //이런식으로 여러개 지정할 수도 있다.
// 매개변수로 자료형을 전달받기 때문에 처리대상 객체의 자료형에 의존하지 않는다.

//파라미터 이름 작성 요령 
//1. 대문자는 1개 사용 (소문자는 가급적 사용X)
//2. 컬렉션 내부요소의 자료 형은 element 의 머릿글자인 E를 사용
//3. Map 내 key, value 의 자료 형은 K,V를 사용
//4. 일반적인 자료형은 T를 사용.

//파라미터에는 와일드 카드를 지정할수도 있다
//<? extends T> : 클래스 T의 하위클래스를 전달받음.
//<? super T > : 클래스 T의 상위클래스를 전달받음.


