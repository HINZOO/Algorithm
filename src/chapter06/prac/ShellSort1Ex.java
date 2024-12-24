package chapter06.prac;

import java.util.Scanner;

public class ShellSort1Ex {

    static int shellSort(int[] a, int n) {
        int count = 0 ; //이동횟수
        for (int h = n / 2; h > 0; h /= 2) { //h/=2 는 h= h/2 임 //증분값 설정
            for (int i = h; i < n; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && a[j] > temp; j = j - h) {
                    a[j + h] = a[j]; //두값을 비교했을때 앞의 번의 값이 작으면 swap
                    count++;
                }
                a[j + h] = temp;
                count++;
            }
        }
         return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬 ver.1");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        int count = shellSort(x, nx);
        System.out.println("오름차 순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]= " + x[i]);
        }
        System.out.println("요소의 이동 회수는 " + count + "회입니다.");
        sc.close();
    }
}
