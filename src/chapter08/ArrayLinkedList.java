package chapter08;

import java.util.Comparator;

public class ArrayLinkedList<E> {

	// 노드
	@SuppressWarnings("hiding")
	class Node<E> {
		private E data; // 데이터
		private int next; // 리스트의 뒤쪽 포인터
		private int dnext; // 프리 리스트의 뒤쪽 포인터

		// data와 next를 설정
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n; // 리스트 본체
	private int size; // 리스트의 용량 (가장 큰 데이터 수)
	private int max; // 사용중인 꼬리 recode
	private int head; // 머리노드
	private int crnt; // 선택노드
	private int deleted; // 프리 리스트의 머리노드
	private static final int NULL = -1; // 다음노드 없음 /리스트가 가득참

	// 생성자
	@SuppressWarnings("unchecked")
	public ArrayLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++) {
				n[i] = new Node<E>();
			}
			size = capacity;
		} catch (OutOfMemoryError e) { //배열생성실패
			size = 0;
		}
	}

	
	//다음에 삽입하는 record의 인덱스를 구함
	private int getInsertIndex() {
		if (deleted == NULL) {    // 삭제할 recode가 없음
			if (max < size) {
				return ++max;    // 새 recode를 사용
			} else {
				return NULL;     // 용량 넘침
			}
		} else {
			int rec = deleted;   // 프리리스트에서 머리 rec를 꺼냄
			deleted = n[rec].dnext;
			return rec;
		}
	}
	
	//recode idx를 프리리스트에 등록
	private void deleteIndex(int idx) {
		if(deleted == NULL) {  //삭제할 record가 없음
			deleted = idx;     //idx를 프리리스트의 머리에 등록
			n[idx].dnext = NULL;
		}else {
			int rec = deleted;	
			deleted = idx;		//idx를 프리리스트의 머리에 삽입
			n[idx].dnext = rec;
		}
	}
	
	//노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;						//현재 스캔중인 노드
		
		while (ptr != NULL) {
			if(c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data;			//검색성공
			}
			ptr = n[ptr].next ; 		//다음 노드에 주목
		}
		return null;					//검색실패
	}
	
	//머리에 노드를 삽입
	public void addFirst(E obj) {
		int ptr = head;
		int rec = getInsertIndex();
		if(rec != NULL) {
			head = crnt = rec;
			n[head].set(obj, ptr);
		}
	}
	
	//꼬리에 노드를 삽입
	public void addLast(E obj) {
		if(head == NULL) {
			addFirst(obj);
		}else {
			int ptr = head;
			while(n[ptr].next != NULL) {
				ptr = n[ptr].next;
			}
			int rec = getInsertIndex();
			if(rec != NULL) {
				n[ptr].next = crnt = rec;
				n[rec].set(obj, NULL);
			}
		}
	}
	
	//머리 노드를 삭제
	public void removeFirst() {
		if (head != NULL) {
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}
	
	//꼬리 노드를 삭제
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) {
				removeFirst();
			}else {
				int ptr = head;
				int pre = head;
				
				while(n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;
				deleteIndex(ptr);
				crnt = pre;
			}
		}
	}
	
	//recode p 삭제
	public void remove(int p) {
		if(head != NULL) {
			if( p == head ) {
				removeFirst();
			}else {
				int ptr = head;
				while(n[ptr].next != p) {
					ptr = n[ptr].next;
					if(ptr == NULL) return; //p가 리스트에 없으면 뱉어.
				}
				n[ptr].next = NULL;
				deleteIndex(p);
				n[ptr].next = n[p].next;
				crnt = ptr;			
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드를 삭제
	public void clear() {
		while(head != NULL) {
			removeFirst();
		}
		crnt = NULL;		//선택노드를 -1로 설정 (빈값)
	}
	
	
	//선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if(crnt == NULL || n[crnt].next == NULL) { return false;}
		crnt = n[crnt].next;
		return true;
	}
	
	//선택 노드를 출력
	public void printCurrentNode() {
		if(crnt == NULL) System.out.println("선택 노드가 없습니다.");
		else System.out.println(n[crnt].data);
	}
	
	//모든 노드를 출력
	public void dump() {
		int ptr = head;
		
		while(ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}
