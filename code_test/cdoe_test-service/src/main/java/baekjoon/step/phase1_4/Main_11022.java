package baekjoon.step.phase1_4;

import java.io.*;

public class Main_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNumber = Integer.parseInt(br.readLine());

        for(int i=1; i<=testCaseNumber; i++){
            String inputNumbers = br.readLine();
            String[] seperatedNumberArray = inputNumbers.split(" ");

            int A = Integer.parseInt(seperatedNumberArray[0]);
            int B = Integer.parseInt(seperatedNumberArray[1]);

            bw.write("Case #"+i+": "+A+" + "+B+" = "+(A+B)+"\n");
            //Case #1: 1 + 1 = 2

        }

        bw.flush();
        br.close();
        bw.close();

    }
}
