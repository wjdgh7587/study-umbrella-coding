package org.backjune.question.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String diceNumber = sc.nextLine();

        String[] diceArray = diceNumber.split(" ");

        int result = 0;

        // dice 넘버가 모두 다른 경우
        if(!diceArray[0].equals(diceArray[1])
                && !diceArray[1].equals(diceArray[2])
                && !diceArray[0].equals(diceArray[2])){
            // stream 을 활용하여 배열에서 가장 큰 값을 찾기
            int maxValue = Integer.parseInt(Arrays.stream(diceArray)
                    .max(Comparator.comparing(value -> value))
                    .orElseThrow(NoSuchElementException::new));

            result = maxValue*100;
        }

        // dice 넘버가 2개 같을 경우
        if(diceArray[0].equals(diceArray[1])){
            result = (Integer.parseInt(diceArray[0])*100) + 1000;
        }
        if(diceArray[0].equals(diceArray[2])){
            result = (Integer.parseInt(diceArray[0])*100) + 1000;
        }
        if(diceArray[1].equals(diceArray[2])){
            result = (Integer.parseInt(diceArray[1])*100) + 1000;
        }

        // dice 넘버가 3개 같을 경우
        if(diceArray[0].equals(diceArray[1])
                && diceArray[0].equals(diceArray[2])
                && diceArray[1].equals(diceArray[2])
                ) {
            result = (Integer.parseInt(diceArray[0])*1000) + 10000;
        }

        System.out.println(result);
    }
}
