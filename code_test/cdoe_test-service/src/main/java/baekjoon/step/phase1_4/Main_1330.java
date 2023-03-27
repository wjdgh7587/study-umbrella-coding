package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_1330 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] subjectArray = sc.nextLine().split(" ");

        int a = Integer.parseInt(subjectArray[0]);
        int b = Integer.parseInt(subjectArray[1]);

        if(a==b){
            System.out.println("==");
        }else if (a<b){
            System.out.println("<");
        }else if(a>b){
            System.out.println(">");
        }
    }
}
