package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] test = input.split(" ");

        int count = 0;
        for(int i = 0; i<test.length; i++){
            if(test[i].equals("")){
                count--;
            }
            count++;
        }

        System.out.println(count);
    }
}
