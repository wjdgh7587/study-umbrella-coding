package com.jeongho.template.utils;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import com.jeongho.template.entity.params.TestExcel;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ExcelFormatUtil {


    /**
     * Map List
     *
     * @param response
     * @param param
     * @param <T>
     */
    public static <T> void exportObjectToExcel(HttpServletResponse response, Map<String, List<T>> param) throws IOException {

        Workbook wb = WorkbookFactory.create(true);
        Sheet sheet = wb.createSheet();

        CellStyle numberCellStyle = wb.createCellStyle();
        numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

        final List<T> headerParamList = param.get("header");
        final List<T> bodyParamList = param.get("body");

        // File Name setting;
        final String fileName = "test excel file";

        // Excel Header setting;
        Row row = sheet.createRow(0);
        for (int i = 0; i < headerParamList.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headerParamList.get(i).toString());
        }

        // Excel Body setting;
        for (int i = 0; i < bodyParamList.size(); i++) {
            row = sheet.createRow(i + 1);

            // TODO : excel parsing 추가

            int cellCount = 0;

            T object = bodyParamList.get(i);

            Cell cell = null;

            cell = row.createCell(cellCount);
            cell.setCellValue(object.equals(""));
            cellCount++;

            cell = row.createCell(cellCount);
            cell.setCellValue(object.equals(""));
            cellCount++;

            cell = row.createCell(cellCount);
            cell.setCellValue(object.equals(""));
            cellCount++;

            cell = row.createCell(cellCount);
            cell.setCellValue(object.equals(""));
            cellCount++;





        }

//        for (int i = 0; i < userPointList.size(); i++) {
//            row = sheet.createRow(i + 1);  //헤더 이후로 데이터가 출력되어야하니 +1
//
//            UserPoint userPoint = userPointList.get(i);
//
//            Cell cell = null;
//            cell = row.createCell(0);
//            cell.setCellValue(userPoint.getId());
//
//            cell = row.createCell(1);
//            cell.setCellValue(userPoint.getUserCode());
//
//            cell = row.createCell(2);
//            cell.setCellValue(userPoint.getUserName());
//
//            cell = row.createCell(3);
//            cell.setCellValue(userPoint.getPayCnt());
//
//            cell = row.createCell(4);
//            cell.setCellStyle(numberCellStyle);      //숫자포맷 적용
//            cell.setCellValue(userPoint.getPaySum());
//        }

    }

    public List<Map<String, Object>> testArray() {

        List<Map<String, Object>> resultArray = new ArrayList<>();

        Map<String, Object> testMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {

        }

        return null;
    }

    public static List<Method> getObject(Class<?> targetClass){

        List<Method> getterTargetAllList = new ArrayList<>();

        ReflectionUtils.doWithMethods(targetClass, method -> {
            if(method.getName().startsWith("get") && method.getParameterCount() == 0){
                getterTargetAllList.add(method);
            }
        });

        return getterTargetAllList;
    }

    public static void main(String[] args) {

    }




}
