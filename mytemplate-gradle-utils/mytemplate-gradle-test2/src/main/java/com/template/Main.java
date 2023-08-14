package com.template;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);

        String scannerInput = "final fnial fanil proxy pxory abyss";
                //scanner.nextLine();

        // input된 값 배열 처리
        String[] inputArray = scannerInput.split(" ");

        // 실제 처리된 그룹들이 담기는 그릇
        Map<String, List<String>> groupMap = new HashMap<>();

        for(String s : inputArray){

            // charcter 구분후 낷
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortS = String.valueOf(chars);

            //
            if(!groupMap.containsKey(sortS)){
                groupMap.put(sortS, new ArrayList<>());
            }
            groupMap.get(sortS).add(s);

        }

        for(List<String> s : groupMap.values()){
            for(String ss : s){
                System.out.print(ss+" ");
            }
            System.out.println();
        }

    }

}