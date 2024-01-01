package chapter02;

public class PrimeNumber2 {

	public static void main(String[] args) {
		int counter = 0 ;				// 나눗셈의 횟수
		int ptr = 0 ; 					// 찾은 소수의 개수 
		int[] prime = new int[500]; 	// 소수를 저장하는 배열 //실제론 1000이하의 소수는 169개가 나오지만 널널하게 잡아둔다.
		
		prime[ptr++] = 2 ; //2는 소수중 유일한 짝수이므로 첫번째로 기재.
		
		for (int n = 3 ; n <= 1000 ; n +=2 ) {
			int i ;
			for (i = 1 ; i < ptr ; i++) {
				counter++;
				if(n % prime[i] == 0)
					break; //소수로 나누어 떨어질떄 합성수이므로 break;
			}
			if (ptr == i )
				prime[ptr++] = n ; // ptr == i 인 경우 소수로 저장.
		}
		
		for (int i = 0 ; i < ptr ; i++) {
			System.out.println(prime[i]);//소수 출력
		}
		
		System.out.println("나눗셈을 수행한 횟수: " + counter);
	}

}
//PrimeNumber1보다 횟수가 확실히 줄은 것을 확인할 수 있다.//14622