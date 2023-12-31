package chapter01;

import java.util.Scanner;

public class PrintStars2 {
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

    // n/w 번 만큼 반복한뒤
    for (int i = 0; i < n / w; i++)
      System.out.println("*".repeat(w)); // ⚾

    // 만약 n이 w로 안나눠 떨어지는 경우
    int rest = n % w;// 나머지값만큼이 추가되야 하기 때문에
    if (rest != 0)
      System.out.println("*".repeat(rest));// 🍊// 해당값을 반복하여 마지막줄에 추가해준다.

    // EX) N = 14 W= 5 라면
    // * * * * *⚾
    // * * * * *⚾
    // * * * * 🍊

    stdIn.close();
  }
}
