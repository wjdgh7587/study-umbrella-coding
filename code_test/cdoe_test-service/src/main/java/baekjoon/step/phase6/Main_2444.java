package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_2444 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){

            int starCnt = (2*i)-1;
            String star = "*";

            // Repeat String Method
            String result = star.repeat(starCnt);
            System.out.println(result);

        }

    }
}
