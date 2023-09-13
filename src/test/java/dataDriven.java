import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

  public class dataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		
           ArrayList<String> arraylist=new ArrayList<String>();
		
		  FileInputStream fis= new FileInputStream("D:\\Workspace\\exelFile\\demodata.xlsx");
		  XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		// To get an access to the sheet
		  int sheets=workbook.getNumberOfSheets();
		  for(int i=0;i<sheets;i++) {
		  if(workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				// Identify Testcases column by scanning entire 1st row
				
				Iterator<Row> row=sheet.iterator();// Sheet is collection of rows
				Row firstRow =row.next();// this is for first row
				Iterator<Cell> cell=firstRow.cellIterator();// this is for cell iteration for that perticilar Row..//row is collection of cells
				//cell.next();
				int k=0;
				int column = 0;
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						
						//Desired column
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				
				//Once Column is identified then scan entire testcase column to identify purchase testcase row
				
				while(row.hasNext()) {
					
					Row r=row.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) 
					{
					 //After you grabbed purchase testcase Row= pull all the data of that row and feed into the test
						 Iterator<Cell> cv=r.cellIterator();
						 while(cv.hasNext()) {
							 
							 Cell c=cv.next();
							 if( c.getCellType()==CellType.STRING) // getting datatype of cell 
							 {
								 arraylist.add(c.getStringCellValue());
							 }
							 else {
								 
								 arraylist.add(NumberToTextConverter.toText(c.getNumericCellValue()));// integer to String
							 }
							//System.out.println(cv.next().getStringCellValue());
							//arraylist.add(cv.next().getStringCellValue());
							//System.out.println("arraylist"+arraylist);

						}
					}
				}
			}
		}
		return arraylist;		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		}


	
	
}
