package chapter04;
//int형 고정길이 Queue
public class IntQueue {
	private int[] que;		//큐용배열
	private int capacity;	//큐의 용량
	private int front;		//맨 앞의 요소 커서
	private int rear;		//멘 뒤의 요소 커서
	private int num;		//현재 데이터 개수
	
	//실행시 예외 : 큐가 비어있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {};
	}
	//실행시 예외 : 큐가 가득참
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {};
	}
	
	//생성자
	public IntQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int [capacity]; 	//큐 본체용 배열 생성
		}catch(OutOfMemoryError e) {	//생성자 생성 불가 시 예외 처리 
			capacity = 0;
		}
	}
	
	//-- enqueue --//
	public int enque(int x) throws OverflowIntQueueException{
		if (num >= capacity) {
			throw new OverflowIntQueueException();
		}
		que[rear++] = x;
		num++;
		if(rear == capacity) {
			rear= 0;
		}
		return x;
	}
	
	//-- dequeue --//
	public int deque() throws EmptyIntQueueException{
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		int x = que[front++];
		num--;
		
		if(front == capacity) {
			front = 0;
		}
		return x;
	}
	
	//-- peek (front 데이터를 들여다 봄 --//
	public int peek() throws EmptyIntQueueException{
		if(num < 0) throw new EmptyIntQueueException();
		return que[front];
	}
	
	//-- clear (큐를 비움)  --//
	public void clear() {
		num = front = rear = 0;
	}
	
	//-- indexOf (큐에서 x를 검색하여 인덱스 찾기; 없으면 -1 반환) --//
	public int indexOf (int x) {
		for (int i = 0 ; i < num ; i++) {
			int idx = (i + front ) % capacity;
			if (que[idx] == x) return idx;		
		}
		return -1;
	}
	
	//-- getCapacity --//
	public int getCapacity() {
		return capacity;
	}
	
	//-- size --//
	public int size() {
		return num;
	}
	
	//-- isEmpty --//
	public boolean isEmpty(){
		return num <= 0;
	}
	//-- isFull --//
	public boolean isFull() {
		return num >= capacity;
	}
	//-- dump --//
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		}else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i+front)%capacity] + " ");
			}
			System.out.println();
		}
	}
	
	//-- Q05. search(int x ) : 임의의 데이터를 검색하는 메서드 search --//
	public int search (int x) {
		for (int i = 0 ; i < num ; i++) {
			int idx = (i + front ) % capacity;
			if (que[idx] == x) return (i + 1)
					;		
		}
		return 0;
	}
}
