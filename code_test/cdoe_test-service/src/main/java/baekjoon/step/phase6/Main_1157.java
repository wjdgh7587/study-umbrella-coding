package baekjoon.step.phase6;

import java.util.*;

public class Main_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String,List<String>> result = new HashMap();

        for(int i=0; i<input.length(); i++){
            String a = String.valueOf(input.charAt(i)).toUpperCase();
            if(!result.containsKey(a)){
                List<String> dummy = new ArrayList<>();
                dummy.add(a);
                result.put(a, dummy);
            }else{
                result.get(a).add(a);
            }
        }
        System.out.println(result.size());

        Iterator<String> iterator = result.keySet().iterator();

        while(iterator.hasNext()){
            String key = iterator.next();


        }
    }

}
