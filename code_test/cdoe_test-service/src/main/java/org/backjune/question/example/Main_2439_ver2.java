package org.backjune.question.example;

import java.util.Scanner;

public class Main_2439_ver2 {
    public static void main(String[] args) {
        // TODO: java11 repeat 함수를 사용하였지만, 이중 for문으로도 해결 가능함으로 이중 for 문으로 해결되는 방안을 새롭게 작성하기.
        Scanner sc = new Scanner(System.in);

        int testCaseNumber = Integer.parseInt(sc.nextLine());
        int testOtherNumber = testCaseNumber-1;


        for(int i=1; i<=testCaseNumber; i++){
            for(int j=testOtherNumber; j>0; j--){
                System.out.print(" ");
            }
            for(int x=i; x>0; x--){
                System.out.print("*");
            }
            System.out.println();
            testOtherNumber--;
        }
    }
}
