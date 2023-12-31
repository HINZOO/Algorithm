package chapter01;
//3개의 정수값 가운데 최댓값을 구하여 출력

public class Max3Method {
  // a,b,c의 최댓값을 구하여 반환
  static int max3(int a, int b, int c) {
    int max = a;
    if (b > max)
      max = b;
    if (c > max)
      max = c;

    return max;
  }

  public static void main(String[] args) {
    System.out.println("max3(3,2,1) = " + max3(3, 2, 1));
  }
}
// 🍊 최댓값을 여러번 반복해서 구할때는 메서드로 처리하면 편하다.
// 🍊 매개변수(파라미터): 메서드를 정의할때 메서드에 전달되는 값을 저장하기 위해 변수를 선언하는데 이때의 변수를 말한다.
// 🔥 알고리즘 : 어떤 문제를 해결하기 위한 절차로, 명확하게 정의되고 순서가 있는 유한 개의 규칙으로 이루어진 집합.
