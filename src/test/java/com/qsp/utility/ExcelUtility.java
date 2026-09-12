package com.qsp.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility
{
	String Excelpath =null;

	ExcelUtility(String Excelpath)
	{
		this.Excelpath=Excelpath;
	}

	FileInputStream fis;
	XSSFWorkbook book;
	XSSFSheet sheet ;
	XSSFRow row;
	XSSFCell cell;
	//get row count
	public int getRowCount(String ExcelPath,String sheetName) throws IOException 
	{
		fis = new FileInputStream(ExcelPath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		fis.close();
		book.close();
		return lastRow;
	}
	//get cell count
	public int getCellCount(String ExcelPath,String sheetName,int rowCount) throws IOException
	{

		fis = new FileInputStream(ExcelPath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowCount);
		int lastCell=row.getLastCellNum();
		fis.close();
		book.close();
		return lastCell;
	}
	//get Data
	public String fetchData(String ExcelPath,String sheetName,int rowCount,int cellCount) throws IOException 
	{

		fis = new FileInputStream(ExcelPath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowCount);
		cell = row.getCell(cellCount);
		String value = cell.getStringCellValue();
		fis.close();
		book.close();
		return value;

	}
	//write data
	public void writeData(String ExcelPath,String sheetName,int rowCount,int cellNum,String data) throws IOException
	{

		fis = new FileInputStream(ExcelPath);
		book = new XSSFWorkbook(fis);
		sheet=book.getSheet(sheetName);

		if(sheet==null) {
			book.createSheet(sheetName);
		}
		row=sheet.getRow(rowCount);
		if(row==null) {
			sheet.createRow(rowCount);
		}
		cell = row.getCell(cellNum);
		if (cell == null) 
		{ 
			cell = row.createCell(cellNum); 
		}
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(ExcelPath);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}

}
