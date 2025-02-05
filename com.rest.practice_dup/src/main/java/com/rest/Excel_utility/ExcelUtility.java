package com.rest.Excel_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/proj_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh1=wb.getSheet(sheetname);
		Row r1=sh1.getRow(rownum);
		Cell c1=r1.getCell(cellnum);
		String data=c1.getStringCellValue();
		wb.close();

		return data;
	}
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/proj_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		wb.close();

		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/proj_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	     Cell c1= wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		c1.setCellType(CellType.STRING);
		c1.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./TestScriptData/report1.xlsx");
		wb.write(fos);
		
	}

}
