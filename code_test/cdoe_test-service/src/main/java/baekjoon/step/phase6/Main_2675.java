package baekjoon.step.phase6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2675 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // test case 입력
        int a = Integer.parseInt(sc.nextLine());
        List<String[]> array = new ArrayList<>();

        for(int i=0; i<a; i++){
            String[] n = sc.nextLine().split(" ");
            array.add(n);
        }
        // test case
        for(int i=0; i<array.size(); i++){
            String aa = array.get(i)[0];
            String bb = array.get(i)[1];

            int check = bb.length();
            for(int k=0; k<check; k++){
                String aaa = String.valueOf(bb.charAt(k)).repeat(Integer.parseInt(aa));
                System.out.print(aaa);
            }
            System.out.print("\n");

        }
    }
}
