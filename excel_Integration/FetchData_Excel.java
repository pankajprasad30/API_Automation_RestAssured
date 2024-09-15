package excel_Integration;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData_Excel 
{
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	FetchData_Excel(String ExcelPath, String Sheetname ) throws IOException
	{
		 workbook=new XSSFWorkbook(ExcelPath);
		 sheet=workbook.getSheet(Sheetname);		
	}
	
	public static Object getTestData(int x, int y)
	{
		DataFormatter formatter=new DataFormatter();
		Object value=formatter.formatCellValue(sheet.getRow(x).getCell(y));
		
		return value;
	}

}
