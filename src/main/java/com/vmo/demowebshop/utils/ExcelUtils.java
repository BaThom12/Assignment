package com.vmo.demowebshop.utils;

import com.vmo.demowebshop.helper.Log;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    private FileInputStream fileIn;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    public ExcelUtils(String excelPath){
        try {
            File file = new File(excelPath);
            fileIn = new FileInputStream(file);
            workbook =  new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public ExcelUtils(){
        try {
            File file = new File("");
            fileIn = new FileInputStream(file);
            workbook =  new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int getNumberOfRow(){
        sheet = workbook.getSheetAt(2);
        return sheet.getLastRowNum();
    }
    public int getNumberOfColumn(){
        sheet = workbook.getSheetAt(2);
        return sheet.getRow(0).getLastCellNum();
    }

    public String getValueOfCell(int rowNum, int colNum){
        sheet = workbook.getSheetAt(2);
        DataFormatter format = new DataFormatter();
        try{
            return format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        }catch(NullPointerException npe){
            return "";
        }

    }

    public Object[][] dataExcel(){
        int rowNum = getNumberOfRow();
        int colNum = getNumberOfColumn();
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow =0;
        for(int i=1;i<rowNum;i++){
            for(int j = 1;j<colNum;j++){
                obj[currentRow][j] = getValueOfCell(i,j);
            }
            currentRow++;
        }
        return obj;
    }
}
