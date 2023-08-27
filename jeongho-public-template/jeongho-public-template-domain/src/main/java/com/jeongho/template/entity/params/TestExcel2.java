package com.jeongho.template.entity.params;

import com.jeongho.template.entity.base.ExcelCustomAnnotation;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.core.annotation.Order;

@Setter
@Getter
@ToString
public class TestExcel2 implements TestOrder {
    @ExcelOrderAnnotation(1)
    private String phone;
    @ExcelOrderAnnotation(2)
    private String name;
    @ExcelOrderAnnotation(3)
    private int age;
    @ExcelOrderAnnotation(4)
    private String address;
    @ExcelOrderAnnotation(6)
    private int orderr;
    @ExcelOrderAnnotation(5)
    private String gender;

    @Override
    public List<String> getOrder(){
        return List.of("getPhone", "getName", "getAddress", "getOrderr", "getGender");
    }

    /*
     *
     * */

}


