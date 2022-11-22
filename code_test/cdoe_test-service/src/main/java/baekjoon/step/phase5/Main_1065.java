package baekjoon.step.phase5;

import java.util.Scanner;

public class Main_1065 {
    public static void main(String[] args) {

        /**
         * [등차수열]
         *  - 숫자들을 수열로 볼때 일정한 수로 유지되는 케이스 ex) 1 3 5 -> 2씩 유지
         *
         * [한수]
         *  - 숫자들을 수열로 볼때 일정한 수
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int hansuCnt = 0;
        for(int i=1; i<=n; i++){
            if(figureHansu(i)==true){
                hansuCnt++;
            }
        }
        System.out.println(hansuCnt);
    }

    public static boolean figureHansu(int param){
        // 숫자 자리수 판별
        char[] chars = String.valueOf(param).toCharArray();
        // 1부터 99 까지는 수열 일정하게 다 감소 및 증가하는 대상 한수 대상
        if(param < 100){
            return true;
        }
        // 나머지 대상들을 1항, 2항, 3항으로 구분하여 2항 - 1항 3항 -2 항으로 빼서 서로 같으면 등차, 아니면 한수로 판정하고 카운트
        else{
            int figureA = Integer.parseInt(String.valueOf(chars[2])) - Integer.parseInt(String.valueOf(chars[1]));
            int figureB = Integer.parseInt(String.valueOf(chars[1])) - Integer.parseInt(String.valueOf(chars[0]));

            if(figureA == figureB){
                return true;
            }else{
                return false;
            }
        }
    }
}
