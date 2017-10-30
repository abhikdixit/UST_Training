package demo_package;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadExcelXLS {

  static int rowcount=0;
  @Test
  public void ReadExcel() throws IOException, InvalidFormatException{
  FileInputStream fis=new FileInputStream("C:\\Users\\adixit\\workspace\\Demo_CG\\FlightTestData.xlsx");
  Workbook wb=WorkbookFactory.create(fis);
  Sheet sh=wb.getSheet("TestData");
  Row row=sh.getRow(2);
  Cell cell=row.getCell(1);
  System.out.println(cell);
  String cellval=cell.getStringCellValue();
  System.out.println(cellval);
  }}