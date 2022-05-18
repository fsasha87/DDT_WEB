package dataProvider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class DataProviderXLSX {
    @DataProvider(name = "DpXLSX", parallel = true)
    public static Object[][] xlsxDataRead() throws Exception {
        Workbook workbook = new XSSFWorkbook(new FileInputStream("src/test/resources/data.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColumns = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    data[i][j] = cell.getStringCellValue();
                }
                if (cell.getCellType() == CellType.NUMERIC) {
                    data[i][j] = (int) cell.getNumericCellValue() + "";
                }
            }
        }
        return data;
    }
}
