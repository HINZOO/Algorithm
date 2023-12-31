package chapter01;

import java.util.Scanner;

class Max3 {

  public static void main(String[] args) {

    // 🍊순차(sequential) 구조 : 여러문장(프로세스)이 순차적으로 실행되는 구조.
    Scanner stdIn = new Scanner(System.in);

    System.out.println("세 정수의 최댓값을 구합니다.");
    System.out.print("a의 값 : ");
    int a = stdIn.nextInt();
    System.out.print("b의 값 : ");
    int b = stdIn.nextInt();
    System.out.print("c의 값 : ");
    int c = stdIn.nextInt();

    int max = a;
    // 🍊선택(select) 구조 : ()안의 식을 평가한 결과에 따라 프로그램의 실행 흐름을 변경하는 if 문
    if (b > max)
      max = b;
    if (c > max)
      max = c;
    System.out.println("최댓값은 " + max + "입니다.");
    stdIn.close();
  }
}