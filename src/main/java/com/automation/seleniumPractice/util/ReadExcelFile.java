package com.automation.seleniumPractice.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	private static final String FILE_PATH="D:\\eclipse_projects\\seleniumPractice\\TestData.xlsx";
	
	public Object[][] readDataFromExcel() throws InvalidFormatException, IOException
	{
		//FileInputStream fis=new FileInputStream(new File(FILE_PATH));
		XSSFWorkbook workbook = new XSSFWorkbook(new File(FILE_PATH));
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int lastRow=sheet.getPhysicalNumberOfRows();
		Object[][] data=new Object[lastRow][2];
		for(int i=0;i<lastRow;i++)
		{
			XSSFRow row = sheet.getRow(i);
			data[i][0] = row.getCell(0).getStringCellValue();
			data[i][1] = row.getCell(1).getStringCellValue();
		}
		return data;
	}
}
