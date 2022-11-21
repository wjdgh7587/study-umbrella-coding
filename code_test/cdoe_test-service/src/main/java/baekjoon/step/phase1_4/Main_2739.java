package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int guguMainNumber = sc.nextInt();

        for(int i=1; i <10; i++){
            int guguResult = i*guguMainNumber;
            System.out.println(guguMainNumber+" * "+i+" = "+guguResult);
        }

    }
}
