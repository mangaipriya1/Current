package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet1;


	public ReadExcel(){
		try{
			File src = new File(Configure.getExcel());
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public String getData(int sheetname,int row,int col){
		sheet1 = wb.getSheetAt(sheetname);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();		
		return data;

	}

	public int getRowCount(int sheetindex){
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row=row+1;
		return row;
	}
	
	/*	public static void main(String[] args){
		HSSFWorkbook wb;
		HSSFSheet sheet1;
		public static void ReadExcel1(){
			try {
				File src = new File(Configure.getExcel());
				FileInputStream fis = new FileInputStream(src);
				wb = new HSSFWorkbook(fis);
				sheet1 = wb.getSheetAt(0);
				System.out.println(sheet1);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	private static void ReadExcel1() {
		// TODO Auto-generated method stub

	}*/

}
