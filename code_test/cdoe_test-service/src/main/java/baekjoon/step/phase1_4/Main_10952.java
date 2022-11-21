package baekjoon.step.phase1_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> resultArray = new ArrayList<>();

        while(true){
            String[] sep = (br.readLine()).split(" ");

            int numberA = Integer.parseInt(sep[0]);
            int numberB = Integer.parseInt(sep[1]);

            int result = numberA + numberB;

            if(result == 0){
                break;
            }

            resultArray.add(String.valueOf(result));
        }

        for(String s : resultArray){
            System.out.println(s);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
