package org.backjune.question.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main_25304 {
    /****
     * - 첫째 줄은 영수증 총 금액
     * - 둘쨰 줄은 영수증 항목 수
     * - 세번째는 항목에 맞는 디테일 상품 및 갯수
     * - 세번째 항목들끼리 전부 더하고, 첫째 줄에 입력된 값하고 비교 하여 같을시 yes 아니면 no
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String receiptTotalFee = sc.nextLine();
        String receiptGoodsCount = sc.nextLine();

        List<Integer> receiptArray = new ArrayList<>();

        int figureReceiptLoopCount = Integer.parseInt(receiptGoodsCount);
        while(figureReceiptLoopCount > 0){
            String receiptDetails = sc.nextLine();

            String[] receiptDetailsArray = receiptDetails.split(" ");
            int result = Integer.parseInt(receiptDetailsArray[0])
                    * Integer.parseInt(receiptDetailsArray[1]);

            receiptArray.add(result);
            figureReceiptLoopCount--;
        }

        int result = 0;
        for(int value : receiptArray){
            result = result + value;
        }

        if(result == Integer.parseInt(receiptTotalFee)){
            System.out.println("Yes");
        } else System.out.println("No");

    }
}
