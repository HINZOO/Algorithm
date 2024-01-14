package chapter04;

public class Queue<E> {
	private E[] que;
	private int capacity;
	private int num;
	private int front;
	private int rear;
	
	//--- 실행 시 예외 : 큐가 비어 있음 ---//
	public static class EmptyGqueueException extends RuntimeException {
		public EmptyGqueueException() { }
	}

	//--- 실행 시 예외 : 큐가 가득 참 ---//
	public static class OverflowGqueueException extends RuntimeException {
		public OverflowGqueueException() { }
	}
	
	//--- 생성자 ---//
	public Queue (int maxlen){
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = (E[])new Object[capacity];
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	//--- enqueue ---//
	public E enque (E x) throws OverflowGqueueException{
		if(num >= capacity) throw new OverflowGqueueException();
	
		que[rear++] = x;
		num++;
		
		if(rear == capacity) rear = 0;
		return x;
	}
	
	
	//--- dequeue ---//
	public E deque() throws EmptyGqueueException{
		if(num <= 0) throw new EmptyGqueueException();
		
		E x = que[front++];
		num--;
		
		if(front == capacity) front = 0;
		return x;
	}
	
 	//--- peek ---//
	public E peek() throws EmptyGqueueException{
		if(num <= 0) throw new EmptyGqueueException();
		return que[front];
	}
	

	//--- indexOf ---//
	public int indexOf (E x) {
		for (int i = 0 ; i < num ; i++) {
			if( que[(i+front)%capacity].equals(x)) 
				return front+i;
		}		
		return -1;
	}
	//--- search ---//
	public int search (E x) {
		for (int i = 0 ; i < num ; i++) {
			if( que[(i+front)%capacity].equals(x)) 
				return (i+1);
		}		
		return -1;
	}
	
	//--- clear ---//
	public void clear() {
		num = rear = front = 0 ;
	}
	
	//--- getCapacity ---//
	public int getCapacity() {
		return capacity;
	}
	
	//--- size ---//
	public int size() {
		return num;
	}

	//--- isEmpty ---//
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//--- isFull ---//
	public boolean isFull() {
		return num >= capacity;
	}
	
	//--- dump ---//
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		}else {		
			for (int i = 0 ; i < num ; i++) {
				System.out.print( que[(i+front)%capacity].toString() + " ");						
			}
			System.out.println();
		}
	}
}
