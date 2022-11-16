package org.backjune.question.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrayCount = Integer.parseInt(sc.nextLine());

        String inputNumber = sc.nextLine();
        String targetNumber = sc.nextLine();

        String[] arrayTest = inputNumber.split(" ");

        if(arrayTest.length == arrayCount){
            int matchValue = Collections.frequency(List.of(arrayTest),targetNumber);
            // TODO: List.of 와 Collections.singleton 의 차이
            System.out.println(matchValue);
        }else{
            System.out.println("Out of range");
        }

    }
}
