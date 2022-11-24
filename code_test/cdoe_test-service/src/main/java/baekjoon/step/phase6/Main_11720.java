package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        char[] chars = new char[a];

        String test = sc.nextLine();

        if(chars.length == test.length()){
            char[] b = test.toCharArray();
            int result = 0;
            for(char param : b){
                int value = Integer.parseInt(String.valueOf(param));
                result+=value;
            }
            System.out.println(result);
        }
    }
}
