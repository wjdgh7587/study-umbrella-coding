package baekjoon.step.phase1_4;

import java.io.*;

public class Main_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 문자열을 토큰화 -> 문자열을 분리하여, 여러개의 토큰으로 분리
         *
         * value = "문자열"
         *
         * StringTokenizer st = new StringTokenizer(value);
         * StringTokenizer st = new StringTokenizer(value, 구분자);
         * StringTokenizer st = new StringTokenizer(value, 구분자, true/false);
         *  -> true/false 문자열에 토큰 input 여부
         */
        String firstValue = br.readLine();
        String value = firstValue;
        int count = 1;
        while(true){

            int A;
            int B;
            int parsingValue = Integer.parseInt(value);

            if(parsingValue < 10){
                A = 0;
                B = parsingValue;
            }else{
                A = Integer.parseInt(value.substring(0,1));
                B = Integer.parseInt(value.substring(1,2));
            }
            int result = A+B;

            if(String.valueOf(result).length() == 2){
                int C = Integer.parseInt(String.valueOf(result).substring(0,1));
                int D = Integer.parseInt(String.valueOf(result).substring(1,2));
                result = D;
            }

            if(B == 0){
                value = String.valueOf(result);
            }else{
                value = String.valueOf(B)+String.valueOf(result);
            }

            if(value.equals(firstValue)){
                System.out.println(count);
                break;
            }else{
                count ++;
            }

        }

    }
}
