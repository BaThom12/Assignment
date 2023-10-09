package com.vmo.demowebshop.utils;

import org.testng.annotations.DataProvider;

public class ExcelConfig {
    ExcelUtils excel = new ExcelUtils("C:\\selenium\\Training\\Assigment\\src\\test\\resources\\assignment.xlsx");
    @DataProvider(name="getInforLogin")
    public Object[][] getData(){
        return excel.dataExcel();
    }
}
