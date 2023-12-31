package chapter01;

import java.util.Scanner;

public class PrintStars1 {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n, w;

    System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");

    // 양수값 n만 입력하도록 설정
    do {
      System.out.print("n값: ");
      n = stdIn.nextInt();
    } while (n <= 0);

    // w 는 양수이며 n보다 작아야함 => 조건에 맞지 않는 경우 loop되도록 설정.
    do {
      System.out.print("w값: ");
      w = stdIn.nextInt();
    } while (w <= 0 || w > n);

    for (int i = 0; i < n; i++) {
      System.out.print("*");
      if (i % w == w - 1) // 나머지가 W-1이 될 때
        System.out.println();// 줄바꿈 진행
    }
    if (n % w != 0)
      System.out.println();// 만약 N % W 가 0이아니면 (나누어떨어지지않으면 한번더 칸을 띄워줌)
    // EX) N = 14 W= 5 라면
    // * * * * *
    // * * * * *
    // * * * * (이부분에서 줄바꿈이 이뤄지는것임!)

    stdIn.close();
  }
}
