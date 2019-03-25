package com.quovantis.quarcmobile.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quovantis.quarcmobile.config.Constants;

public class ExcelUtility 
{
	public static String getKeyValue(String sheetName, String methodName, String key) throws IOException 
	{
	InputStream XlsxFileToRead = new FileInputStream(Constants.EXCEL_FILE);
	XSSFWorkbook workbook = new XSSFWorkbook(XlsxFileToRead);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	XSSFRow row;
	XSSFCell cell=null;
	// currentCell = null,
	String mName, key1, value = null;
	
	int rowNum = sheet.getLastRowNum() + 1;
	//int colNum = sheet.getRow(0).getLastCellNum();
	
	for(int rc=0; rc <rowNum; rc++)
	{
/*	System.out.println(rowNum);
	System.out.println(rc);*/
	row = sheet.getRow(rc);
	
	cell = row.getCell(0);	
	mName = cellToString(cell);
	
	cell = row.getCell(1);	
	key1 = cellToString(cell);
	
	if((mName.equals(methodName))&& key.equals(key1))
	{
	cell = row.getCell(2);	
	value = cellToString(cell);
	}	

	}
	return value;

	}

	public static String cellToString(XSSFCell cell) 
	{ 
	Object result = null;
		
 switch (cell.getCellType()) 
 {
 
 case XSSFCell.CELL_TYPE_NUMERIC:
 result = cell.getNumericCellValue();
 break;
 case XSSFCell.CELL_TYPE_STRING:
 result = cell.getStringCellValue();
 break;

 case XSSFCell.CELL_TYPE_BLANK:
 result = "";
 break;

 case XSSFCell.CELL_TYPE_FORMULA:
 result = cell.getCellFormula();
 break;

 default:
 break;
 }
	return result.toString();
	}

	}
