package chapter01;

import java.util.Scanner;

public class Alternative1 {
  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);
    int n;

    System.out.println(" + 와 - 를 번갈아 n개 출력합니다.");
    System.out.print("n의 값 : ");
    n = stdIn.nextInt();

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0)
        System.out.print("+");// 짝수
      else
        System.out.print("-");// 홀수
    }
    stdIn.close();
  }
}

// 위의 코드는 두가지 문제점이 있다.
// 1. 반복할 때 마다 if문을 실행해야 함
// 2. 변경할 때 유연하게 대응하기 어렵다. 1부터 n까지로 고치게 된다면 고쳐야할 곳이 많다.
// for(int i = 1 ; i <= n ; i ++){
// if(i % 2 == 0)
// System.out.print("-");//짝수
// else
// System.out.print("+");//홀수
// }
