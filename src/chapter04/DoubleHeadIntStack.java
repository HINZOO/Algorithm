package chapter04;

//예제 3번을 위한
//머리가 둘인 int형 고정 길이 스택
public class DoubleHeadIntStack {
	private int[] stack;		//스택본체
	private int capacity; 		//스택용량
	private int ptrA;			//A포인터
	private int ptrB;			//B포인터
	
	
	public enum AorB {StackA, StackB};
	
	//실행 예외 : 스택이 비어있음
	public class EmptyDoubleHeadIntStackException extends RuntimeException{
		public EmptyDoubleHeadIntStackException() {}
	}
	
	//실행 예외 : 스택이 가득 참
	public class OverflowDoubleHeadIntStackException extends RuntimeException{
		public OverflowDoubleHeadIntStackException() {}
	}
	
	
	//생성자
	public DoubleHeadIntStack(int maxlen) {
		ptrA = 0 ;
		ptrB = maxlen -1;
		capacity = maxlen;
		
		try {
			stack = new int[capacity]; 		//스택 본체용 배열 생성
		}catch (OutOfMemoryError e) {		//생성할수 없을 때 
			capacity = 0;
		}
	}
	
	//Push
	public int push(AorB sw, int x) throws OverflowDoubleHeadIntStackException{
		if(ptrA >= ptrB + 1) {
			throw new OverflowDoubleHeadIntStackException();
		}
		switch(sw) {
		case StackA : stack[ptrA++] = x ; break;
		case StackB : stack[ptrB--] = x ; break;
		}
		return x;
	}
	
	//Pop
	public int pop(AorB sw) throws EmptyDoubleHeadIntStackException{
		int x = 0;
		switch(sw) {
		case StackA:
			if(ptrA <= 0) throw new EmptyDoubleHeadIntStackException();
			x = stack[--ptrA];
			break;
		case StackB:
			if(ptrB >= capacity -1) throw new EmptyDoubleHeadIntStackException();
			x = stack[++ptrB];
			break;
		}
		return x;
	} 
	
	//Peek
	public int peek(AorB sw) throws EmptyDoubleHeadIntStackException{
		int x = 0;
		switch(sw) {
		case StackA:
			if(ptrA <= 0) throw new EmptyDoubleHeadIntStackException();
			x = stack[ptrA-1];
			break;
		case StackB:
			if(ptrB >= capacity -1) throw new EmptyDoubleHeadIntStackException();
			x = stack[ptrB+1];
			break;
		}
		return x;		
	}
	
	
	//indexOf //발견하지 못하면 -1 반환
	public int indexOf(AorB sw, int x) {
		switch(sw) {
		case StackA :
			for(int i = ptrA -1; i>=0 ; i--) {
				if(stack[i] == x) return i;
			}
			break;
		case StackB :
			for(int i = ptrB +1; i<capacity ; i++) {
				if(stack[i] == x) return i;
			}
			break;
		}
		return -1 ; //검색실패
	}
	
	// Clear
	public void clear (AorB sw) {
		switch (sw) {
			case StackA : ptrA = 0 ; break;
			case StackB : ptrB =capacity -1; break;
		}
	}
	
	// getCapacity : 스택의 용량을 반환 (A와 B의 합계)
	public int getCapacity(){
		return capacity;
	}
	
	// Size : 쌓여있는 데이터 수 반환
	public int size(AorB sw) {
		switch (sw) {
		case StackA : return ptrA ;
		case StackB : return capacity - ptrB -1 ; 
		}
		return 0; //스택이 없는 경우.
	}
	
	//isEmpty 
	public boolean isEmpty(AorB sw) {
		switch (sw) {
		 case StackA: return ptrA <= 0;
		 case StackB: return ptrB >= capacity - 1;
		}
		return true;
	}
	
	//isFull
	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}
	
	//dump : 스택의 모든 데이터를 바닥 - 꼭대기 순서로 출력 
	public void dump(AorB sw) {
		switch(sw) {
		case StackA :
			if(ptrA <= 0) {
				System.out.println("스택이 비어 있습니다.");
			}else {
				for(int i = 0 ; i < ptrA ; i++) {
					System.out.print(stack[i]+ " ");
					System.out.println();
				}
			}
			break;
		case StackB :
			if(ptrB >= capacity -1) {
				System.out.println("스택이 비어 있습니다.");
			}else {
				for(int i = capacity - 1 ; i > ptrB ; i--) {
					System.out.print(stack[i]+ " ");
					System.out.println();
				}
			}
			break;
		}
	}
}
