package com.jeongho.template.utils;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import com.jeongho.template.entity.params.TestExcel;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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


    /**
     * Map List
     * @param response
     * @param param
     * @param <T>
     */
    public static <T> void exportObjectToExcel(HttpServletResponse response, Map<String, List<T>> param) throws IOException {

        Workbook wb = WorkbookFactory.create(true);
        Sheet sheet = wb.createSheet();

        CellStyle numberCellStyle = wb.createCellStyle();
        numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

        // File Name;
        final String fileName = "test excel file";

        // Header
        final String[] header = {"test_header1", "test_header2"};
        Row row = sheet.createRow(0);

        for(int i=0; i< header.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }

        // Body



    }

    public List<Map<String, Object>> testArray(){

        List<Map<String, Object>> resultArray = new ArrayList<>();

        Map<String, Object> testMap = new HashMap<>();

        for(int i=0; i<5; i++){

        }

        return null;
    }


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

    /**
     * Render Excel Header
     * @param sheet
     * @param classz
     * @param <T>
     */
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

    /**
     * Render Excel Body
     * @param <T>
     */
    private <T> void renderBody(){

    }

    

}
