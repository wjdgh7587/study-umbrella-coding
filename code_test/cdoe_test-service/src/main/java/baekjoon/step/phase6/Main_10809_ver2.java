package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_10809_ver2 {
    public static void main(String[] args) {

        // char를 아스키 코드로 가게 되면 순차적으로 진행이 가능
        // 따라서 알파벳으로 처리 안해도 해결 가능
        // 너무 어렵게 생각함

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(char i = 'a'; i<= 'z'; i++){
            System.out.print(s.indexOf(i)+" ");
        }
    }
}
