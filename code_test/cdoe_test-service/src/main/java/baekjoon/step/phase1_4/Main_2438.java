package baekjoon.step.phase1_4;

import java.io.*;

public class Main_2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int countNumber = Integer.parseInt(br.readLine());
        String value = "*";
        for(int i=1; i<=countNumber; i++){
            bw.write(value.repeat(i)+"\n");
        }

        //repeat을 사용하지 않으려면 append 로 문자열을 더하는 방법으로 작성한다. 추가적으로 작성하는 방향

        bw.flush();
        br.close();
        bw.close();

    }
}
