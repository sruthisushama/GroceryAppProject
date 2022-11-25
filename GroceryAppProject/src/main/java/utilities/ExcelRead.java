package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	String data;
	

	public String readData(int rowNo,int cellNo) {

		try {
			file = new FileInputStream(
					new File(System.getProperty("user.dir") + "//src//main//resources//ExcelFiles//logindetails.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Get first/desired sheet from the workbook
		sheet = workbook.getSheetAt(0);

		row = sheet.getRow(rowNo);

		cell = row.getCell(cellNo);
		data = cell.getStringCellValue();

		return data;
	}
}

//			// Iterate through each rows one by one
//			Iterator<Row> rowIterator = sheet.iterator();
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				// For each row, iterate through all the columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//
//				while (cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//
//					System.out.print(cell.getStringCellValue() + "\t");
//
//				}
//				System.out.println("");
//			}
