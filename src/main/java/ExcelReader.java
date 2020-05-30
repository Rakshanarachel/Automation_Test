import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.*;

public class ExcelReader {


    public void Testrun(String fromacc, String currency,String charges) {
        System.out.println(fromacc+" FromAcc" +"\t"+currency+" currency"+"\t"+" charges");

    }
    @DataProvider(name="ExecutionData")
    public Object[][] ExecutionData() {
        Object[][] arrayObject = getExcelData("D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\Book1.xls","Sheet1");
        return arrayObject;
    }

    public String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream inputStream = new FileInputStream(new File(fileName));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook wb = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sh = wb.getSheet(sheetName);



            int totalNoOfCols = sh.getRow(0).getLastCellNum();
            int totalNoOfRows = sh.getLastRowNum();

            arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

            for (int i = 1; i < totalNoOfRows; i++) {

                for (int j = 0; j < totalNoOfCols; j++) {
                    arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
}