package chapter02;

import java.util.Scanner;

public class Q08YMD {
	
	int y;
	int m;
	int d;
	
	//각 월의 일수 
	static int[][] mdays = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 평년
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 윤년
	};
	
	//윤년인지 확인 (윤년이면 1 평년이면 0 반환0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	//생성자
	public Q08YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	//n일 후의 날짜를 반환 //Q08YMD 타입을 반환하는 after함수
	Q08YMD after (int n) {
		Q08YMD temp = new Q08YMD(this.y,this.m, this.d);
		if(n<0) { //일수에 음수를 입력하면
			return before(-n);//양수값 n으로 바꾸어 전일로 출력
		}
		temp.d += n; //n일을 더함
		while( temp.d > mdays[isLeap(temp.y)][temp.m-1]) {//더한 일자가 현재년도 월의  일수값 보다 크면 실행
			temp.d -= mdays[isLeap(temp.y)][temp.m-1]; // 일수 - 월수를 빼서 다음달로 넘어간 일수를 계산한다.
			if(++temp.m > 12) { //temp.m이 12일경우 ++temp.m이 되어  13>12 가 되면 
				temp.y++; //년도를 증가시키고
				temp.m = 1; // 월을 1로 변경
			}			
		}
		return temp;
	}
	
	//n일 전 날짜를 반환 
	 Q08YMD before(int n) {
		Q08YMD temp = new Q08YMD(this.y,this.m, this.d);
		if( n < 0) {//일수에 음수를 입력하면 
			return after(-n);//양수로 지난날짜 출력
		}
		temp.d -= n;
		while( temp.d < 1) {
			if(--temp.m < 1) { //temp.m이 1일때 0< 1 이 되면 // 조건이 안맞아도  -- temp.m을 거치므로 월이 감소.
				temp.y--;	//연도를 줄이고
				temp.m = 12; //월을 12월로 맞춘다
			}			
			temp.d += mdays[isLeap(temp.y)][temp.m-1]; // 음수가 된 일자에 해당 full일자를 더해 현재 날짜를 맞춤.
		}	
		return temp;
	}
	 
	 

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년 : ");  int y = stdIn.nextInt();
		System.out.print("월 : ");  int m = stdIn.nextInt();
		System.out.print("일 : ");  int d = stdIn.nextInt();
		Q08YMD date = new Q08YMD(y, m, d);

		System.out.print("며칠 전/후의 날짜를 구할까요? : ");
		int n = stdIn.nextInt();

		Q08YMD d1 = date.after(n);
		System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다.\n", n, d1.y, d1.m, d1.d);

		Q08YMD d2 = date.before(n);
		System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다.\n", n, d2.y, d2.m, d2.d);
		stdIn.close();
	}
	
}
