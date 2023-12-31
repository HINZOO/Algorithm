package chapter01;

//이중 루프 구구단 곱셈표를 출력
public class Q11Multi99Ex {
  public static void main(String[] args) {
    System.out.println("--------- 구구단 곱셈표 ---------");

    for (int i = 1; i <= 9; i++) {
      if (i == 1) {// 🤔 이부분이 for문밖으로 빠져서 다른 for문을 돌리는 것이 코드읽을때 좀 더 좋은 코드일것 같다.
        System.out.printf("%4s", "|");
        for (int j = 1; j <= 9; j++) {
          System.out.printf("%3d", i * j);
        }
        System.out.println();
        System.out.println("---+----------------------------");
      }
      System.out.printf("%3d|", i);
      for (int j = 1; j <= 9; j++) {

        System.out.printf("%3d", i * j);// %3d : 3칸안에 작성 ex) 2를 출력하면 vv2 로 출력됨.
      }
      System.out.println();// i 단 출력후 줄바꿈

    }
    // 🍊 정답
    // System.out.print(" |");
    // for (int i = 1;i <= 9; i++)
    // System.out.printf("%3d", i);
    // System.out.println("\n---+---------------------------");

    // for (int i = 1; i <= 9; i++) {
    // System.out.printf("%2d |", i);
    // for (int j = 1; j <= 9; j++)
    // System.out.printf("%3d", i * j);
    // System.out.println();
    // }

  }

}
