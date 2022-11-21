package baekjoon.step.phase1_4;

import java.util.*;
import java.util.stream.Stream;

public class Main_5597 {
    public static void main(String[] args){

        //TODO 문제에 비해 코드 내용이 너무 무거움

        Scanner sc = new Scanner(System.in);

        List<String> memberAll = new ArrayList<>();
        List<String> targetAll = new ArrayList<>();

        // 총 학생 명단
        for(int i=1; i<=30; i++){
            memberAll.add(String.valueOf(i));
        }

        // 과제 제출 인원을 기준 명단
        for(int j=1; j<=28; j++){
            String target = sc.nextLine();
            targetAll.add(target);
        }

        memberAll.removeAll(targetAll);

        for(String s : memberAll){
            System.out.println(s);
        }

        /***
         * stream 을 사용하여 정렬 옵션까지 넣어서 출력하려고 하였지만, 오히려 문제가 발생하였다.
         */
//        // 스트림 활용하여, 정렬하여 다시 출력
//        Stream<String> sl = memberAll.stream();
//        // stream sorted() 는 기본적으로 오름차순 정렬이다. sorted 메소드에 Comparator.reverseOrder() 옵션 부여 하면 내림차순 정렬
//        sl.sorted().forEach(System.out::println);



    }
}
