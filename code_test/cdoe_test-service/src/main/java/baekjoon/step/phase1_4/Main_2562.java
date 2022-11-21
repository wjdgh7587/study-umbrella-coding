package baekjoon.step.phase1_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> numberArray = new ArrayList<>();

        for(int i=0; i<9; i++){
            Integer parseInt = Integer.parseInt(br.readLine());
            numberArray.add(parseInt);
        }

        int maxValue = 1;
        int count = 0;

        for(int j=0; j<numberArray.size(); j++){

            if(maxValue < numberArray.get(j)){
                maxValue = numberArray.get(j);
                count = j+1;
            }

        }

        bw.write(maxValue+"\n"+count);

        bw.flush();
        bw.close();
        br.close();
    }
}
