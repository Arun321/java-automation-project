package read;

import lib.exceldataconfig;

public class readfiledata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exceldataconfig excel = new exceldataconfig("C:\\Users\\user\\Desktop\\Java_Selenium\\dataexcel\\TestData\\InputData.xlsx");
		
		System.out.println(excel.getData(0, 0, 0));
	}

}
