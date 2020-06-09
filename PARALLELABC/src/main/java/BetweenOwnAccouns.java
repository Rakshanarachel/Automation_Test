import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class BetweenOwnAccouns {
    Assertions assertions = new Assertions();
    ExReporter EX = new ExReporter();
    TransactionPage TP = new TransactionPage();
    public static Logger logger = Logger.getLogger("rootLogger");
    Methods methods = new Methods();
    String ipExchange_rate,RvDescription,ipDescription,before_bal,From_Account,CURRENCY,ipcal_amount,ipvat,ipfees,ipdeb_amount,iptransferamount,Rvexchange_rate,Rvcal_amount,Rvfees,Rvvat,Rvdeb_amount,Rvtransferamount,paymentstatus;
String BeneficiaryACCOUNT,BeneficiaryName;String To_Account_Number;

    public String RvSchedule;

    public void InputPage(AndroidDriver driver, String DEVICE,String FromAcc, String Toacc, String currency,String description) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")));
        MobileElement PaymentTab = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Payments\"]/android.widget.ImageView");
        PaymentTab.click();
        MobileElement BetweenOwnAccountsOption = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
        BetweenOwnAccountsOption.click();
        before_bal= Methods.AccountSelection(driver, FromAcc,DEVICE);
        Thread.sleep(1000);
        From_Account= Methods.getFromAccount(driver).getText();
        MobileElement TargetAccount=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Select target account']");
        TargetAccount.click();

        if(currency.toUpperCase().contains("DESTINATION")){
            CURRENCY=Toacc;
        }else {
            CURRENCY=FromAcc;
        }
        getBenificiary(driver,Toacc).click();
        MobileElement ToAccountNumber = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/sta_account_number");
        BeneficiaryACCOUNT=ToAccountNumber.getText();
        currency_selection(driver,FromAcc,Toacc,currency);
        MobileElement Amount = (MobileElement) driver.findElementByAccessibilityId("Amount");
        Amount.click();
        Amount.sendKeys("20");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(1194, 1961)).perform();
        iptransferamount=Amount.getText();
        Methods.back_button(driver);
        Thread.sleep(5000);
        MobileElement DESCRIPTION=(MobileElement)driver.findElementByXPath("//android.widget.EditText[@resource-id='com.backbase.retail.neoUATMob:id/textInputEditText' and @text='Description (optional)']");
        DESCRIPTION.sendKeys(description);
        ipDescription=DESCRIPTION.getText();
        //Methods.back_button(driver);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='Exchange rate']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']")));
        MobileElement Exchangerate=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='Exchange rate']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
       ipExchange_rate=Exchangerate.getText();
        MobileElement Calculated_Amount=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='Calculated amount']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        ipcal_amount=Calculated_Amount.getText();
        MobileElement VAT=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='VAT']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        ipvat=VAT.getText();
        MobileElement Fees=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='Fees']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        ipfees=Fees.getText();
        logger.info(String.valueOf(ipfees.charAt(4)));
        Assert.assertEquals(String.valueOf(ipfees.charAt(4)),"0");
        if(String.valueOf(ipfees.charAt(4)).equals("0")){
            Methods.back_button(driver);
        }
        Methods.scrollToText(driver,"Continue");
        MobileElement Debited_Amount=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/label' and @text='Debited amount']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        ipdeb_amount=Debited_Amount.getText();
        MobileElement Continue = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        Continue.click();

    }

    public void currency_selection(AndroidDriver driver,String FROMACC,String TOACC,String currency) throws InterruptedException {
        if(FROMACC.equals(TOACC)){
            System.out.println();
        }
        else {
            if(currency.toUpperCase().contains("DESTINATION")){
                MobileElement flag=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/countryFlag']");
                flag.click();
                Thread.sleep(1000);
                DestinationCurrency(driver);
            }else {
                System.out.println();
            }
        }

    }
