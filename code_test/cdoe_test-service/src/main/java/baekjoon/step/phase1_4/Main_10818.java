package baekjoon.step.phase1_4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Main_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int countNumber = Integer.parseInt(br.readLine());
        String[] arrayNumber = (br.readLine()).split(" ");

        if(arrayNumber.length == countNumber){
//            int maxValue = Arrays.stream(arrayNumber).mapToInt(v-> Integer.parseInt(v))
//                    .max()
//                    .orElseThrow(NoSuchElementException::new);
            String maxValue = Arrays.stream(arrayNumber)
                            .max(Comparator.comparing(v->Integer.parseInt(v)))
                            .orElseThrow(NoSuchElementException::new);


            String minValue = Arrays.stream(arrayNumber)
                            .min(Comparator.comparing(v->Integer.parseInt(v)))
                            .orElseThrow(NoSuchElementException::new);

            bw.write(minValue+" "+maxValue);
        }else{
            bw.write("Out of range");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
