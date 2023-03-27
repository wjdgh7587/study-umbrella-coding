package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_1157_other {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alpha = new int[26];

        String input = sc.nextLine().toUpperCase();

        for(int i=0; i<input.length(); i++){
            int num = input.charAt(i)-65;
            alpha[num]++;
        }

        int max=-1;
        char result = '?';

        for(int i=0; i<alpha.length; i++){
            if(alpha[i] > max){
                max = alpha[i];
                result = (char) (i+65);
            }else if(alpha[i] == max){
                result = '?';
            }
        }
        System.out.println(result);

    }
}
