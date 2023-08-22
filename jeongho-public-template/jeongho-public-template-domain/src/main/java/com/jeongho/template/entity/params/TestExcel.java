package com.jeongho.template.entity.params;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import org.apache.poi.ss.usermodel.Row;

public class TestExcel implements ExcelObject{
    @ExcelCustomAnnotation(headerName = "No")
    private int order;
    @ExcelCustomAnnotation(headerName = "Name")
    private String name;
    @ExcelCustomAnnotation(headerName = "gender")
    private String gender;

    @Override
    public void fillUpFromRow(Row row) {
        this.order = (int) row.getCell(0).getNumericCellValue();
        this.name = row.getCell(1).getStringCellValue();
        this.gender = row.getCell(2).getStringCellValue();
    }
}
