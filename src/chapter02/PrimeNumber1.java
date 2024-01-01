package chapter02;

//1,000 이하의 소수를 나열 (버전1)

public class PrimeNumber1 {
	public static void main(String[] args) {
		int counter = 0 ;
		
		for(int n = 2 ; n <= 1000 ; n++) {
			int i;
			for(i = 2; i < n ; i ++) {
				counter++;
				if( n % i == 0) // 2부터 n까지의 숫자가 나누어 떨어질때
					break;	//반복문을 빠져나옴
			}
			if ( n == i ) { //소수인경우 5 == 5 의 형태로 같음 소수가 아닌경우 두수는 같지않음 예를들어 6의 경우  6%2 ===0 이 되면서 i=2, n=6이므로 같지않음.
				System.out.println(n); // 소수만 출력
			}
		}
		
		System.out.println("나눗셈을 수행한 횟수: " + counter );
		//현재 이 로직은  n 이 소수인 경우 n과 같은값 (for문이 끝까지 실행)
		// n이 합성수인 경우 n보다 작은값 (for문이 중단됨) 을 이용하여 소수를 출력한다.
		// 하지만 이는 비효율적이다.
		//예를들면  n이 2또는 3으로 나누어떨어지지 않으면 2*2 인 4  또는 2*3인 6으로도 나누어 떨어지지않으므로 
		//불필요한 나눗셈을 더 하는 꼴이 되기 때문.
		//따라서 다음과 같은 조건을 만족하는지 조사한다 
		// => 2 부터 n-1 까지의 어떤 소수로도 나누어 떨어지지 않습니다.
		// 예를들어 7이 소수인지는 2, 3, 5인 7보다 작은 소수들로 나누어 떨어지는지 확인하면 된다.
		
		
	}
}
