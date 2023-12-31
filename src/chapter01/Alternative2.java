package chapter01;

import java.util.Scanner;

public class Alternative2 {
  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);
    int n;

    System.out.println(" + 와 - 를 번갈아 n개 출력합니다.");
    System.out.print("n의 값 : ");
    n = stdIn.nextInt();

    for (int i = 0; i < n / 2; i++)// Alternative1과는 달리 for문의 루프를 절반만 돌아도 되며
      // for (int i =1; i<=n/2 ; i++) //이렇게 수정해줘도 된다.
      System.out.print("+-");

    if (n % 2 != 0)// if문판단은 한번 만 진행한다.
      System.out.print("+");

    // n/2번 동안 +-를 반복하고 n이 홀수인경우 +를 마지막에 한번 더 붙여준다.

    stdIn.close();
  }
}
