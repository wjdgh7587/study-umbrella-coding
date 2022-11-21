package baekjoon.step.phase5;

public class Main_4673_ver2 {
    public static void main(String[] args) {
        // 다른 코드 방식으로 풀어보기

        int n = 10000;
        int[] numList = new int[n*10+1];

        for(int i=1; i<=10000; i++){
            int j = getSelfNumber(i);;
            numList[j] = j;
        }

        for(int i=1; i<=10000; i++){
            if(numList[i] == 0){
                System.out.println(i);
            }
        }
    }

    // 셀프넘버 d(n) = 자기자신의 숫자 + 자리수

    public static int getSelfNumber(int param){
        int result = param;

        char[] chars = String.valueOf(param).toCharArray();

        for(int i=0; i<chars.length; i++){
            result = result + Integer.parseInt(String.valueOf(chars[i]));
        }
        return result;
    }
}
