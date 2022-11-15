package org.backjune.question.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String 을 token 화 하여 분류
        StringTokenizer stringTokenizer;

        String s;
        List<String> resultArray = new ArrayList<>();

        while((s = br.readLine()) != null
                && !s.isEmpty()){
            String[] sepNumber = (s).split(" ");

            int A = Integer.parseInt(sepNumber[0]);
            int B = Integer.parseInt(sepNumber[1]);

            int result = A+B;
            System.out.println(result);
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
