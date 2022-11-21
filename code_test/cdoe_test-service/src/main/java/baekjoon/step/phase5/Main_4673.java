package baekjoon.step.phase5;

public class Main_4673 {
    public static void main(String[] args) {
        boolean[] num = new boolean[100001];

        for(int i=1; i<=10000; i++){
            int j = getSelfNumber(i);
            num[j] = true;
        }


        for(int i=1; i<=10000; i++){
            if(!num[i]){
                System.out.println(i);
            }
        }
    }

    public static int getSelfNumber(int param){

        int result = param;

        String parseParam = String.valueOf(param);

        for(int i=0; i<parseParam.length(); i++){
            result = result + Character.getNumericValue(parseParam.charAt(i));
        }

        return result;
    }

}
