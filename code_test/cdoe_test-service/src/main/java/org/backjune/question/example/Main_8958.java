package org.backjune.question.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = Integer.parseInt(sc.nextLine());

        List<String> testArray = new ArrayList<>();

        for(int i=0; i<testCase; i++){
            String a = sc.nextLine();
            char[] chs = a.toCharArray();
            int figure = 0;
            int result = 0;
            for(int aa=0; aa<chs.length; aa++){
                if(String.valueOf(chs[aa]).equals("O")){
                    figure++;
                }else{
                    figure = 0;
                }
                result = result + figure;
            }
            testArray.add(String.valueOf(result));
        }

        for(String s : testArray){
            System.out.println(s);
        }
        sc.close();
    }
}
