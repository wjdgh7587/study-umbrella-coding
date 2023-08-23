package com.jeongho.template.entity.params;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;

@Getter
@Setter
@ToString
public class TestExcel2{
    private int order;
    private String name;
    private String gender;

}
