package chapter01;

import java.util.Scanner;

// 두 변수 a, b에 정술르 입력하고 b-a 를 출력하세요.
//b 가 a 보다 작으면 a보다 큰 값을 입력하라고 Msg
public class Q09BminusA {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("a 값: ");
    int a = sc.nextInt();
    int b = 0;

    do {
      System.out.print("b 값: ");
      b = sc.nextInt();
      if (a > b) {
        System.out.println("a 보다 큰 값을 입력하세요!");
      }
      // 🤔 이렇게도 사용가능. while문을 써도됨...
      // if (b > a) break;

      // System.out.println("a보다 큰 값을 입력하세요!");
    } while (a > b);

    System.out.println(" b - a 는 " + (b - a) + "입니다.");

    sc.close();
  }

}
