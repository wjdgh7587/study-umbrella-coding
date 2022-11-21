package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] a = (sc.nextLine()).split(" ");

        int countNumber = Integer.parseInt(a[0]);
        int baseNumber = Integer.parseInt(a[1]);

        String[] arrayNumber = (sc.nextLine()).split(" ");

        // 실제 기준으로 삼은 카운트 넘버와 배열 사이즈 일치 여부 판별
        if(arrayNumber.length == countNumber){
           for(String s : arrayNumber){
               if(Integer.parseInt(s) < baseNumber){
                   System.out.print(s+" ");
               }
           }
        }else{
            System.out.println("Out of range");
        }
    }
}
