package chapter01;

import java.util.Scanner;

// 두 자리의 양수 (10~99) 를 입력
public class TwoDigits {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int no;

    System.out.println("2 자리의 양수를 입력하세요.");

    do {
      System.out.print("no 값: ");
      no = stdIn.nextInt();
    } while (no < 10 || no > 99);

    System.out.println("변수 no값은 " + no + "이 되었습니다.");
    stdIn.close();
  }
}
// 🍊 단축 평가 (short circuit evaluation)
// A&&B 일 때 A가 false 이면 B를 확인하지 않고 False를 반환
// A||B 일 때 A가 true 이면 B를 확인하지 않고 True를 반환