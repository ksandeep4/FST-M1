package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    private static String FILE_NAME = "resources/TestSheet.xlsx";
    public static void main(String[] args)
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Data Types");
        Object[][] datatypes =
                {
                        {"Datatype", "Type", "Size (in bytes)"},
                        {"int", "primitive", 2},
                        {"float", "primitive", 4},
                        {"double", "primitive", 8},
                        {"char", "primitive", 1},
                        {"String", "non-primitive", "Not of fixed length."}
                };
        int rowNum=0;
        System.out.println("Creating Excel Sheet....");
        for(Object[] datatype: datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try
        {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Done");

    }
}