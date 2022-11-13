package org.backjune.question.example;

import java.util.Scanner;

public class Main_10926 {

    // 제출 코드
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String firstAnswer = scanner.nextLine();
//        String result = firstAnswer+"??!";
//
//        System.out.println(result);
//    }

    /***
     * 조건 : 아이디는 알파벳 소문자로만 이루어져 있으며, 길이는 50자를 넘지 않는다.
     * @param args
     */
    public static void main(String[] args) {
        // java Scanner
        Scanner scanner = new Scanner(System.in);

        String firstAnswer = scanner.next();
        String result = null;

        System.out.println(firstAnswer);

        Boolean figurePhaseOne = figureCharLength(firstAnswer);

        if(figurePhaseOne == true){
            System.out.println("문자열의 길이가 50 이상입니다.");
        }else{
            Boolean figurePhaseTwo = figureLanguage(firstAnswer);
            if(figurePhaseTwo == true){
                result = firstAnswer+"??!";
            }
        }
        System.out.println("Result : "+result);
    }


    /***
     * 문자열의 길이를 계산하는 모듈
     * @param paramA
     * @return
     */
    public static Boolean figureCharLength(String paramA){

        int count = paramA.length();

        if(count > 50){
            return true;
        }else{
            return false;
        }
    }

    /****
     * 문자 영어 대소문자만 허용
     * @param paramA
     * @return
     */
    public static Boolean figureLanguage(String paramA){

        Boolean result = null;

        for(int i=0; i<paramA.length(); i++){
            char charInput = paramA.charAt(i);
            if(charInput >= 0x61 && charInput <= 0x7A){
                result = true;
            }else if(charInput >= 0x41 && charInput <= 0x5A){
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }

}
