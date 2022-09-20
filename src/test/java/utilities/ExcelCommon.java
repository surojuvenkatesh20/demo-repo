package utilities;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelCommon {
	File f = new File("C:\\Users\\user\\Desktop\\dr\\demofile.xls");
	Workbook wb = Workbook.getWorkbook(f);
	public ExcelCommon() throws BiffException, IOException
	{
		
//		Sheet sheet = wb.getSheet(0);
	}
	public Sheet getsheet()
	{
		return wb.getSheet(0);
	}
	public void writeExcel(int x, int y, String content) throws IOException
	{
		WritableWorkbook wwb = Workbook.createWorkbook(f, wb);
		WritableSheet wsh = wwb.getSheet(0);
		Label l = new Label(x, y, content);
		try
		{
			wsh.addCell(l);
			wwb.write();
			wwb.close();
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
