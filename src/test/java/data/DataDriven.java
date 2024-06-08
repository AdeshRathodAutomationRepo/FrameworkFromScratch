package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDriven {
	
	@Test
	public void excel() throws IOException  {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\Desktop\\Test.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		//number of sheets
		int sheets= workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet= workbook.getSheetAt(i);
				
				Iterator<Row> rows= sheet.iterator();
				 Row firstRow= rows.next();
				 
				 Iterator<Cell> ce= firstRow.iterator();
				 int k=0;
				 int column=0;
				 while(ce.hasNext()) {
					 Cell value= ce.next();
					 
					 if(value.getStringCellValue().equalsIgnoreCase("data3")) {
						 column=k;
					 }
					 k++;
				 }
				 
				 System.out.println(column);
				
				 while(rows.hasNext()) {
					 Row r= rows.next();
					 if(r.getCell(column).getStringCellValue().equalsIgnoreCase("sssc")) {
						 Iterator<Cell> cv= r.iterator();
						 while(cv.hasNext()) {
							 System.out.println(cv.next().getStringCellValue());
						 }
					 }
			}
		}
		
		
	}
	}
}
