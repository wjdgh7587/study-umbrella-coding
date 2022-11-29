package baekjoon.step.phase6;

import java.util.*;

/**
 * 최초에 생각했을때, map으로 알파벳 key를 지정하고 list를 통해 입력받은 알파벳들의 갯수를 사이즈로
 * 지정하여 판단하려고 했다. 하지만, 정작 그렇게 할 경우 문제에 대한 답을 뽑아내는대에는 큰 문제가 있었다.
 */
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
        Iterator<String> iterator = result.keySet().iterator();

        while(iterator.hasNext()){
            String key = iterator.next();


        }
    }

}
