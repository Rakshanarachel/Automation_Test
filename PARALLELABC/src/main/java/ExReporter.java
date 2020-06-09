import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExReporter {

    String Status,Fromaccount, Amount1,Amount2 ,currency, Toacc,  tot_debamount, corres_fees, exchangerate, remi_fees, vat, Referencenum,charges;
    Double Before_Balance,Aftter_balance,deviation;
    public static String GetWorkbookName;
    int dummynum1;
    // InternationaTransfers inter=new InternationaTransfers();
    public void getdats(String Fromaccounts1, String Toaccs2, String currency1,String Amount1s3, String chargess4, String tot_debamount1, String exchangerate1, String corres_fees1, String remi_fees1, String vat1, String referencenum1,String status1,String REJECTREASON) {
        Fromaccount = Fromaccounts1;
        Toacc = Toaccs2;
        currency=currency1;
        Amount1= Amount1s3;
        charges = chargess4;
        tot_debamount = tot_debamount1;
        exchangerate = exchangerate1;
        corres_fees = corres_fees1;
        remi_fees = remi_fees1;
        vat = vat1;
        Referencenum=referencenum1;
        //Status=status1;

        if (status1.contains("Submitted")) {
            Status = "Passed";
        } else {
            Status = "Failed";
        }
        try {
            String excelFilePath = "D:\\testdatasss\\PARALLELABC\\src\\main\\Sheets\\International_Transfer_Report.xls";
            GetWorkbookName=excelFilePath;
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("International_Transfer_Result");

            int rownum,dummynum;
            rownum = sheet.getLastRowNum();
            dummynum=++rownum;
            dummynum1=dummynum;
            Row row = sheet.createRow((short) dummynum);
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            row.createCell(0).setCellValue(Fromaccount);
            row.createCell(1).setCellValue(Toacc);
            row.createCell(2).setCellValue(currency);
            row.createCell(3).setCellValue(Amount1);
            row.createCell(4).setCellValue(charges);
            row.createCell(5).setCellValue(tot_debamount);
            row.createCell(6).setCellValue(exchangerate);
            row.createCell(7).setCellValue(corres_fees);
            row.createCell(8).setCellValue(remi_fees);
            row.createCell(9).setCellValue(vat);
            row.createCell(10).setCellValue(Referencenum);
            row.createCell(11).setCellValue(Status);
            row.createCell(12).setCellValue(REJECTREASON);

            //row.createCell(14).setCellValue(Status);
            for (int i = 0; i <= 12; i++) {
                // headerRow.getCell(i).setCellStyle(headerCellStyle);
                row.getCell(i).setCellStyle(cs);
                sheet.autoSizeColumn(i);
            }
            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel DATA has been written!");
        } catch (Exception ex) {

            System.out.println(ex);
            ex.printStackTrace();
            System.err.println(ex);

        }
    }
public  void writeBalance(Double Before_bal1, Double Afterbalance1,Double deviation1){

    Before_Balance=Before_bal1;
    Aftter_balance=Afterbalance1;
    deviation=deviation1;
    try {
        String excelFilePath = "D:\\testdatasss\\PARALLELABC\\src\\main\\Sheets\\International_Transfer_Report.xls";
        //String excelFilePath = "\\ExecutionReport.xls";
        //HSSFWorkbook workbook = new HSSFWorkbook();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        BufferedInputStream BIS=new BufferedInputStream(inputStream);
        Workbook workbook = WorkbookFactory.create(BIS);
        // Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("International_Transfer_Result");

        Row row = sheet.getRow(dummynum1);
        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        row.createCell(13).setCellValue(Before_Balance);
        row.createCell(14).setCellValue(Aftter_balance);
        row.createCell(15).setCellValue(deviation);

        FileOutputStream fileOut = new FileOutputStream(excelFilePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Your excel DATA has been written!");
    } catch (Exception ex) {

        System.out.println(ex);
    }
}
public void BeneficiaryWrite(String bname,String bacc,String BIC_SWIFT,String BANKNAME,String BANKADD,String BANKADD1,String COUNTRYCODE,String ADDRESSLINE1,String ADDRESSLINE2,String BENECOUNTRY){
    try {
        String excelFilePath = "D:\\testdatasss\\PARALLELABC\\src\\main\\Sheets\\International_Transfer_Report.xls";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        BufferedInputStream BIS=new BufferedInputStream(inputStream);
        Workbook workbook = WorkbookFactory.create(BIS);
        // Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Beneficiary Details");

        int rownum,dummynum;
        rownum = sheet.getLastRowNum();
        dummynum=++rownum;
        //dummynum1=dummynum;
        Row row = sheet.createRow((short) dummynum);
        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        row.createCell(0).setCellValue(bname);
        row.createCell(1).setCellValue(bacc);
        row.createCell(2).setCellValue(BIC_SWIFT);
        row.createCell(3).setCellValue(BANKNAME);
        row.createCell(4).setCellValue(BANKADD);
        row.createCell(5).setCellValue(BANKADD1);
        row.createCell(6).setCellValue(COUNTRYCODE);
        row.createCell(7).setCellValue(ADDRESSLINE1);
        row.createCell(8).setCellValue(ADDRESSLINE2);
        row.createCell(9).setCellValue(BENECOUNTRY);


        //row.createCell(14).setCellValue(Status);
        for (int i = 0; i <= 9; i++) {
            // headerRow.getCell(i).setCellStyle(headerCellStyle);
            row.getCell(i).setCellStyle(cs);
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream(excelFilePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Your excel Beneficiary DATA has been written!");
    } catch (Exception ex) {

        System.out.println(ex);
        ex.printStackTrace();
        System.err.println(ex);

    }
}
public void createSheet_Beneficiary(){

    try {
        String excelFilePath = "D:\\testdatasss\\PARALLELABC\\src\\main\\Sheets\\International_Transfer_Report.xls";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        BufferedInputStream BIS=new BufferedInputStream(inputStream);
        Workbook workbook = WorkbookFactory.create(BIS);
        // Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.createSheet("Beneficiary Details");
        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        // CellStyle backgroundStyle;

        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillBackgroundColor(IndexedColors.GOLD.getIndex());
        //Row headerRow = sheet.createRow(0);

        HSSFRow headerRow = (HSSFRow) sheet.createRow((short) 0);
        headerRow.setRowStyle(headerCellStyle);
        headerRow.createCell(0).setCellValue("Beneficiary Name");
        headerRow.createCell(1).setCellValue("Beneficiary Account");
        headerRow.createCell(2).setCellValue("BIC_SWIFT");
        headerRow.createCell(3).setCellValue("Bank Name");
        headerRow.createCell(4).setCellValue("Bank Address");
        headerRow.createCell(5).setCellValue("Bank Address1");
        //headerRow.createCell(6).setCellValue("Exchange Rate");
        // headerRow.createCell(6).setCellValue("Transfer Amount");
        headerRow.createCell(6).setCellValue("Country Code");
        headerRow.createCell(7).setCellValue("Address line1");
        headerRow.createCell(8).setCellValue("Address line2");
        headerRow.createCell(9).setCellValue("Beneficiary Country");
        //row.createCell(14).setCellValue(Status);
        for (int i = 0; i <= 9; i++) {
            // headerRow.getCell(i).setCellStyle(headerCellStyle);
            headerRow.getCell(i).setCellStyle(headerCellStyle);
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream(excelFilePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Your excel Beneficiary Sheet has been created!");
    } catch (Exception ex) {

        System.out.println(ex);
        ex.printStackTrace();
        System.err.println(ex);

    }
}
public String Getworkbookname(String NAME){
        String workbookname=NAME;
        return workbookname;
}

    public void createSheet_TransactionPage(){

        try {
            String excelFilePath = GetWorkbookName;

            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.createSheet("Transaction Details");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setFillBackgroundColor(IndexedColors.GOLD.getIndex());
            HSSFRow headerRow = (HSSFRow) sheet.createRow((short) 0);
            headerRow.setRowStyle(headerCellStyle);
            headerRow.createCell(0).setCellValue("To Account Holder Name");
            headerRow.createCell(1).setCellValue("Amount");
            headerRow.createCell(2).setCellValue("Description");
            headerRow.createCell(3).setCellValue("Transaction_date");
            headerRow.createCell(4).setCellValue("Value_date");
            headerRow.createCell(5).setCellValue("Reference");
            headerRow.createCell(6).setCellValue("Instructed_amount");
            headerRow.createCell(7).setCellValue("Exchange_rate");

            for (int i = 0; i <= 7; i++) {

                headerRow.getCell(i).setCellStyle(headerCellStyle);
                sheet.autoSizeColumn(i);
            }
            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel Transaction details Sheet has been created!");
            GetWorkbookName=Getworkbookname(excelFilePath);
        } catch (Exception ex) {

            System.out.println(ex);
            ex.printStackTrace();
            System.err.println(ex);

        }

    }
    public void writeTransactionDetails(String Toaccount,String AMOUNT,String DESCRIPTION,String TRANSACTION_DATE,String VALUE_DATE,String REFERENCE,String IN_AMOUNT,String EXC_RATE){

        try {
            String excelFilePath = GetWorkbookName;
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("Transaction Details");

            int rownum,dummynum;
            rownum = sheet.getLastRowNum();
            dummynum=++rownum;
            //dummynum1=dummynum;
            Row row = sheet.createRow((short) dummynum);
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            row.createCell(0).setCellValue(Toaccount);
            row.createCell(1).setCellValue(AMOUNT);
            row.createCell(2).setCellValue(DESCRIPTION);
            row.createCell(3).setCellValue(TRANSACTION_DATE);
            row.createCell(4).setCellValue(VALUE_DATE);
            row.createCell(5).setCellValue(REFERENCE);
            row.createCell(6).setCellValue(IN_AMOUNT);
            row.createCell(7).setCellValue(EXC_RATE);
            for (int i = 0; i <= 7; i++) {
                // headerRow.getCell(i).setCellStyle(headerCellStyle);
                row.getCell(i).setCellStyle(cs);
                sheet.autoSizeColumn(i);
            }
            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel Transaction DATA has been written!");
        } catch (Exception ex) {

            System.out.println(ex);
            ex.printStackTrace();
            System.err.println(ex);

        }

    }
    public void createsheet() {


        try {
            String filename = "D:\\testdatasss\\PARALLELABC\\src\\main\\Sheets\\International_Transfer_Report.xls";
            GetWorkbookName=filename;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("International_Transfer_Result");
            Font headerFont = workbook.createFont();

            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            headerFont.setColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
           // CellStyle backgroundStyle;

            headerCellStyle.setFont(headerFont);
            headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            //Row headerRow = sheet.createRow(0);

            HSSFRow headerRow = sheet.createRow((short) 0);
            headerRow.setRowStyle(headerCellStyle);
            headerRow.createCell(0).setCellValue("From Account");
            headerRow.createCell(1).setCellValue("To Account");
            headerRow.createCell(2).setCellValue("Currency");
            headerRow.createCell(3).setCellValue("Amount");
            headerRow.createCell(4).setCellValue("Charges");
            headerRow.createCell(5).setCellValue("Debited Amount");
            headerRow.createCell(6).setCellValue("Exchange Rate");
           // headerRow.createCell(6).setCellValue("Transfer Amount");
            headerRow.createCell(7).setCellValue("Correspondent Fees");
            headerRow.createCell(8).setCellValue("Remittance Fees");
            headerRow.createCell(9).setCellValue("Vat");
            headerRow.createCell(10).setCellValue("Reference Number");
            headerRow.createCell(11).setCellValue("Status");
            headerRow.createCell(12).setCellValue("Reject Reason");
            headerRow.createCell(13).setCellValue("Before Balance");
            headerRow.createCell(14).setCellValue("After Balance");
            headerRow.createCell(15).setCellValue("Deviation");
            for (int i = 0; i <= 15; i++) {
                headerRow.getCell(i).setCellStyle(headerCellStyle);
                // row.getCell(i).setCellStyle(cs);
                sheet.autoSizeColumn(i);
            }


            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void createsheet_ilatransfer() {
        String filename = "D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\WithinILA_Transfer_Report.xls";

        try {

GetWorkbookName=filename;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("WithinILA_Transfer");
            Font headerFont = workbook.createFont();

            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            headerFont.setColor(IndexedColors.LAVENDER.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            // CellStyle backgroundStyle;

            headerCellStyle.setFont(headerFont);
            headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
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
            System.out.println("Your excel file WithinILA_Transfer_Report has been generated!");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void Write_ilatransfer(String FROMCC,String TOACC, String CURRENCY,String AMOUNT,String EXC_RATE,String CAL_AMOUNT,String FEES,String VAT,String DEB_AMOUNT,String REFERENCE,String status1) {
        String p_status;
        if (status1.contains("SUBMITTED")) {
            p_status = "Passed";
        } else {
            p_status = "Failed";
        }

        try {
            String excelFilePath = "D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\WithinILA_Transfer_Report.xls";
            GetWorkbookName=excelFilePath;
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("WithinILA_Transfer");

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
    public  void ila_Balance_write(Double Before_bal1, Double Afterbalance1,Double deviation1){

        Before_Balance=Before_bal1;
        Aftter_balance=Afterbalance1;
        deviation=deviation1;
        try {
            String excelFilePath = "D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\WithinILA_Transfer_Report.xls";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            BufferedInputStream BIS=new BufferedInputStream(inputStream);
            Workbook workbook = WorkbookFactory.create(BIS);
            // Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("WithinILA_Transfer");

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