public void DestinationCurrency(AndroidDriver driver){
    MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]");
    el1.click();
}


    public void ReviewPayment(AndroidDriver driver, String Fromacc, String Toacc, String currency) throws InterruptedException, IOException {
        Thread.sleep(3000);
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\BetweenAccount_transfer'"+ScreenShot.c+++"'.png");
        MobileElement amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/value' and @index=2]");
        Rvtransferamount = amount.getText();
        int len=Rvtransferamount.length();
        assertions.Assertions(CURRENCY.concat(" "+iptransferamount),Rvtransferamount);
        MobileElement Fromaccount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='From']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Fromaccount.getText().contains(From_Account);
        MobileElement beneficiary = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='To']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        beneficiary.getText().contains(BeneficiaryACCOUNT);

        MobileElement Description = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Description']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        RvDescription = Description.getText();
        assertions.Assertions(ipDescription,RvDescription);
        MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        RvSchedule = Schedule.getText();
        if(Fromacc.equals(Toacc)){
            Methods.scrollToText(driver, "Pay");
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvdeb_amount = Debited_amount.getText();
            assertions.Assertions(ipdeb_amount,Rvdeb_amount);
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvfees=FEES.getText();
            assertions.Assertions(ipfees,Rvfees);
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvvat=VAT.getText();
            assertions.Assertions(ipvat,Rvvat);

        }
        else {
            MobileElement Exchange_rate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Exchange rate']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvexchange_rate = Exchange_rate.getText();
            assertions.Assertions(ipExchange_rate,Rvexchange_rate);
            MobileElement Calculated_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Calculated amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvcal_amount = Calculated_amount.getText();
            assertions.Assertions(ipcal_amount,Rvcal_amount);
            Methods.scrollToText(driver, "Pay");
            Thread.sleep(1000);
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvfees=FEES.getText();
            assertions.Assertions(ipfees,Rvfees);
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvvat=VAT.getText();
            assertions.Assertions(ipvat,Rvvat);
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            Rvdeb_amount = Debited_amount.getText();
            assertions.Assertions(ipdeb_amount,Rvdeb_amount);
            ScreenShot.screenShot(driver, "D:\\Automation screenshots\\ila_transfer'" + ScreenShot.c++ + "'.png");

        }
        MobileElement Confirm = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        Confirm.click();
        // Methods.back_button(driver);
    }

    public void FinalScreen(AndroidDriver driver, String Fromacc, String Toacc, String currency) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView")));
        MobileElement payment_status = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
        paymentstatus = payment_status.getText();
        logger.info(paymentstatus);
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\BetweenAccount_transfer'"+ScreenShot.c+++"'.png");
        MobileElement amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        int len=amount.getText().length();
        assertions.Assertions(Rvtransferamount,amount.getText());
        logger.info(amount.getText());
        MobileElement Fromaccount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='From']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");

        logger.info(Fromaccount.getText());
        MobileElement beneficiary = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='To']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        beneficiary.click();
        logger.info(beneficiary.getText());
        MobileElement Description = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Description']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
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
            assertions.Assertions(Rvdeb_amount,Debited_amount.getText());
            logger.info(Debited_amount.getText());
            MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(RvSchedule,Schedule.getText());
            logger.info(Schedule.getText());
            MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            referenceNumber.getText();
            logger.info(referenceNumber.getText());

           // EX.Write_ilatransfer(,BeneficiaryACCOUNT,CURRENCY,amount.getText(),"-","-",FEES.getText(),VAT.getText(),Debited_amount.getText(),referenceNumber.getText(),payment_status.getText().toUpperCase());
        }else {
            if(paymentstatus.toUpperCase().contains("FAILED")){
                Methods.scrollToText(driver, "Edit and resubmit");
            }else {
                Methods.scrollToText(driver, "Continue");
            }
            MobileElement Exchange_rate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Exchange rate']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvexchange_rate,Exchange_rate.getText());
            logger.info(Exchange_rate.getText());
            MobileElement Schedule = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Schedule']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(RvSchedule,Schedule.getText());
            logger.info(Schedule.getText());
            MobileElement Calculated_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Calculated amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(iptransferamount,Calculated_amount.getText());
            logger.info(Calculated_amount.getText());
            MobileElement FEES = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Fees']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvfees,FEES.getText());
            MobileElement VAT = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='VAT']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvvat,VAT.getText());
            Thread.sleep(1000);
            ScreenShot.screenShot(driver, "D:\\Automation screenshots\\BetweenAccount_transfer'" + ScreenShot.c++ + "'.png");
            MobileElement Debited_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Debited amount']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            assertions.Assertions(Rvdeb_amount,Debited_amount.getText());
            logger.info(Debited_amount.getText());
            MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=2 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
            referenceNumber.getText();
            logger.info(referenceNumber.getText());
           // EX.Write_ilatransfer(From_Account,BeneficiaryACCOUNT,CURRENCY,amount.getText(),Exchange_rate.getText(),Calculated_amount.getText(),FEES.getText(),VAT.getText(),Debited_amount.getText(),referenceNumber.getText(),payment_status.getText().toUpperCase());
        }

        if(paymentstatus.toUpperCase().contains("FAILED")) {
            Methods.back_button(driver);
            Methods.back_button(driver);
        }
        else {   MobileElement Confirm = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
           // Confirm.click();
          //  Methods.back_button(driver);
        }}
    public MobileElement getBenificiary(AndroidDriver driver,String Acc) throws InterruptedException {
        logger.info(Acc+" ACCOUNT");
        Thread.sleep(2000);
        int i=0;
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/sta_account_name' and @index=1]")));
        MobileElement TOACC=(MobileElement)driver.findElementByXPath("//android.view.ViewGroup[@index=0]/android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/sta_account_name']");
       String K=TOACC.getText();
        //TOACC.click();
        while(!(K.contains(Acc))){
            try {
                i++;
                Thread.sleep(1000);
                MobileElement Element1=(MobileElement)driver.findElementByXPath("//android.view.ViewGroup[@index="+i+"]/android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/sta_account_name']");
                //MobileElement Element1=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textBalance");
                K=Element1.getText();
                TOACC=Element1;
                Thread.sleep(500);
            }catch (Exception E){
                System.out.println("Account doesn't exit with this user id");
            }

        }
return TOACC;
    }

    public void BetweenOwnACcount_Transfer(AndroidDriver driver,String DEVICE,String Fromacc,String Toacc,String currency,String description) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(InternationaTransfers.Paymenttab(driver)));
        InternationaTransfers.Paymenttab(driver).click();
        Thread.sleep(3000);
        InputPage(driver,DEVICE,Fromacc,Toacc,currency,description);
        ReviewPayment(driver,Fromacc,Toacc,currency);
        FinalScreen(driver,Fromacc,Toacc,currency);
        Thread.sleep(2000);



    }
}

