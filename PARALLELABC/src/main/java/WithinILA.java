import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WithinILA {
    String ipExchangerate, paymentstatus, ipcalAmount, ipfees,Rvfees,Rvvat,ipvat,iptransferamount, ipDescription, RvDescription, ipDebAmount, RvExchangeRate, Rvcalamount, Rvdebamount, RvtransferAmount, From_Account, To_Accoun, Rvpayment_type, RvSchedule;
    String BeneficiaryNAME,BeneficiaryACCOUNT,CURRENCY;
    Double debitamount,beforebalnce,afterbalance,deviation;
    String before_bal;
    Assertions assertions=new Assertions();
    ExReporter EX=new ExReporter();
    TransactionPage TP=new TransactionPage();
    public static Logger logger = Logger.getLogger("rootLogger");
    Methods methods=new Methods();
    public void input_PageILA(AndroidDriver driver,String DEVICE, String Fromacc, String Toacc, String currency,String PAYMENT_TYPE,String Amount_transfer,String description) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")));
        MobileElement IlaOption = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
        IlaOption.click();
        Thread.sleep(3000);
        if(currency.toUpperCase().contains("DESTINATION")){
            CURRENCY=Toacc;
        }else {
            CURRENCY=Fromacc;
        }
        before_bal= Methods.AccountSelection(driver, Fromacc,DEVICE);
        Thread.sleep(1000);
        From_Account= Methods.getFromAccount(driver).getText();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(1321, 1241)).perform();
        String s="Neo ";
        getBenificiary(driver,s.concat(Toacc));
        Thread.sleep(2000);
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\ila_transfer'"+ScreenShot.c+++"'.png");
        Payment_type_selection(driver, PAYMENT_TYPE);
        Thread.sleep(1000);
currency_selection(driver,Fromacc,Toacc,currency);
            MobileElement Amount = (MobileElement) driver.findElementByAccessibilityId("Amount");
            Amount.click();
            Amount.sendKeys(Amount_transfer);
            touchAction.tap(new PointOption().withCoordinates(1288, 1921)).perform();
            Thread.sleep(3000);
            iptransferamount=Amount.getText();

        BeneficiaryNAME=getBenename(driver).getText();
        BeneficiaryACCOUNT=getBeneAccount(driver).getText();

        MobileElement Description = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        Description.sendKeys(description);
        ipDescription=Description.getText();
        Methods.scrollToText(driver, "Continue");
        Thread.sleep(1000);
        if(Fromacc.equals(Toacc)){
            MobileElement fees = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
           ipfees=fees.getText();
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            ipvat=vat.getText();
            MobileElement debitAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipDebAmount=debitAmount.getText();

        }
        else {

            MobileElement ExchangeRate = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            ipExchangerate = ExchangeRate.getText();
            MobileElement calculatedAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipcalAmount = calculatedAmount.getText();
            MobileElement fees = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
           ipfees=fees.getText();
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipvat=vat.getText();
            MobileElement debitedAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            ipDebAmount = debitedAmount.getText();

        }
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\ila_transfer'"+ScreenShot.c+++"'.png");
        MobileElement Continuebutton = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        Continuebutton.click();
//Confirm and pay
    }
    public void DestinationCurrency(AndroidDriver driver) {
        MobileElement FlagSelect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]");
        FlagSelect.click();
    }

public void currency_selection(AndroidDriver driver,String FROMACC,String TOACC,String currency)throws InterruptedException{
        if(FROMACC.equals(TOACC)){
            System.out.println();
        }
        else {
            if(currency.toUpperCase().contains("DESTINATION")){
                MobileElement Flag = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/countryFlag']");
                Flag.click();
                Thread.sleep(2000);
                DestinationCurrency(driver);
            }else {
                System.out.println();
            }
        }

}

