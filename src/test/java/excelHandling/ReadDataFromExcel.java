package excelHandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* Excel Structure 
 * Excel ==> WorkBook ==> sheets ==> Rows ==> Cells
 * FileInputStream Class --> to read files
 * FileOutputStream Class --> write in file
 * XSSFWorkbook class --> workbook
 * XSSFSheet Class --> sheets
 * XSSFRow Class --> Row // rows are counting from 0
 * XSSFCell Class --> Cell  // cells are counting from 1
 * 
 * */
public class ReadDataFromExcel 
{
public static void main(String[] args) throws IOException {
	

	String path = ".\\testData\\data.xlsx";
	
	FileInputStream  file = new FileInputStream(path);
	
	XSSFWorkbook wb = new XSSFWorkbook(file);
	
	XSSFSheet sheet = wb.getSheet("Sheet1");
	
	int numberOfRows = sheet.getLastRowNum();
	
	 XSSFRow row = sheet.getRow(1);
	
	int numberOfCell = row.getLastCellNum();
	
//	System.out.println(numberOfRows);
//	System.out.println(numberOfCell);
	

    System.out.println("---------------------------------------------------------------------------------------------------");

    for (int r = 0; r <= numberOfRows; r++) {
        XSSFRow currentRow = sheet.getRow(r);

        for (int c = 0; c < numberOfCell; c++) {
            XSSFCell cell = currentRow.getCell(c);
            String data = cell.toString();
            System.out.print(String.format("%-20s", data)); // Formatting with a fixed width of 20 characters
        }

        System.out.println();
    }

    System.out.println("---------------------------------------------------------------------------------------------------");

	 wb.close();
	 file.close();
	
	
	
	
	
	
	
	
}
}
