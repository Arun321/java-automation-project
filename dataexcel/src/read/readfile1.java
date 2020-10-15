package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readfile1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		File src = new File("C:\\Users\\user\\Desktop\\Java_Selenium\\dataexcel\\TestData\\InputData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowCount = sheet1.getLastRowNum();
		
		System.out.println("Total number of row is "+ rowCount);
		
		for(int i =0 ; i < rowCount; i++)
		{
			String data0 = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Test data from excel is "+data0);
		}
		
		wb.close();
	}

}
