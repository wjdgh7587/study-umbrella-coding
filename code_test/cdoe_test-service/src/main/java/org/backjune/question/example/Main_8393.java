package org.backjune.question.example;

import java.util.Scanner;

public class Main_8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        int result=0;
        for(int i=1; i<=inputNumber; i++){
            result = result + i;
        }

        System.out.println(result);

    }
}
