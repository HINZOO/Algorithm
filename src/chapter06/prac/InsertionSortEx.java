package chapter06.prac;

import java.util.Scanner;

public class InsertionSortEx {

    static void insertSort(int[] a, int n){
        for (int i = 1 ; i < n ; i++){
            for (int m = 0 ; m < n ; m++){
                System.out.printf("%3d ", a[m]);
            }
            System.out.println();

            int j;
            int temp = a[i];
            for (j = i ; j > 0 && a[j-1]>temp; j--){
                a[j] = a[j-1];
            }
            a[j] = temp;

            System.out.print(" ".repeat(4*j)); //4칸씩간격 유지
            System.out.print(i != j ? "^-" : "  ");
            System.out.print("-".repeat(4*(i-j)));
            System.out.println("+");
            System.out.printf("a[%d]의 %d를 a[%d]의 위치에 삽입하였습니다.\n\n",i,temp,j);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순선택 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        // 요소값 입력
        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        insertSort(x, nx);

        System.out.println("오름차 순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]= " + x[i]);
        }
        stdIn.close();
    }
}
