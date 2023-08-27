package com.jeongho.template.entity.params;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.core.annotation.Order;

@Setter
@Getter
@ToString
public class TestExcel2{
    @ExcelOrderAnnotation(1)
    private int order;
    @ExcelOrderAnnotation(2)
    private String name;
    @ExcelOrderAnnotation(3)
    private String gender;

}


