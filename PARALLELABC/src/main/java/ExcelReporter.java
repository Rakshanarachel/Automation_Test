import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReporter {
public  static String GetWorkbookName,SHEETNAME;
int dummynum1;
Double Before_Balance,Aftter_balance,deviation;
public void GeneralCreateSheet(String WorkbookName){
    String filename = "D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\"+WorkbookName+".xls";
    SHEETNAME=WorkbookName;
        try {

        GetWorkbookName=filename;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(WorkbookName);
        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setColor(IndexedColors.SEA_GREEN.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        // CellStyle backgroundStyle;

        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        headerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        //Row headerRow = sheet.createRow(0);

        HSSFRow headerRow = sheet.createRow((short) 0);
        headerRow.setRowStyle(headerCellStyle);
        headerRow.createCell(0).setCellValue("From Account");
        headerRow.createCell(1).setCellValue("To Account");
        headerRow.createCell(2).setCellValue("Currency");
        headerRow.createCell(3).setCellValue("Amount");
        headerRow.createCell(4).setCellValue("Exchange Rate");
        headerRow.createCell(5).setCellValue("Calculated Amount");
        headerRow.createCell(6).setCellValue("Fees");
        headerRow.createCell(7).setCellValue("Vat");
        headerRow.createCell(8).setCellValue("Debit Amount");
        headerRow.createCell(9).setCellValue("Reference Number");
        headerRow.createCell(10).setCellValue("Status");
        headerRow.createCell(11).setCellValue("Before Balance");
        headerRow.createCell(12).setCellValue("After Balance");
        headerRow.createCell(13).setCellValue("Deviation");
        for (int i = 0; i <= 13; i++) {
            headerRow.getCell(i).setCellStyle(headerCellStyle);
            // row.getCell(i).setCellStyle(cs);
            sheet.autoSizeColumn(i);
        }


        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Your excel file "+WorkbookName+" has been generated!");

    } catch (Exception ex) {
        System.out.println(ex);
    }
}
    public void Write_transfer(String FROMCC,String TOACC, String CURRENCY,String AMOUNT,String EXC_RATE,String CAL_AMOUNT,String FEES,String VAT,String DEB_AMOUNT,String REFERENCE,String status1) {
        String p_status;
        if (status1.contains("SUBMITTED")) {
            p_status = "Passed";
        } else {
            p_status = "Failed";
        }

        try {
            String excelFilePath = GetWorkbookName;
            //GetWorkbookName=excelFilePath;
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(SHEETNAME);

            int rownum,dummynum;
            rownum = sheet.getLastRowNum();
            dummynum=++rownum;
            dummynum1=dummynum;
            Row row = sheet.createRow((short) dummynum);
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);


            row.createCell(0).setCellValue(FROMCC);
            row.createCell(1).setCellValue(TOACC);
            row.createCell(2).setCellValue(CURRENCY);
            row.createCell(3).setCellValue(AMOUNT);
            row.createCell(4).setCellValue(EXC_RATE);
            row.createCell(5).setCellValue(CAL_AMOUNT);
            row.createCell(6).setCellValue(FEES);
            row.createCell(7).setCellValue(VAT);
            row.createCell(8).setCellValue(DEB_AMOUNT);
            row.createCell(9).setCellValue(REFERENCE);
            row.createCell(10).setCellValue(p_status);

            for (int i = 0; i <= 10; i++) {
                row.getCell(i).setCellStyle(cs);
                // row.getCell(i).setCellStyle(cs);
                sheet.autoSizeColumn(i);
            }


            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public  void Balance_write(Double Before_bal1, Double Afterbalance1,Double deviation1){

        Before_Balance=Before_bal1;
        Aftter_balance=Afterbalance1;
        deviation=deviation1;
        try {
            String excelFilePath = GetWorkbookName;
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(SHEETNAME);

            Row row = sheet.getRow(dummynum1);
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            row.createCell(11).setCellValue(Before_Balance);
            row.createCell(12).setCellValue(Aftter_balance);
            row.createCell(13).setCellValue(deviation);

            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel DATA has been written!");
        } catch (Exception ex) {

            System.out.println(ex);
        }
    }




}