public void Payment_type_selection(AndroidDriver driver,String PAYMENT_TYPE) throws InterruptedException {
    if(PAYMENT_TYPE.toUpperCase().contains("SALARY")) {
        MobileElement SalaryPayment = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/radioSalary");
        SalaryPayment.click();
    }
    else {
        Thread.sleep(1000);
        MobileElement Personal_Payment = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/radioPersonal");
        Personal_Payment.click();
    }
}
    public void SourceCurrency(AndroidDriver driver) {
        MobileElement FlagSelect = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]");
        FlagSelect.click();
    }

    public void ReviewPayment(AndroidDriver driver, String Fromacc, String Toacc, String currency) throws InterruptedException, IOException {
Thread.sleep(2000);
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\ila_transfer'"+ScreenShot.c+++"'.png");
        MobileElement amount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[2]");
        RvtransferAmount = amount.getText();
        int len=RvtransferAmount.length();
        assertions.Assertions(CURRENCY.concat(" "+iptransferamount),RvtransferAmount);
        MobileElement Fromaccount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='From']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Fromaccount.getText().contains(From_Account);
        MobileElement beneficiary = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary details']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        beneficiary.getText().contains(BeneficiaryACCOUNT);

        MobileElement Payment_type = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Payment type']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Rvpayment_type = Payment_type.getText();
        //assertions.Assertions();
        MobileElement Description = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Description (optional)']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        RvDescription = Description.getText();
        assertions.Assertions(ipDescription,RvDescription);
        MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        RvSchedule = Schedule.getText();
        if(Fromacc.equals(Toacc)){
            Methods.scrollToText(driver, "Confirm and pay");
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvdebamount = Debited_amount.getText();
            assertions.Assertions(ipDebAmount,Rvdebamount);
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvfees=FEES.getText();
            assertions.Assertions(ipfees,Rvfees);
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvvat=VAT.getText();
            assertions.Assertions(ipvat,Rvvat);

        }
        else {
            MobileElement Exchange_rate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Exchange rate']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            RvExchangeRate = Exchange_rate.getText();
            assertions.Assertions(ipExchangerate,RvExchangeRate);
            MobileElement Calculated_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Calculated amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvcalamount = Calculated_amount.getText();
            assertions.Assertions(ipcalAmount,Rvcalamount);
            Methods.scrollToText(driver, "Confirm and pay");
            Thread.sleep(1000);
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvfees=FEES.getText();
            assertions.Assertions(ipfees,Rvfees);
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvvat=VAT.getText();
            assertions.Assertions(ipvat,Rvvat);
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvdebamount = Debited_amount.getText();
            assertions.Assertions(ipDebAmount,Rvdebamount);
             ScreenShot.screenShot(driver, "D:\\Automation screenshots\\ila_transfer'" + ScreenShot.c++ + "'.png");

        }
        MobileElement Confirm = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        Confirm.click();
       // Methods.back_button(driver);
    }

    public void FinalScreen(AndroidDriver driver, String Fromacc, String Toacc, String currency) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView")));
        MobileElement payment_status = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
        paymentstatus = payment_status.getText();
        logger.info(paymentstatus);
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\ila_transfer'"+ScreenShot.c+++"'.png");
        MobileElement amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        int len=amount.getText().length();
        assertions.Assertions(RvtransferAmount,amount.getText());
        logger.info(amount.getText());
        MobileElement Fromaccount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='From']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");

        logger.info(Fromaccount.getText());
        MobileElement beneficiary = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary details']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        beneficiary.click();
        logger.info(beneficiary.getText());
        MobileElement Payment_type = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Payment type']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Payment_type.getText();
        logger.info(Payment_type.getText());
        MobileElement Description = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Description (optional)']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Description.getText();
        assertions.Assertions(RvDescription,Description.getText());
        logger.info(Description.getText());

        if(Fromacc.equals(Toacc)){
            if(paymentstatus.toUpperCase().contains("FAILED")){
                Methods.scrollToText(driver, "Edit and resubmit");
            }else {
                Methods.scrollToText(driver, "Continue");

            }
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
           
            assertions.Assertions(Rvfees,FEES.getText());
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvvat,VAT.getText());
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Debited_amount.getText();
            assertions.Assertions(Rvdebamount,Debited_amount.getText());
            logger.info(Debited_amount.getText());
            MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(RvSchedule,Schedule.getText());
            logger.info(Schedule.getText());
            MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            referenceNumber.getText();
            logger.info(referenceNumber.getText());

            EX.Write_ilatransfer(From_Account,BeneficiaryACCOUNT,CURRENCY,amount.getText(),"-","-",FEES.getText(),VAT.getText(),Debited_amount.getText(),referenceNumber.getText(),payment_status.getText().toUpperCase());
        }else {
            if(paymentstatus.toUpperCase().contains("FAILED")){
                Methods.scrollToText(driver, "Edit and resubmit");
            }else {
                Methods.scrollToText(driver, "Continue");
            }
            MobileElement Exchange_rate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Exchange rate']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(RvExchangeRate,Exchange_rate.getText());
            logger.info(Exchange_rate.getText());
            MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(RvSchedule,Schedule.getText());
            logger.info(Schedule.getText());
            MobileElement Calculated_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Calculated amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(ipcalAmount,Calculated_amount.getText());
            logger.info(Calculated_amount.getText());
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
           assertions.Assertions(Rvfees,FEES.getText());
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvvat,VAT.getText());
            Thread.sleep(1000);
             ScreenShot.screenShot(driver, "D:\\Automation screenshots\\ila_transfer'" + ScreenShot.c++ + "'.png");
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvdebamount,Debited_amount.getText());
            logger.info(Debited_amount.getText());
            MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            referenceNumber.getText();
            logger.info(referenceNumber.getText());
            EX.Write_ilatransfer(From_Account,BeneficiaryACCOUNT,CURRENCY,amount.getText(),Exchange_rate.getText(),Calculated_amount.getText(),FEES.getText(),VAT.getText(),Debited_amount.getText(),referenceNumber.getText(),payment_status.getText().toUpperCase());
        }

        if(paymentstatus.toUpperCase().contains("FAILED")) {
            Methods.back_button(driver);
            Methods.back_button(driver);
        }
         else {   MobileElement Confirm = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        //Confirm.click();
        Methods.back_button(driver);
    }}
