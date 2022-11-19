package org.backjune.question.example;

import java.util.Scanner;

public class Main_4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++){
            int a = sc.nextInt();
            int[] arraySize = new int[a];
            double sum = 0;

            for(int j=0; j<a; j++){
                int subject = sc.nextInt();
                arraySize[j] = subject;
                sum = sum + subject;

            }

            double average = sum/a;
            double studentCount = 0;

            for(int j=0; j<a; j++){
                if(arraySize[j] > average){
                    studentCount++;
                }
            }

            System.out.printf("%.3f%%\n", studentCount/a*100);

        }

    }
}
