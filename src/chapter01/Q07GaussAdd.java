package chapter01;

import java.util.Scanner;

//1 ~10 까지의 합은 (1+10)*5 와 같이 구할 수 있습니다.
//이를 가우스의 덧셈 이라고 하는데 이 방법을 이용하여 1부터 n까지의 정수 합을 구하는 프로그램을 작성하세요.
public class Q07GaussAdd {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("가우스의 덧셈으로 계산합니다. 정수를 입력하세요: ");
    int n = scanner.nextInt();

    int sum = 0;

    if (n % 2 == 0) {// n이 반으로 나누어 떨어지면
      sum = (n + 1) * (n / 2);
    } else {
      int midNum = (n + 1) / 2;
      sum = (n + 1) * (n / 2) + midNum;
    }
    // 정답: int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0); // 총합
    System.out.println("덧셈의 합은 " + sum + "입니다.");

    scanner.close();
  }

}