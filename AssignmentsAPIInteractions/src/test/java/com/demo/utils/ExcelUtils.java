package com.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public ArrayList<String> readExcelWithSpecificRow(int rowNum) throws IOException{
		
		String path=System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"convertcsv.xlsx";
		
		FileInputStream fis = new FileInputStream(new File(path));
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0); 
		Row getSchool = sheet.getRow(rowNum);
	    Iterator<Cell> cellIterator = getSchool.cellIterator();
	    ArrayList<String> rowLst = new ArrayList<String>();
	    
	    while (cellIterator.hasNext())
	    {
	    	rowLst.add(cellIterator.next().getStringCellValue());
	    }
	    
	    /*for(int i=0;i<rowLst.size();i++){
	    	System.out.println(i+":"+rowLst.get(i));
	    }*/
	    return rowLst;
	}
	
	public HashMap<String,String> getFramedMap(ArrayList<String> keyLst,ArrayList<String> valuesLst){
		HashMap<String,String> map = new HashMap<String,String>();
		for(int i=0;i<keyLst.size();i++){
			map.put(keyLst.get(i), valuesLst.get(i));
		}
		return map;
	}
	
	/*public void writeExcelFile(String sheetName,String[] data_write) throws IOException{
		String filePath =System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"result.xlsx";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.createSheet("Java Books");
		Sheet testSheet = workBook.getSheet(sheetName);
		
		int rowCount = testSheet.getLastRowNum()-testSheet.getFirstRowNum();
		 Row row = testSheet.getRow(0);
		 Row newRow = testSheet.createRow(rowCount+1);
		 
		 for(int j=0;j<row.getLastCellNum();j++){
			 Cell cell = newRow.createCell(j);
			 cell.setCellValue(data_write[j]);
		 }
		 
		 fis.close();
		 FileOutputStream fos = new FileOutputStream(file);
		 workBook.write(fos);
		 fos.close();
		 
	}*/
	
	public void writeResultsIntoExcelFile(String fileName,Object[][] bookData) throws FileNotFoundException, IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(fileName);
         
        /*Object[][] bookData = {
                {"Head First Java", "Kathy Serria"},
                {"Effective Java", "Joshua Bloch"},
                {"Clean Code", "Robert martin"},
                {"Thinking in Java", "Bruce Eckel"},
        };*/
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") +File.separator+"testdata"+File.separator+fileName+".xlsx")) {
            workbook.write(outputStream);
        }
	}

}
