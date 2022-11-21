package baekjoon.step.phase1_4;

import java.io.*;

public class Main_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNumber = Integer.parseInt(br.readLine());

        for(int i=1; i<= testCaseNumber; i++){
            String inputNumber = br.readLine();
            String[] inputNumberSep = inputNumber.split(" ");
            int A = Integer.parseInt(inputNumberSep[0]);
            int B = Integer.parseInt(inputNumberSep[1]);
            bw.write("Case #"+i+": "+(A+B)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
