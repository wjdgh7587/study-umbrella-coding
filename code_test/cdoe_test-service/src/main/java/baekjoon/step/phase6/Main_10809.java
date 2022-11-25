package baekjoon.step.phase6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /****
         *
         * 오답... 너무 단순하게 생각하여 복잡하게만 구성함, 필요없는 기능들이 너무 많음
         *
         */


        // 알파벳 소문자로만 이루어진 단어 설정
        // 특정 글자를 입력받아서 현재 알파벳에 포함되어 있는 위치 파악 포함 안되어있으면 -1 return
        // 아스키코드를 기반으로 알파벳 배열에 댬기
        List<String> alphaCharArray = makeAlphaList();

        String input = sc.nextLine();
        char[] inputChar = input.toCharArray();
        List<String> result = findChar(inputChar, alphaCharArray);

        for(String a : alphaCharArray){
            System.out.print(a+" ");
        }
        System.out.println("");

        for(String a : result){
            System.out.print(a+" ");
        }
    }

    /***
     *
     * @param inputArray -> 입력받은 문자 배열
     * @param alphaArray -> 알파벳 문자 배열
     * @return
     */
    static List<String> findChar(char[] inputArray, List<String> alphaArray){

        List<String> result = new ArrayList<>();
        List<String> figure = new ArrayList<>();

        for(int i=0; i<alphaArray.size(); i++){
            int indexNumber = -1;
            for(int j=0; j<inputArray.length; j++){
                String a = alphaArray.get(i);
                String b = String.valueOf(inputArray[j]);

                if(a.equals(b)){
                    if(!figure.contains(String.valueOf(a))){
                        indexNumber = j;
                        figure.add(String.valueOf(indexNumber));
                    }
                }
            }
            result.add(String.valueOf(indexNumber));
        }

        return result;
    }

    static List<String> makeAlphaList(){
        //아스키코드 65 부터는 대문자 97은 소문자
        List<String> alphaArray = new ArrayList<>();
        int i = 0;
        char a;
        while(true){
            if(i==26){
                break;
            }
            a = (char) (97+i);
            alphaArray.add(String.valueOf(a));
            i++;
        }
        return alphaArray;
    }
}
