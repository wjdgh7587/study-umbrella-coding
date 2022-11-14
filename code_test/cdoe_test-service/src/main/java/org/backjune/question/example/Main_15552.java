package org.backjune.question.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15552 {
    public static void main(String[] args) throws IOException {

        // TODO : BufferReader 와 Scanner 로 동시에 처리해봐서, 빌드 속도 차이 실험해보기

        // case 1 Scanner
//        Scanner sc = new Scanner(System.in);
//
//        int numberCount = Integer.parseInt(sc.nextLine());
//        List<String> resultArray = new ArrayList<>();
//
//        while(numberCount > 0){
//            String inputNumber = sc.nextLine();
//            String[] inputNumberSep = inputNumber.split(" ");
//
//            int result = Integer.parseInt(inputNumberSep[0]) + Integer.parseInt(inputNumberSep[1]);
//            resultArray.add(String.valueOf(result));
//            numberCount--;
//        }
//
//        // Result for 문
//        for(String value : resultArray){
//            System.out.println(value);
//        }

        // case 2 BufferReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberCount = Integer.parseInt(br.readLine());
        List<String> resultArray = new ArrayList<>();

        while(numberCount > 0){
            String inputNumber = br.readLine();
            String[] inputNumberSep = inputNumber.split(" ");
            int A = Integer.parseInt(inputNumberSep[0]);
            int B = Integer.parseInt(inputNumberSep[1]);

            bw.write(A+B+"\n");
            numberCount--;
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
