package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws Exception {
		// Load file location in to File Input Stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vtiger.xlsx");
		//Create a workbook
		Workbook workbook=WorkbookFactory.create(fis);
		//Navigate to required sheet
		Sheet sh=workbook.getSheet("Organisations");
		//Navigate to required row
		Row row=sh.getRow(7);
		//Navigate to required cell
		Cell cell=row.getCell(4);
		//Capture the data present in the cell
		String value=cell.getStringCellValue();
		System.out.println(value);
		
		String value1=row.getCell(2).getStringCellValue();
		System.out.println(value1);
	}

}
