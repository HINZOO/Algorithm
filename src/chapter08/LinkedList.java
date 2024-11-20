package chapter08;

import java.util.Comparator;

//연결리스트 클래스 
public class LinkedList<E> {
	//노드
	class Node<E>{ //데이터형 E는 임의의 클래스형이 허용.
		private E data; //데이터 (데이터를 참조)
		private Node<E> next; //뒤쪽포인터(다음 노드를 참조)
		
		//생성자 : 매개변수 data, next에 전달받은 값을 해당 필드에 대입.
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리포인터 (머리 노드 참조)
	private Node<E> crnt; // 선택포인터 (선택 노드 참조)
	
	//생성자
	public LinkedList() {
		head = crnt = null;
	}
	/**
	 * 연결리스트가 비어있을때 head == null
	 * 노드가 1개일때 head.next == null 
	 * 노드가 2개일때 head.next.next == null (이때 첫번째 노드는 head.data 이며 두번째 노드는 head.next이다)
	 * 변수 p가 꼬리 노드인지 확인 p.next == null
	 * */
	
	//노드검색
	/**
	 * @param obj 검색할때 키가 되는 데이터를 넣어둔 객체
	 * @param c   매개변수와 연결리스트의 개별 노드안에 있는 데이터를 비교하기위한 comparator c로 obj와 선택한 노드의
	 *            데이터를 비교하여 그 결과가 0이면 검색조건이 성립하는것으로 봄.
	 *            (cf.Comparator :  두 매개변수의 객체비교 / Comparable: 자기자신과 매개변수 객체를 비교
	 *           	compare의 결과 
	 *           	 0: 두 객체가 같다고 판단되었을 때.
	 *				음수: 첫 번째 객체가 두 번째 객체보다 작을 때.
	 *				양수: 첫 번째 객체가 두 번째 객체보다 클 때.
	 */
	public E search(E obj, Comparator<? super E> c) { 
		Node<E> ptr = head; //현재 스캔중인 노드
		while(ptr!=null) {
			if(c.compare(obj, ptr.data) == 0) {//검색성공 (compare interface
				crnt=ptr;
				return ptr.data;
			}
			ptr = ptr.next; //다음 노드를 선택
		}
		return null; //검색실패 
	}
	
	
	//머리노드에 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; //삽입전의 머리노드
		head = crnt = new Node<E>(obj,ptr);
	}
	
	//꼬리에 노드 삽입
	//리스트가 비어있는 경우 => 리스트 머리에 노드를 삽입 => addFirst 사용
	//리스트가 비어있지 않은 경우 => 리스트 꼬리에 노드 G를 삽입
	public void addLast(E obj) {
		if(head == null) {
			addFirst(obj);
		}else {
			Node<E> ptr = head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}//while 문을 종료할때  ptr은 꼬리노드를 가리킨다.
			ptr.next = crnt = new Node<E> (obj,null); //꼬리노드의 값을 입력.. 잊지말것! ==> Node<E> (노드참조,뒤쪽포인터참조);
		}
	}
	
	//머리노드를 삭제하는 메서드
	public void removeFirst() {
		if(head != null) {
			head = crnt = head.next; //헤드값을 헤드의 다음값으로 업데이트
		}
	}
	//꼬리노드를 삭제하는 메서드
	//리스트의 노드가 1개인 경우 => 머리노드를 삭제 => removeFirst 사용.
	//리스트의 노드가 2개이상인경우 => 리스트에서 꼬리노드F를 삭제
	public void removeLast() {
		if(head !=null) {
			if(head.next == null) {
				removeFirst();
			}else {
				Node<E> ptr = head;	 //스캔중인 노드
				Node<E> pre = head;  //스캔중인 노드의 앞쪽 노드
				
				while (ptr.next != null) { //while문이 끝날때 ptr은 꼬리노드를 가리킴. pre는 꼬리에서 두번째 노드를 가리킴
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;		//pre는 삭제 후의 꼬리노드 //pre.next == ptr
				crnt = pre; //삭제후 선택포인터를 꼬리노드로 업데이트
			}
		}
	}
	
	//(1~4) 선택한 노드를 삭제하는 메서드
	//1.노드 p를 삭제 
	public void remove (Node p) {
		if(head != null) {
			if (p==head) {//선택한 노드가 head일때
				removeFirst();
			}else {
				Node<E> ptr = head; //포인터를 제일앞에두고
				while(ptr.next != p) { //차례로 스캔 
					ptr = ptr.next;
					if(ptr == null) return ; //마지막이면 리턴
				}
				ptr.next = p.next; //ptr.next== p인 지점에 p의 다음값을 대입 =>즉 p의 해당노드를 뒤쪽노드값으로 대체 (삭제의개념)
				crnt = ptr; //선택포인트를 마지막 포인트로 지정 //삭제노드 바로 앞으로 지정.
			}
		}
	}
	
	//2.선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt); //실행후 crnt가 참조하는 곳은 삭제한 노드의 바로 앞 노드로 업데이트.
	}
	
	//3.모든 노드를 삭제
	public void clear() {
		while(head != null) { //노드에 아무것도 없을 때 까지
			removeFirst(); //머리노드를 삭제
		}
		crnt = null; // crnt 값도 null로 업데이트
	}
	
	//4.선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if(crnt==null || crnt.next == null) {
			return false; //진행불가
		}
		crnt = crnt.next; //노드를 뒤쪽으로 옮김. 
		return true;
	}
	
	//선택 노드를 출력
	 public void printCurrentNode() {
		 if(crnt ==null) {
			 System.out.println("선택한 노드가 없습니다.");
		 }else {
			 System.out.println(crnt.data);
		 }
	 }
	
	 //모든 노드를 출력
	 public void dump() {
		 Node<E> ptr = head;
		 
		 while(ptr != null) {
			 System.out.println(ptr.data);
			 ptr = ptr.next;
		 }
	 }
	
	
}
