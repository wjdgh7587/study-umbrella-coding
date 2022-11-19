package org.backjune.question.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 42;
        List<Integer> remainderList = new ArrayList<>();

        for(int i=0; i<10; i++){
            int b = sc.nextInt();
            int remainder = b%a;
            if(!remainderList.contains(remainder)){
                remainderList.add(remainder);
            }
        }

        System.out.println(remainderList.size());

    }
}
