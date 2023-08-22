package com.jeongho.template.utils;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ExcelFormatUtil {

    /***
     * 임의의 객체 리스트를 엑셀 파일로 변환해 OutputStream 으로 던짐
     *
     */
    public <T> void exportDataToExcel(OutputStream stream
            , List<T> data
            , Class<T> classz) throws IOException {

        // Create workbook and sheet
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet();

    }

    public <T> Map<String, List<T>> generateExcelForm(
            Map<String, Object> headerMap
            , List<T> bodyList){

        Map<String, List<T>> resultMap = new HashMap<>();

        return resultMap;
    }

    private <T> void renderHeader(Sheet sheet, Class<T> classz){

        // Row 시작 행
        Row row = sheet.createRow(0);
        // Col 시작 열
        int colIdx = 0;

        // Set Header Name
        for(Field field : classz.getDeclaredFields()) {
            String headerName;
            // custom excel annotation 여부 판별
            if (field.isAnnotationPresent(ExcelCustomAnnotation.class)) {
                headerName = field.getAnnotation(ExcelCustomAnnotation.class).headerName();
                row.createCell(colIdx, CellType.STRING).setCellValue(
                        headerName.equals("") ? field.getName() : headerName
                );
                colIdx++;
            }

        }

    }

    private <T> void renderBody(){

    }

    

}
