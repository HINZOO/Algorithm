package chapter04;

public class Stack<E> {
	private E[] stk;		// 스택용 배열
	private int capacity;	// 스택 용량
	private int ptr;		// 스택 포인터
	
	public static class EmptyGstackException extends RuntimeException{
		public EmptyGstackException() {}
	}
	
	public static class OverflowGstackException extends RuntimeException{
		public OverflowGstackException() {}
	}
	
	public Stack( int maxlen ) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = (E[])new Object[capacity];   //스택 본체용 배열을 생성
		}catch (OutOfMemoryError e) {           //생성할 수 없음.
			capacity = 0;
		}		
	}
	
	//push
	public E push(E x) throws OverflowGstackException{
		if(ptr >= capacity) {
			throw new OverflowGstackException();
		}
		return stk[ptr++] = x;
	}
	
	//pop
	public E pop() throws EmptyGstackException{
		if (ptr <= 0) {
			throw new EmptyGstackException();
		}
		return stk[--ptr];
	}	
	
	//Peek
	public E peek() throws EmptyGstackException{
		if (ptr <= 0) {
			throw new EmptyGstackException();
		}
		return stk[ptr - 1];
	}
	
	//clear
	public void clear() {
		ptr = 0;
	}
	
	//IndexOf
	public int indexOf(E x) {
		for(int i = ptr -1 ; i >= 0 ; i--) {
			if(stk[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	
	//getCapacity
	public int getCapacity() {
		return capacity;
	}
	
	//size
	public int size () {
		return ptr;
	}
	
	//isEmpty
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//isFull
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	//dump
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i = 0; i < ptr ; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
	
}
