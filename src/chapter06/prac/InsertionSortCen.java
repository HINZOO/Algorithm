package chapter06.prac;

import java.util.Scanner;

//연습 6-8
//p.216 단순 삽입 정렬 (보초법: 배열의 맨앞 요소는 비어있음)
public class InsertionSortCen {

    static  void insertSort(int[] a, int n){
        for (int i = 2 ; i< n ; i++){ //여분 배열이 앞에 생겼으므로 1이 아닌 2부터 시작)
            int temp = a[0] = a[i];
            int j = i;
            for( ; a[j-1]> temp; j--){
                a[j] = a[j-1];
            }
            if(j>0){
                a[j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x= new int[nx + 1]; //여분으로 한개 더 생성

        for(int i = 1 ; i < nx ; i++){//x[1]부터 입력받음
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        insertSort(x,nx+1);
        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 1; i <= nx; i++) { //1부터 출력 0번은 보초의 역할
            System.out.println("x[" + i + "]＝" + x[i]);
        }
    }

}
