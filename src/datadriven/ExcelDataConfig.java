package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	
	
	public Sheet getSheetObject(String str) throws IOException{
		
		File file =    new File(str);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook pWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = str.substring(str.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    pWorkbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file
	    // this is a change to make effect in commit

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        pWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet pSheet = pWorkbook.getSheet("Sheet1");

	    //Find number of rows in excel file
		return pSheet;
	}

}
