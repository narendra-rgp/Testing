package nari.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;




public class Data_Utils {
	
	
	 public static void Excel(String path,String sheet_name,String TestCase_ID) throws IOException  {
	  
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet_name);
		XSSFRow row = get_row(sh, TestCase_ID);
		Data.hm = get_cellValue(sh, row);
						wb.close();
		}
	private static XSSFRow get_row(XSSFSheet sh,String TestCase_ID){
			XSSFRow row = null ; 
			for(int i = 0;i<sh.getPhysicalNumberOfRows();i++) {
				if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TestCase_ID)) {
					row = sh.getRow(i);
					break;
				}
			}if(row == null) {
				Assert.assertTrue(false, "Unable to find the Testcase Id ");
			}
			return row;
		}
	private static HashMap<String , String> get_cellValue(XSSFSheet sh,XSSFRow row) {
		HashMap<String , String> h = new HashMap<String , String>(); 
		for(int i = 0;i<row.getPhysicalNumberOfCells();i++) {
			
			String s = get_cellType(row.getCell(i));
			h.put(sh.getRow(0).getCell(i).getStringCellValue(), s);
			//h.put(sh.getRow(0).getCell(i).getStringCellValue(), row.getCell(i).getStringCellValue());
			
		}
		return h;
	}
	private static String get_cellType(XSSFCell cell) {
		
		CellType c = cell.getCellType();
		Object text = null;
		switch ( c) {
		case STRING:
			text = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(cell.toString().length() < 5) {
				text = (int)cell.getNumericCellValue();
			}else {
				text = new BigDecimal(cell.getNumericCellValue());
			}
			
			
			break;
			
		case BOOLEAN:
			text = cell.getBooleanCellValue();
			break;
		
		default:
			break;
		}
		
		return text.toString();
	}
	
	public static HashMap<String, String> proerties() throws IOException {
		FileInputStream fis = new FileInputStream("./Test-Data//Config.properties");
		Properties p = new Properties();
		p.load(fis);
		Set<Object> keys = p.keySet();
		for(Object key: keys) {
			
			Data.hm.put(key.toString(),p.getProperty(keys.toString()));
		}return Data.hm;
		
	}
	
	
}
