package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods related to Excel sheet
 * @author Srikar Reddy
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will take the value from excel sheet for respective sheet name,row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
	FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
	Workbook workbook=WorkbookFactory.create(fis);
	Sheet sheet= workbook.getSheet(sheetName);
	Row row=sheet.getRow(rowNum);
	Cell cell=row.getCell(cellNum);
	String value=cell.getStringCellValue();
	workbook.close();
	return value;
	
	}
	
	/**
	 * This method will give total row count in the sheet 
	 * @param sheetName
	 * @return
	 * @throws Exception 
	 */
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet= workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		return rowCount;
		
	}
/**
 * This method will write the value in to excel sheet for respective sheet name,row number and cell number
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @throws Exception
 */
	public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet= workbook.getSheet(sheetName);
		Row row=sheet.createRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IConstantUtility.ExcelFilePath);
		workbook.write(fos);
		workbook.close();
	
	}
	
	public Object[][] readMultipleDataIntoDataProvider(String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet= workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCellNum];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
}