public MobileElement getBenename(AndroidDriver driver){
    MobileElement Beneficiary_name = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
    MobileElement Beneficiary_AccountNo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
return Beneficiary_name;
}
    public MobileElement getBeneAccount(AndroidDriver driver){
        MobileElement Beneficiary_AccountNo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        return Beneficiary_AccountNo;
    }
//, String Fromacc, String Toacc, String currency
    public void Withinila_Transfer(AndroidDriver driver,String DEVICE, String Fromacc, String Toacc, String currency,String PAYMENT_TYPE,String transfer_amount,String description) throws InterruptedException ,IOException{
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(InternationaTransfers.Paymenttab(driver)));
        InternationaTransfers.Paymenttab(driver).click();
        Thread.sleep(3000);
       input_PageILA(driver,DEVICE,Fromacc,Toacc,currency,PAYMENT_TYPE,transfer_amount,description);
       ReviewPayment(driver,Fromacc,Toacc,currency);
       Thread.sleep(1000);
       Methods.confirmpay(driver);
       FinalScreen(driver,Fromacc,Toacc,currency);
       Thread.sleep(1000);
        MobileElement OVERVIEW = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Overview\"]/android.widget.ImageView");
        OVERVIEW.click();
        Thread.sleep(5000);
        String After_Balance = AccountOverview.getAccbalance(driver, Fromacc,DEVICE);
        balance_validation(driver,before_bal,After_Balance);
        Thread.sleep(5000);
        TP.International_Transactionpage(driver,DEVICE,Fromacc,currency,"withinila");
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\ila_transfer'"+ScreenShot.c+++"'.png");
        Methods.back_button(driver);
        Thread.sleep(1000);
        Methods.back_button(driver);
        Thread.sleep(2000);
        Methods.back_button(driver);
        Thread.sleep(3000);


    }

    public  void balance_validation(AndroidDriver driver,String before_bal,String after_balance) throws InterruptedException {

        debitamount= Methods.changetoint(ipDebAmount);
        beforebalnce= Methods.changetoint(before_bal);
        afterbalance= Methods.changetoint(after_balance);
        if(paymentstatus.contains("Failed")){
            assertions.Balance_validation(beforebalnce,afterbalance);
            Double db=beforebalnce-afterbalance;
            EX.ila_Balance_write(beforebalnce,afterbalance,db);
        }else {
            deviation = beforebalnce - debitamount;
            Double db = afterbalance - deviation;
            assertions.Balance_validation(deviation, afterbalance);
            EX.ila_Balance_write(beforebalnce, afterbalance, db);
        }

    }
    public void getBenificiary(AndroidDriver driver,String Acc) throws InterruptedException {
        logger.info(Acc+"ACCOUNT");
        Methods.scrollToText(driver,Acc);
        Thread.sleep(1000);
        MobileElement BENE=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='"+Acc+"' and @resource-id='com.backbase.retail.neoUATMob:id/textCellTitle']");
        BENE.click();
    }
}