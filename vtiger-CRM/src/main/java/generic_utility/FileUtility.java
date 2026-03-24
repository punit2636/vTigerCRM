package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);

		return value;
	}

	
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);;
		String value = cell.getStringCellValue();
		wb.close();
		return value;
	}
	public Double getNumDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);;
		Double value = cell.getNumericCellValue();
		wb.close();
		return value;
	}
}
