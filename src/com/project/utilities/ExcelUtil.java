package com.project.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet sh;
	public static Row ro;
	public static Cell ce;
	public static FileOutputStream fo;
	public static CellStyle style;

	public static int rowCount(String xlFile, String xlSheet) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		int rowCount = sh.getLastRowNum();
		fi.close();
		wb.close();
		return rowCount;
	}

	public static int ColCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		ro = sh.getRow(rowNum);
		int colCount = ro.getLastCellNum();
		fi.close();
		wb.close();
		return colCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		ro = sh.getRow(rowNum);
		ce = ro.getCell(colNum);
		String data;
		try {
			data = ce.getStringCellValue();
		} catch (Exception e) {
			data = "";
		}
		fi.close();
		wb.close();
		return data;
	}

	public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum,String data) throws IOException{
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlSheet);
		ro = sh.getRow(rowNum);
		ce=ro.createCell(colNum);
		ce.setCellValue(data);
		if(data=="PASSED")
		{
			style=wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			ce.setCellStyle(style);
		}
		else
		{
			style=wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			ce.setCellStyle(style);
		}
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();	
		fo.close();
	}
}