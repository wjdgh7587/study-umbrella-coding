package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;
        for(int i=0; i<input.length();i++) {
            char temp = input.charAt(i);
            if(temp == 'c'){
                if(i < input.length() - 1){
                    if(input.charAt(i+1) == '-'){
                        i++;
                    }else if(input.charAt(i+1) == '=') {
                        i++;
                    }
                }
            }
            else if(temp == 'd'){
                if(i < input.length() - 1 ){
                    if(input.charAt(i+1) == '-'){
                        i++;
                    }
                    else if(input.charAt(i+1) == 'z'){
                        if(i < input.length() -2){
                            if(input.charAt(i+2) == '=');
                            i = i + 2;
                        }
                    }
                }
            }
            else if(temp == 'l'){
                if(i < input.length() - 1 ){
                    if(input.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            }
            else if(temp == 'n'){
                if(i < input.length() - 1 ){
                    if(input.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            }

            else if(temp == 's'){
                if(i < input.length() - 1 ){
                    if(input.charAt(i+1) == '='){
                        i++;
                    }
                }
            }
            else if(temp == 'z'){
                if(i < input.length() - 1 ){
                    if(input.charAt(i+1) == '='){
                        i++;
                    }
                }
            }

            count++;
        }
        System.out.println(count);
    }
}
