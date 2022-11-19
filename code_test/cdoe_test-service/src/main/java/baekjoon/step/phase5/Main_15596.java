package baekjoon.step.phase5;

import java.util.Arrays;

public class Main_15596 {
    public static void main(String[] args) {

        int[] test = {1, 2, 3, 4,5, 10, 20 ,40};
        System.out.println(sum(test));


    }
    public static long sum(int[] a){

        long result = 0;

        for(int n : a){
            result = result + n;
        }
        return result;
    }
    /**
     * Stream 을 활용할 경우는 연산(sum method)을 int로 처리하기 때문에 안되었음
     */

}

