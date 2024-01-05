package chapter03;
//인스턴트 메서드 : static을 붙이지 않고 선언한 메서드 그 클래스 형의 개별 인스턴스에 속함.
//클래스 메서드 : static 을 붙여 선언한 메서드로 특정 인스턴스에 속하지 않음
class Id {
	private static int counter = 0; //클래스 변수
	private int id ; //인스턴스 변수 
	//생성자
	public Id() { id = ++ counter;}
	
	//counter를 반환하느 클래스 메서드
	public static int getCounter() { return counter; }
	//아이디를 반환하는 인스턴스 메서드
	public int getId() { return id; }
}


public class IdTester {
	public static void main(String[] args) {
		Id a = new Id(); //아이디1
		Id b = new Id(); //아이디2
		
		System.out.println("a의 아이디: " + a.getId());
		System.out.println("b의 아이디: " + b.getId());
		
		System.out.println("부여한 아이디의 개수 : " + Id.getCounter());
		
		//클래스 변수 counter는 인스턴스와 관계없이 1개만 만들어 지고 특정 시점에 아이디를 몇번까지 부여했는지를 알수 있다.
		//인스턴스변수 id는 인스턴스마다 각각 1개씩 할당되고 해당 인스턴스의 아이디를 나타낸다.
		//인스턴스 메서드 호출 : 클래스형 변수이름.메서드이름(..)
		//클래스 메서드 호출 : 클래스이름.메서드이름(..)
		
	}
}
