package main.java.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelIO {

    XSSFWorkbook workBook;
    XSSFSheet sheet;

    public ExcelIO(String excelName, String sheetName) throws IOException {
        workBook = new XSSFWorkbook(System.getProperty("user.dir") + "\\test-data\\" + excelName);
        sheet = workBook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellDataString(int rowNum, int colNum) {
        sheet.getRow(rowNum).getCell(colNum).setCellType(CellType.STRING);
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }

    public double getCellDataNumeric(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
    }
}
