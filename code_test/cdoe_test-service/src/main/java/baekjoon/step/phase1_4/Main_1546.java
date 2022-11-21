package baekjoon.step.phase1_4;

import java.util.*;

public class Main_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subjectCount = Integer.parseInt(sc.nextLine());

        List<Double> resultArray = new ArrayList<>();

        String[] subjectArray = sc.nextLine().split(" ");

        int maxSubjectScore = Integer.parseInt(Arrays.stream(subjectArray)
                .max(Comparator.comparing(value -> Integer.parseInt(value)))
                .orElseThrow(NoSuchElementException::new));

        //System.out.println("최대값 : "+maxSubjectScore);

        for(String a : subjectArray){
            resultArray.add(calNewScore(Integer.parseInt(a), maxSubjectScore));
        }

        Double c = 0.0;
        for(Double a : resultArray){
            c = c + a;
        }
        //System.out.println("새로운 과목들의 총합 : "+c);
        System.out.println(c/resultArray.size());

    }

    public static Double calNewScore(int subjectScore, int maxScore){

        Double a = Double.valueOf(subjectScore)/Double.valueOf(maxScore);
        Double result = a*100;

        return result;
    }
}
