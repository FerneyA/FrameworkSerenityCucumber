package utils;

import java.io.IOException;

public class ExcelDataProvider {

    public Object[][] getTestData(String excelName, String sheetName) throws IOException {
        ExcelIO excel = new ExcelIO(excelName, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object data[][] = new Object[rowCount-1][colCount];
        for(int i=1; i < rowCount; i++) {
            for(int j=0; j < colCount; j++) {
                data[i-1][j] = excel.getCellDataString(i, j);
            }
        }
        return data;
    }
}
