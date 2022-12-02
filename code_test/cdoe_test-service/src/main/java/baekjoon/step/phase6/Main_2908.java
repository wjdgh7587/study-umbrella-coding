package baekjoon.step.phase6;

import java.util.*;

public class Main_2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        List<Integer> resultArray = new ArrayList<>();
        for(int i=0; i< input.length; i++){
            String a = input[i];
            String[] b = new String[a.length()];
            int index=0;
            for(int j=b.length-1; j>=0; j--){
                b[j] = String.valueOf(a.charAt(index));
                index++;
            }

            String finalResult = null;
            for(int k=0; k<b.length; k++){
                if(finalResult == null){
                    finalResult = b[k];
                }else{
                    finalResult = finalResult + b[k];
                }
            }
            resultArray.add(Integer.valueOf(finalResult));
        }

        // 값 비교
        int result = resultArray.stream().max(Comparator.comparing(value->value))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(result);

    }
}
