package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int result = 0;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            result = result + dialAlpha(ch);
        }

        System.out.println(result);
    }

    // 전화번호 입력 분류
    public static int dialAlpha(char param){

        String parseParam = String.valueOf(param).toUpperCase();
        int result = 0;

        if(parseParam.equals("A") || parseParam.equals("B") || parseParam.equals("C")){
            //2
            result = 3;
        }else if(parseParam.equals("D") || parseParam.equals("E") || parseParam.equals("F")){
            //3
            result = 4;
        }else if(parseParam.equals("G") || parseParam.equals("H") || parseParam.equals("I")){
            //4
            result = 5;
        }else if(parseParam.equals("J") || parseParam.equals("K") || parseParam.equals("L")){
            //5
            result = 6;
        }else if(parseParam.equals("M") || parseParam.equals("N") || parseParam.equals("O")){
            //6
            result = 7;
        }else if(parseParam.equals("P") || parseParam.equals("Q") || parseParam.equals("R") || parseParam.equals("S")){
            //7
            result = 8;
        }else if(parseParam.equals("T") || parseParam.equals("U") || parseParam.equals("V")){
            //8
            result = 9;
        }else if(parseParam.equals("W") || parseParam.equals("X") || parseParam.equals("Y") || parseParam.equals("Z")){
            //9
            result = 10;
        }else{
            result = 0;
        }
        return result;
    }



}
