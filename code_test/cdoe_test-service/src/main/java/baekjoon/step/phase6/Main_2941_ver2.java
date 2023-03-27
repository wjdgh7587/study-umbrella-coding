package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_2941_ver2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputText = sc.next();
        int result = 0;

        for(int i=0; i<inputText.length(); i++){
            char test = inputText.charAt(i);

            // 뒷자리가 j로 시작되는 케이스
            if(test == 'j'){
                if(i-1 >= 0){
                    char a = inputText.charAt(i-1);

                    if(a == 'n' || a == 'l'){
                        result += 1;
                    }
                    else{
                        result += 1;
                    }
                }

            }
            // 뒷자리가 -로 시작되는 케이스
            else if(test == '-'){
                if(i-1 >= 0){
                    char a = inputText.charAt(i-1);
                    if(a == 'c' || a == 'd'){
                        result += 1;
                    }
                    else{
                        result += 1;
                    }
                }
            }

            // 뒷자리가 = 로 시작되는 케이스
//            else if(test == '='){
//                if(i-1 >= 0){
//                    char a = inputText.charAt(i-1);
//                    if(a == 's'){
//                        result += 1;
//                    }else if(a == 'z'){
//                        char za = inputText.charAt(i-2);
//                        if(za == 'd'){
//                            result += 1;
//                        }else{
//                            result += 1;
//                        }
//                    }else {
//                        result += 1;
//                    }
//
//                }
//            }
        }
        System.out.println(result);
    }

}
