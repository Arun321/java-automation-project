package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readfile {
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			
			File src = new File("C:\\Users\\user\\Desktop\\Java_Selenium\\dataexcel\\TestData\\InputData.xlsx");
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(0);
			
			String data = sheet1.getRow(0).getCell(0).getStringCellValue();
			
			System.out.println("Data from excel is "+ data);
			
			wb.close();
			
		}

	}
