package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_11382 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long result = 0;

        String[] values = (sc.nextLine()).split(" ");

        for(String a : values){
            result += Long.parseLong(a);
        }

        // result
        System.out.println(result);

    }
}
