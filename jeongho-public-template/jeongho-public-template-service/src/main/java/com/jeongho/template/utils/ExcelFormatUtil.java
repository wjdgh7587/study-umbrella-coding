package com.jeongho.template.utils;

import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InternalServerException;
import com.jeongho.template.entity.form.ExceptionMessage;
import com.jeongho.template.entity.params.TestExcel2;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
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

        try {
            Workbook wb = WorkbookFactory.create(true);
            Sheet sheet = wb.createSheet();

            // Cell style이 필요할 경우 적용
//            CellStyle numberCellStyle = wb.createCellStyle();
//            numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,0"));

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
                Cell cell = null;

                T object = bodyParamList.get(i);

                List<Object> getObjectValues = getAllDataFromModel(object);

                for (int j = 0; j < getObjectValues.size(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(getObjectValues.get(j).toString());
                }

            }

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");

            wb.write(response.getOutputStream());
            wb.close();

        } catch (InternalServerException e) {
            throw new InternalServerException(BaseResultResCode.RS_5002.getCode()
                    , ExceptionMessage.makeExceptionMessage(BaseResultErrorCode.INTERNAL_SERVER_ERROR.name(), "Excel-Export failed!"));
        }

    }

    public static List<Object> getAllDataFromModel(Object object) {

        List<Object> getterValues = new ArrayList<>();

        try {
            Method[] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    getterValues.add(method.invoke(object));
                }
            }
        } catch (Exception e) {
            throw new InternalServerException(e);
        }

        return getterValues;
    }

    // test
    public static void main(String[] args) {

        // 1 Object Test
        List<TestExcel2> listTest = new ArrayList<>();
        TestExcel2 test = new TestExcel2();

        test.setName("정호");
        test.setGender("남자");

        listTest.add(test);

        System.out.println(listTest.get(0).getName());

        List<Object> result = getAllDataFromModel(listTest.get(0));

        for (Object o : result) {
            System.out.println(o);
        }

    }


}
