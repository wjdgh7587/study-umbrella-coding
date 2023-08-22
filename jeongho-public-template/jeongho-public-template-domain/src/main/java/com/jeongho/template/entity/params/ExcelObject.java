package com.jeongho.template.entity.params;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelObject {
    void fillUpFromRow(Row row);

}
