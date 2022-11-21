package baekjoon.step.phase1_4;


import java.util.Scanner;

public class Main_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCaseNumber = Integer.parseInt(sc.nextLine());
        String value = "*";
        int testOtherNumber = 1;
        for(int i=testCaseNumber-1; i>=0; i--){

            String emptySpace = " ";
            String result = emptySpace.repeat(i)+value.repeat(testOtherNumber);
            System.out.println(result);
            testOtherNumber++;
        }
    }
}
