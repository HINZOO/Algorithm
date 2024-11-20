package chapter08.prac;

import java.util.Comparator;

public class LinkedList <E> {
	//--노드--//
	class Node<E>{
		private E data; //데이터
		private Node<E> next ; // 뒤쪽 포인터 (다음 노드에 대한 참조)
		
		
		//--생성자--//
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; //머리포인터
	private Node<E> crnt; //선택포인터
	
	//--생성자--//
	public LinkedList() {
		head = crnt = null;
	}
	
	//--노드 검색--//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;
		while(ptr != null) {
			if(c.compare(obj, ptr.data)==0) {//obj === ptr.data 이면
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; //아니면 다음 노드를 선택
		}
		return null;
	}
	
	//-- 머리에 노드를 삽입 --//
	public void addFirst(E obj) {
		Node<E> ptr = head; // 현재 포인터를 머리로 변경
		head = crnt = new Node<E>(obj,ptr);//머리포인터와 현재포인터에 포인터를 head로 변경하고, 새오브젝트값을 넣음
	}
	
	//-- 꼬리에 노드를 삽입 --//
	public void addLast(E obj) {
		if (head == null) {
			addFirst(obj);
		}else {
			Node<E> ptr = head;
			while(ptr.next != null) {//마지막 노드를 찾아
				ptr = ptr.next; //포인터에 마지막의 다음포인터값을 넣고
			}
			ptr.next = crnt = new Node<E>(obj,null); //그값에 obj 넣음.
		}
	}
	
	//-- 머리 노드를 삭제 --//
	public void removeFirst() {
		if (head != null) { //리스트가 비어있지 않을때 사용가능
			head = crnt = head.next;
		}
	}
	
	//-- 꼬리 노드를 삭제--//
	public void removeLast() {
		if (head != null) {
			if(head.next == null) {// 노드가 1개뿐일경우
				removeFirst();
			}else { //노드가 여러개
				Node<E> ptr = head; //스캔중인노드
				Node<E> pre = head; //스캔중인 노드의 앞쪽 노드
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; //pre가 삭제 후의 꼬리노드가 되기때문에 pre 다음노드는 null로 맞춰줌.
				crnt = pre; //pre는 삭제 후의 꼬리노드가 된다.
			}
		}
	}
	
	//-- 노드 p를 삭제 --//
	public void remove(Node p) {
		if(head != null) {
			if(p == head) {
				removeFirst();
			}else {
				Node<E> ptr = head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr== null) return ; //p가 리스트에 없으면 리턴
				}
				ptr.next = p.next; //포인터의 다음값을 p의다음 값으로지정
				crnt = ptr; //선택 포인터를 ptr로 지정
			}
		}
	}
	
	//-- 선택 노드를 삭제 --//
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//-- 모든 노드를 삭제 --//
	public void clear() {
		while(head != null) {
			removeFirst(); //노드에 아무것도 없을때 까지 머리노드 삭제
		}
		crnt = null;//선택포인터도 초기화
	}
	//--- 선택 노드를 하나 뒤쪽으로 진행 ---//
	public boolean next() {
		if(crnt == null || crnt.next == null) 
			return false; //없는경우 못함
		crnt = crnt.next;
		return true;
	}
	
	//--- 선택 노드를 출력 ---//
	public void printCurrentNode() {
		if (crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		}else {
			System.out.println(crnt.data);
		}
	}
	
	//--- 모든 노드를 출력 ---//
	public void dump() {
		Node<E> ptr = head;
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//---(연습8-1) 컴퍼레이터c로 서로 같은 노드를 찾아 모든 노드를 삭제 ---//
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head;
		
		while(ptr != null) {
			int count = 0;
			Node<E> ptr2 = ptr; // 이전노드의 다음노드
			Node<E> pre = ptr; // 이전노드
			
			while(pre.next != null) {
				ptr2 = pre.next; //이전노드의 다음노드로 ptr2설정
				if(c.compare(ptr.data, ptr2.data) == 0) { //이전의다음노드와 현노드 비교
					pre.next = ptr2.next; //같은경우 서로 같은 값을 가지고
					count++; //카운트 증가
				}else {
					pre = ptr2; //다른경우 이전노드에 현재노드 대입 (pre와 ptr2는 이렇게 조작되면서 ptr의 대비군이 된다)
				}
			}
			if (count == 0) {
				ptr = ptr.next; //카운트가 0인경우 (같은걸 못찾음) ptr을 다음값으로 설정하여 재비교
			}else {
				Node<E> temp = ptr; //temp 노드를 생성하여 현재 포인터를 넣고
				remove(ptr); //해당포인터를 지움
				ptr = temp.next; //ptr의 다음노드를 포인터에 대입. 
			}
		}
		crnt = head; // 모든작업이 끝난후 선택포인터는 head로 변경
 	}
	
	//---(연습8-2) 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환 ---//
	public E retrieve(int n) {
		Node<E> ptr = head;
		 while(n>=0 && ptr != null) {
			if(n-- == 0) { 
				crnt = ptr;
				return ptr.data;	 //검색에 성공했을때
			}
			ptr = ptr.next;
		}
		return null;
	}
	
}
