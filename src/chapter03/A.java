package chapter03;

//자연 정렬을 하려면 다음과 같은 패턴으로 클래스를 정의
public class A implements Comparable<A> {// Comparable 인터페이스 구현
	
	//필드, 메서드..
	
	public int compareToA(A c) {
		// compare To 메서드 구현 
		// this 가 c 보다 크면 양의 값 반환
		// this 가 c 보다 작으면 음의 값 반환
		// 같으면 0 반환
	}
	
	public boolean equals(Object c) {
		//Equals 메서드 구현
		// this가 c와 같으면 true
		// this가 c와 같지 않으면 false
	}

}
//자연정렬이 되지 않은 배열에서 검색은 제네릭메서드를 사용한다.
// static <T> int binarySearch(T[] a, T key, Comparator <? super T> c)
// 제네릭으로 구현한 메서드의 첫번째 매개변수 a는 검색대상이고 두번째 매개변수 key는 key rkqtdlek.
// 제네릭 메서드는 자료형에 구애 받지 않는다.
// 다만 배열 요소가 어떤 순서로 나열되어있느지, 각요소의 대소관계를 어떻게 판단할 것인지등은 
// binarySearch 메서드에 알려줘야 하며 이정보는 세번째 매개변수 c 에 전달된다. 

//Comparator <? super T> c
//클래스 T (또는 클래스T의 상위클래스)의 두 객체 사이 대소관계를 생성하기 위한 comparator 이다.
// comparator 안에는 compare 메서드가 있다.

//java.util.Comparator 메서드의 정의
//package java.util;
//public interface Comparator<T>{
//	int compare(T o1, T o2);
//	boolean equals(Object obj);
//}

// 이 다음내용은 X.java 파일 참고