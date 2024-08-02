package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadClass {
	static FileInputStream file;
	static XSSFWorkbook book;
	static XSSFSheet sheet;

	public static String readStringData(int row, int coloumn) throws IOException {
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SampleExcel.xlsx");
		book = new XSSFWorkbook(file);
		sheet = book.getSheet("Sheet1");
		Row r = sheet.getRow(row);
		Cell c = r.getCell(coloumn);
		return c.getStringCellValue();

	}
	//"C:\Users\premc\OneDrive\Desktop\Workspace\sampleprojectPOM\src\test\resources\SampleExcel.xlsx"
	public static String readIntegerData(int row, int coloumn) throws IOException {
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SampleExcel.xlsx");
		book = new XSSFWorkbook(file);
		sheet = book.getSheet("Sheet1");
		Row r = sheet.getRow(row);
		Cell c = r.getCell(coloumn);
		int a = (int) c.getNumericCellValue();
		return String.valueOf(a);
	}

}