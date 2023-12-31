package chapter01;

//이중 루프 구구단 곱셈표를 출력
public class Multi99Table {
  public static void main(String[] args) {
    System.out.println("--------- 구구단 곱셈표 ---------");

    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.printf("%3d", i * j);// %3d : 3칸안에 작성 ex) 2를 출력하면 vv2 로 출력됨.
      }
      System.out.println();// i 단 출력후 줄바꿈
    }
  }

}
