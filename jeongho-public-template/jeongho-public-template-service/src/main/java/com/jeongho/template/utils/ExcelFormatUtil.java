package com.jeongho.template.utils;

import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InternalServerException;
import com.jeongho.template.entity.form.ExceptionMessage;
import com.jeongho.template.entity.params.ExcelOrderAnnotation;
import com.jeongho.template.entity.params.TestExcel2;
import com.jeongho.template.entity.params.TestOrder;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

@Configuration
public class ExcelFormatUtil {


    /**
     * Map List
     *
     * @param response
     * @param param
     * @param <T>
     */
    public static<T> void exportObjectToExcel(HttpServletResponse response, Map<String, List<?>> param) throws IOException {

        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();

            // Cell style이 필요할 경우 적용
//            CellStyle numberCellStyle = wb.createCellStyle();
//            numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,0"));

            final List<?> headerParamList = param.get("header");
            final List<?> bodyParamList = param.get("body");

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

                T object = (T) bodyParamList.get(i);

                List<Object> getObjectValues = getAllDataFromModel(null);

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

    /**
     *
     * SQL -> field 명 yml 순서 보장하게 확실하게 하기
     *
     * @param object
     * @return
     */

    public static List<Object> getAllDataFromModel(TestOrder object) {

        List<Object> getterValues = new ArrayList<>();

        try {
            Method[] methods = object.getClass().getDeclaredMethods();

            var list = object.getOrder();

            for(String order : list) {
                var f = object.getClass().getDeclaredMethod(order);
                getterValues.add(f.invoke(object));
            }
            /*
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    getterValues.add(method.invoke(object));
                }
            }
            */
        } catch (Exception e) {
            throw new InternalServerException(e);
        }

        return getterValues;
    }

    public static List<Field> getAllDataOrderFromModel(Object object) {

        List<Field> orderObject = new ArrayList<>();

        Field[] fields = object.getClass().getFields();

        for(Field f : fields){
            if(f.isAnnotationPresent(ExcelOrderAnnotation.class)){
                orderObject.add(f);
            }
        }

        orderObject.sort(Comparator.comparingInt(fi -> fi.getAnnotation(ExcelOrderAnnotation.class).value()));


        return orderObject;
    }

    // test
    public static void main(String[] args) {

        // 1 Object Test
        List<TestExcel2> listTest = new ArrayList<>();
        TestExcel2 test = new TestExcel2();

        test.setPhone("111111");
        test.setName("정호");
        test.setOrderr(1);
        test.setGender("Male");
        test.setAge(18);
        test.setAddress("korea");

        listTest.add(test);

//        System.out.println(listTest.get(0).getName());

        List<Object> result = getAllDataFromModel(listTest.get(0));

        for (Object o : result) {
            System.out.println(o);
        }

    }


}
