package chapter06;

import java.util.Scanner;

public class InsertionSort {
    static  void insertionSort(int[]a, int n){
        int sortCount = 0;
        for (int i = 1; i < n; i++){
            int j;
            int temp = a[i];// i번째 값을  보관 *
            for (j = i ; j > 0 && a[j-1]>temp ; j--){//i번째 이후 값들을
                a[j] = a[j-1]; //앞의것과 비교하여 *
                // a[j-1]>temp 값을 발견하면 멈춤*
            }
            a[j] = temp; //j번째 값을 그 자리에 삽입.*(*과정된걸 보면 swap 된것으로 생각하면 됨)

        sortCount++;
        }
        System.out.println("몇 회전 했는지? : "+sortCount);

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int [] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x["+ i +"] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x,nx);

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x["+ i +"] = "+x[i]);
        }
    }
}

/*
*  8, 5, 6, 2, 4
* 1회전 : 5와 8을 비교
* -------------------> 5, 8, 6, 2, 4
* 2회전 : 6을 정렬된 5,8 과 비교 6이 8자리에 들어가고 나머지는 1칸씩 이동.
* -------------------> 5, 6, 8, 2, 4
* 3회전 : 2을 정렬된 5,6,8 과 비교, 5를 비교하는 과정에서 이미 앞으로 가야됨을 알기에 
*        2는 맨앞으로 오며 뒤는 비교하지않고 나머지는 1칸씩 이동한다.
* -------------------> 2, 5, 6, 8, 4
* 4회전 : 4를 정렬된 2,5,6,8 과 비교 4를 5의 위치에 넣고 나머지는 1칸씩 이동
* -------------------> 2, 4, 5, 6, 8
* */
