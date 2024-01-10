package chapter04;
//Q04를 위한 queue 생성
public class IntArrayQueue {
	private int[] que; 	//큐용 배열
	private int capacity; // 큐용량
	private int num ; // 현재 데이터 개수
	
	//--예외처리--//
	 public class EmptyIntArrayQueueException extends RuntimeException{
		 public EmptyIntArrayQueueException(){}
	 }
	 
	 public class OverflowIntArrayQueueException extends RuntimeException{
		 public OverflowIntArrayQueueException() {}
	 } 
	
	
	 //--생성자--//
	public IntArrayQueue(int maxlen) {
		num = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		}catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	
	//--enQueue--//
	public int enque(int x) throws OverflowIntArrayQueueException {
		if(num >= capacity) throw new OverflowIntArrayQueueException();
		que[num++] = x;
		return x;	
	}
	
	//--deQueue--//
	public int deque() throws EmptyIntArrayQueueException{
		if(num <= 0 ) throw new EmptyIntArrayQueueException();
		int x = que[0];//deque되는 값 저장 
		for (int i = 0 ; i< num - 1; i++) { //뒤의 인덱스를 앞으로 하나씩 옮김
			que[i]= que[i+1]; 
		}
		num--;//배열 크기 줄이기
		return x;//디큐된 값 출력
	}
	
	//--Peek(맨 앞의 데이터 출력 (꼭대기 데이터 출력)--//
	public int peek() throws EmptyIntArrayQueueException{
		if (num <= 0 ) throw new EmptyIntArrayQueueException();
		return que[num-1]; 
	}
	
	//--indexOf --//
	public int indexOf(int x) {
		for(int i=0 ; i<num ; i++) {
			if( que[i] == x) return i;
		}
		return -1; //검색실패
	}
	
	//--Clear--//
	public void clear() {
		num = 0;
	}
	
	//--capacity--//
	public int capacity() {
		return capacity;
	}
	
	//--size--//
	public int size() {
		return num ;
	}
	//--isEmpty--//
	public boolean isEmpty() {
		return num <= 0;
	}
	//--isFull--//
	public boolean isFull() {
		return num >= capacity;
	}
	
	//--dump--//
	public void dump () {
		if (num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			for (int i = 0; i< num ; i++) {
				System.out.print(que[i]+ " | " );				
			}
			System.out.println();
		}
	}
	
	
}
