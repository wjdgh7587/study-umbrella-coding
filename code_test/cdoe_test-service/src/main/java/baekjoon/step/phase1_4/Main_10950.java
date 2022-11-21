package baekjoon.step.phase1_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String testCaseInputNumber = sc.nextLine();

        List<String> resultArray = new ArrayList<>();

        int figureLoop = Integer.parseInt(testCaseInputNumber);
        while( figureLoop > 0){

            String testCase = sc.nextLine();

            String[] diceArray = testCase.split(" ");
            int result = Integer.parseInt(diceArray[0]) + Integer.parseInt(diceArray[1]);
            resultArray.add(String.valueOf(result));

            figureLoop--;
        }

        // Result
        for(int i=0; i<resultArray.size(); i++){
            System.out.println(resultArray.get(i).toString());
        }
    }
}
