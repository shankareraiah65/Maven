package com.crm.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is a generic class which is having generic methods to read and write data for
 * property file and excel file
 * @author prasadk
 */
public class FileLibrary 
{
	/**
	 * This is a generic method which is used to read data from property file
	 * @param key
	 * @return it will return the value associated with the methion key
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * This is a generic method to read the data from excel file based on
	 * SheetName , row , cell values that has been passed
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return the data present in the cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName , int row , int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();		
	}
	/**
	 * This is generic method to write the data in excel file based on
	 * SheetName , row , cell and String values that has been passeed
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelData(String sheetName , int row , int cell , String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
	}
}
