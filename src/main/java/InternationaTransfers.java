import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class InternationaTransfers {
public static ScreenShot scrshot=new ScreenShot();
    public static Assertions assertions=new Assertions();
public static ExReporter ex=new ExReporter();
   public static Logger logger = Logger.getLogger("rootLogger");
    public  static String FromAccountNumber,BeneficiaryName,BeneficiaryAccount,ipdebitamount,iptransferamount1,iptransferamount2,ipequivalentamount,ipbeneficiaryname,ipbeneacc,iptotdebitamount,ipexcrate,ipremittance_fee,ipcorr_fee,ipvatamount;
public static Double debitamount,beforebalnce,afterbalance,deviation;
   public static String status;
    public static MobileElement Paymenttab(AndroidDriver driver){
MobileElement payment_tab=(MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Payments\"]/android.widget.ImageView");
    return payment_tab;
    }
    public static MobileElement international_transfer_button(AndroidDriver driver){
        MobileElement international_transfer_button=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]");
        return international_transfer_button;
    }

public static void beneficiary_details_screen(AndroidDriver driver) throws IOException, InterruptedException {


    Thread.sleep(2000);
    try {
        {

            MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            BeneficiaryName=el1.getText();
            el1.getText();
            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            BeneficiaryAccount=el2.getText();
            el2.getText();
            MobileElement BIC_SWIFT = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            BIC_SWIFT.getText();
            MobileElement Bankname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            MobileElement bankAddress = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            MobileElement bankAddress1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView");
            MobileElement CountryCode = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.TextView[2]");
            MobileElement Addressline1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            MobileElement Addressline2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            MobileElement BeneficiaryCountry = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
            ex.BeneficiaryWrite(BeneficiaryName,BeneficiaryAccount,BIC_SWIFT.getText(),Bankname.getText(),bankAddress.getText(),bankAddress1.getText(),CountryCode.getText(),Addressline1.getText(),Addressline2.getText(),BeneficiaryCountry.getText());
            System.out.println("*********************BENEFICIARY SCREEN DETAILS ARE CAPTURED************************");
            ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
        }
    }catch (Exception ex){
        System.out.println(ex);
    }


}

public static void Review_payment_Screen(AndroidDriver driver,String charge,String Currency) throws IOException, InterruptedException {
    //ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.r+++"'.png");
    ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
    Thread.sleep(2000);
    MobileElement el23 = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
    el23.click();
    ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
    MobileElement TransferAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
    String ta= Currency.concat(" "+iptransferamount1);
logger.info("Review payment validation started : ");
    assertions.Assertions(ta,TransferAmount.getText() );

    MobileElement Equi_amount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]");
int lenth=Equi_amount.getText().length();
    assertions.Assertions(ipequivalentamount, Equi_amount.getText().substring(4,lenth));
    MobileElement bene_name = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]");
    assertions.Assertions(BeneficiaryName,bene_name.getText() );
    MobileElement bene_acc_number = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[2]");
    assertions.Assertions(BeneficiaryAccount,bene_acc_number.getText().replaceAll("\\s+",""));
   // System.out.println(BeneficiaryAccount+" "+ bene_acc_number.getText());
    MobileElement totaldebit_amount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
    assertions.Assertions(ipdebitamount, totaldebit_amount.getText());
    MobileElement exchange_rate = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/exchangeRateValue");
    assertions.Assertions(ipexcrate, exchange_rate.getText());
    if(charge.equals("IPAC")) {
        MobileElement transfer_amount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
        assertions.Assertions(iptransferamount2, transfer_amount.getText());
        MobileElement remittance = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
        assertions.Assertions(ipremittance_fee, remittance.getText());
        MobileElement cbf = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
        assertions.Assertions(ipcorr_fee, cbf.getText());
        MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.TextView[2]");
        assertions.Assertions(ipvatamount, vat.getText());
    }
    else {
        MobileElement transfer_amount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
        assertions.Assertions(iptransferamount2, transfer_amount.getText());
        MobileElement remittance = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
        assertions.Assertions(ipremittance_fee, remittance.getText());
        MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
        assertions.Assertions(ipvatamount, vat.getText());

    }
}
public static void Samecurrency_review_screen(AndroidDriver driver,String charge,String Currency) throws IOException {

    MobileElement el1 = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
    el1.click();
    logger.info("Review payment validation started : ");
    ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
      MobileElement Transamount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
assertions.Assertions(iptransferamount2, Transamount.getText());
    MobileElement baneName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]");
assertions.Assertions(BeneficiaryName,baneName.getText());
    MobileElement BeneAcc = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]");
assertions.Assertions(BeneficiaryAccount,BeneAcc.getText().replaceAll("\\s+",""));
if(charge.equals("IPAC")) {
    MobileElement DEbitamount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
    assertions.Assertions(ipdebitamount, DEbitamount.getText());
    MobileElement Transferamount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    assertions.Assertions(iptransferamount2, Transferamount.getText());
    MobileElement remittancefee = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
    assertions.Assertions(ipremittance_fee, remittancefee.getText());
    MobileElement corresamount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
    assertions.Assertions(ipcorr_fee, corresamount.getText());
    MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]");
    assertions.Assertions(ipvatamount, vat.getText());
}
else {
    MobileElement DEbitamount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
    assertions.Assertions(ipdebitamount, DEbitamount.getText());
    MobileElement Transferamount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    assertions.Assertions(iptransferamount2, Transferamount.getText());
    MobileElement remittancefee = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
    assertions.Assertions(ipremittance_fee, remittancefee.getText());
    MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
    assertions.Assertions(ipvatamount, vat.getText());


}
}

    public static MobileElement getFromAccount(AndroidDriver driver) {
        MobileElement FromAccount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductAccountNumber");
        FromAccountNumber=FromAccount.getText();
        return FromAccount;
    }



    public static void chargesDetails(AndroidDriver driver,String FROM_ACCOUNT,String currency) throws InterruptedException, IOException {
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
        Thread.sleep(2000);
        MobileElement Amount=(MobileElement) driver.findElementByAccessibilityId("Amount");
        iptransferamount1=Amount.getText();
        InternationaTransfers.scrollToText(driver,"Continue");
        WebDriverWait wait=new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.backbase.retail.neoUATMob:id/showHideBreakdown")));
        MobileElement breakdown = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
        breakdown.click();
        Thread.sleep(1000);
        if(FROM_ACCOUNT.equals(currency)){
            Same_currency_charges(driver);
        }
        else {
            MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.EditText[@content-desc=\"Amount\"])[2]");
            ipequivalentamount=el1.getText();
            logger.info("Equivalent Amount :" + ipequivalentamount);

            MobileElement DebitAmount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
            ipdebitamount = DebitAmount.getText();
            logger.info("Debited Amount :" + DebitAmount.getText());

            MobileElement ER = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/exchangeRateValue");
            ipexcrate = ER.getText();
            logger.info("Exchange Rate : " + ER.getText());

            MobileElement TA = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            iptransferamount2 = TA.getText();
            logger.info("Transfer amount: " + TA.getText());
            InternationaTransfers.scrollToText(driver, "Continue");
            ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
            MobileElement remittance = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipremittance_fee = remittance.getText();
            logger.info("Remittance fees : " + remittance.getText());
            MobileElement correspondentcharge = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            ipcorr_fee = correspondentcharge.getText();
            logger.info("correspondent charges : " + correspondentcharge.getText());
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.TextView[2]");
            ipvatamount = vat.getText();
            logger.info("VAT : " + vat.getText());
        }

    }
    public static void Same_currency_charges(AndroidDriver driver) throws IOException, InterruptedException {

        MobileElement el1 = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
        ipdebitamount=el1.getText();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
        iptransferamount2=el2.getText();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
        ipremittance_fee=el3.getText();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
        ipcorr_fee=el4.getText();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]");
        ipvatamount=el5.getText();
        InternationaTransfers.scrollToText(driver, "Continue");

    }
    public static MobileElement Transfer_Currency(AndroidDriver driver){
        MobileElement Transfer_Currency=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/currencyText");
        return Transfer_Currency;
    }

    public static MobileElement AUD(AndroidDriver driver){
        MobileElement AUD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Australian Dollar (AUD)']");
        // ("//android.widget.TextView[@text='Australian Dollar (AUD)']")
                //findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
        return AUD;
    }
    public static MobileElement BHD(AndroidDriver driver){
        MobileElement BHD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Bahraini Dinar (BHD)']");
        return BHD;
    }


    public static MobileElement CAD(AndroidDriver driver){
        MobileElement CAD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Canadian Dollar (CAD)']");
        return CAD;
    }

    public static MobileElement EUR(AndroidDriver driver){
        MobileElement EUR=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Euro (EUR)']");
        return EUR;
    }
    public static MobileElement HKD(AndroidDriver driver){
        MobileElement HKD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Hong Kong Dollar (HKD)']");
        return HKD;
    }
    public static MobileElement JPY(AndroidDriver driver){
        MobileElement JPY=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Japanese Yen (JPY)']");
        return JPY;
    }
    public static MobileElement JOD(AndroidDriver driver){
        MobileElement JOD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Jordanian Dinar (JOD)']");
        return JOD;
    }
    public static MobileElement KWD(AndroidDriver driver){
        MobileElement KWD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Kuwaiti Dinar (KWD)']");
        return KWD;
    }
    public static MobileElement GBP(AndroidDriver driver){
        MobileElement GBP=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='British Pound (GBP)']");
        return GBP;
    }
    public static MobileElement OMR(AndroidDriver driver){
        MobileElement OMR=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Omani Rial (OMR)']");
        return OMR;
    }
    public static MobileElement SAR(AndroidDriver driver){
        MobileElement SAR=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Saudi Riyal (SAR)']");
        return SAR;
    }
    public static MobileElement SGD(AndroidDriver driver){
        MobileElement SGD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Singapore Dollar (SGD)']");
        return SGD;
    }
    public static MobileElement AED(AndroidDriver driver){
        MobileElement AED=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='United Arab Emirates Dirham (AED)']");
        return AED;
    }
    public static MobileElement USD(AndroidDriver driver){
        MobileElement USD=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='US Dollar (USD)']");
        return USD;
    }


    public static MobileElement Amount(AndroidDriver driver){
        MobileElement Amount=(MobileElement) driver.findElementByAccessibilityId("Amount");
        return Amount;
    }

    public  static void done_button1(AndroidDriver driver){
        TouchAction touchAction=new TouchAction(driver);
        //(new TouchAction(driver)).tap(935, 1926).perform();
        touchAction.tap(new PointOption().withCoordinates(1243, 1967)).perform();
    }
    public static MobileElement Chrges_dropdown_Same(AndroidDriver driver) throws InterruptedException {


        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");



        return el1;
    }
public static MobileElement Chrges_dropdown(AndroidDriver driver) throws InterruptedException {

//Thread.sleep(5000);

    MobileElement charge_dd=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");



    return charge_dd;
}

    public static void swipe1(AndroidDriver driver){
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(1019,  2416)).moveTo(PointOption.point(1019, 1998)).release().perform();
    }
    public static MobileElement continue1_button(AndroidDriver driver){
        MobileElement continue1_button=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        return continue1_button;
    }

    public static void bene_icon(AndroidDriver driver){
        TouchAction touchAction=new TouchAction(driver);
       // touchAction.tap(new PointOption().withCoordinates(659, 270)).perform(); //****j5
              touchAction.tap(new PointOption().withCoordinates(1317, 534)).perform();// **************s7
        //touchAction.tap(new PointOption().withCoordinates(972, 471)).perform();//huaweii
       // 972, 471


    }
    public static MobileElement chargedropText(AndroidDriver driver){
        MobileElement Chargesdrop=(MobileElement)driver.findElementByXPath("//android.widget.EditText[@text='I pay all charges' and @resource-id='com.backbase.retail.neoUATMob:id/edit_text']");
        return Chargesdrop;
    }
    public static void swipe2(AndroidDriver driver){
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(808, 1695)).moveTo(PointOption.point(802,1479)).release().perform();
    }
    public static MobileElement select_beneficiary(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.view.ViewGroup");

        MobileElement select_beneficiary=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.view.ViewGroup");
        //MobileElement select_beneficiary=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup");
        return select_beneficiary;
    }
    public static MobileElement continue2_button(AndroidDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,40);
        MobileElement continue2_button=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");

                return continue2_button;
    }
    public static MobileElement Transfer_purpose(AndroidDriver driver){

        MobileElement Transfer_purpose=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/edit_text");

        return Transfer_purpose;
    }

    public static MobileElement Transfer_purpose_reaseon(AndroidDriver driver){
        MobileElement Transfer_purpose_reaseon=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");

        return Transfer_purpose_reaseon;
    }
    public static MobileElement Additional_Details(AndroidDriver driver){
        MobileElement Additional_Details=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/etAdditonalDetails");
        return Additional_Details;
    }
    public static MobileElement continue3_button(AndroidDriver driver){
        MobileElement continue3_button=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        return continue3_button;
    }
    public void back_button(AndroidDriver driver) {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void confirmpay(AndroidDriver driver){
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));

    }

    public void swiping_till_end(AndroidDriver driver){
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(PointOption.point(931, 2430)).moveTo(PointOption.point(1008, 1278)).release().perform();
        touchAction.press(PointOption.point(952,  2444)).moveTo(PointOption.point(892, 1338)).release().perform();
        touchAction.press(PointOption.point(1145,  2269)).moveTo(PointOption.point(1159,1531)).release().perform();

    }
public void FinalScreen(AndroidDriver driver,String FROMACC,String currency,String charges) throws InterruptedException, IOException {
    MobileElement Payment_Status = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textStatus']");
    status = Payment_Status.getText();
    if (FROMACC.equals(currency)) {
        same_currency_final_screen(driver, currency, charges);
    }else{
    String Charges;
    if (charges.equals("IPAC")) {
        Charges = "I pay all charges";
    } else {
        Charges = "Beneficiary and i will share charges";
    }
    if (status.contains("Submitted")) {
        ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
        logger.info("Payment Status : " + status);
        MobileElement transferAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
        logger.info("Final screen  validation started : ");
        assertions.Assertions(currency.concat(" " + iptransferamount1), transferAmount.getText());
        MobileElement EquiAmount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]");
        assertions.Assertions(FROMACC.concat(" " + ipequivalentamount), EquiAmount.getText());
        MobileElement beneficiaryname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]");
        assertions.Assertions(BeneficiaryName, beneficiaryname.getText());
        MobileElement beneficiaryaccount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[2]");
        assertions.Assertions(BeneficiaryAccount, beneficiaryaccount.getText().replaceAll("\\s+", ""));
        MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        logger.info("Reference Number " + referenceNumber.getText());
        scrollToText(driver, "Show details");
        Thread.sleep(1000);
        MobileElement show_hide_button = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
        show_hide_button.click();
        Thread.sleep(1000);
        MobileElement totalAmount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
        assertions.Assertions(ipdebitamount, totalAmount.getText());
        scrollToText(driver, "Hide details");
        ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
        MobileElement exchangeRate = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/exchangeRateValue");
        assertions.Assertions(ipexcrate, exchangeRate.getText());
        if (charges.equals("IPAC")) {
            MobileElement ta = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            assertions.Assertions(iptransferamount2, ta.getText());
            MobileElement remitancefees = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            assertions.Assertions(ipremittance_fee, remitancefees.getText());
            MobileElement correspondancecharge = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            assertions.Assertions(ipcorr_fee, correspondancecharge.getText());
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.TextView[2]");
            assertions.Assertions(ipvatamount, vat.getText());
            ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
            ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, iptransferamount1, Charges, totalAmount.getText(), exchangeRate.getText(), correspondancecharge.getText(), remitancefees.getText(), vat.getText(), referenceNumber.getText(), status,"-");
        } else {
            MobileElement ta = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            assertions.Assertions(iptransferamount2, ta.getText());
            MobileElement remitancefees = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            assertions.Assertions(ipremittance_fee, remitancefees.getText());

            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            assertions.Assertions(ipvatamount, vat.getText());
            ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
            ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, transferAmount.getText(), Charges, totalAmount.getText(), exchangeRate.getText(), "-", remitancefees.getText(), vat.getText(), referenceNumber.getText(), status,"-");
        }
        MobileElement el2 = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
        el2.click();

    } else {
        logger.info("Payment Status : " + status);
        MobileElement reason = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textReason']");
        reason.getText();
        MobileElement TransferAmount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Name']//following-sibling::android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        MobileElement Bene_name = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Name']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        //MobileElement Bene_Acc=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Account Number / IBAN']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        back_button(driver);
        back_button(driver);
        ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, iptransferamount1, Charges, ipdebitamount, ipexcrate, ipcorr_fee, ipremittance_fee, ipvatamount, "-", status,reason.getText());
    }
}
}

public void same_currency_final_screen(AndroidDriver driver,String currency,String charges) throws IOException, InterruptedException {
    MobileElement Payment_Status = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textStatus']");
    status=Payment_Status.getText();
    String Charges;
    if (charges.equals("IPAC")) {
        Charges = "I pay all charges";
    } else {
        Charges = "Beneficiary and i will share charges";
    }
    if(status.contains("Submitted")) {
        ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
        logger.info("Payment Status : " + status);

        MobileElement TransferAmount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Name']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        MobileElement Bene_name = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Name']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        Bene_name.getText();
        MobileElement Bene_Acc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Account Number / IBAN']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        Bene_Acc.getText();
        MobileElement referenceNumber = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Reference number']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/labelValue']");
        logger.info("Reference Number " + referenceNumber.getText());
        MobileElement show_hide_button = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
        show_hide_button.click();
        Thread.sleep(1000);
        scrollToText(driver, "Hide details");
        ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");

        MobileElement totdebitamt = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
        totdebitamt.getText();
        assertions.Assertions(ipdebitamount, totdebitamt.getText());
        if (charges.contains("IPAC")) {
            MobileElement transferamt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            assertions.Assertions(iptransferamount2, transferamt.getText());
            //el5.click();
            MobileElement remi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            assertions.Assertions(ipremittance_fee, remi.getText());
            ;
            MobileElement corres = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            assertions.Assertions(ipcorr_fee, corres.getText());
            ;
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]");
            assertions.Assertions(ipvatamount, vat.getText());
            ;
            ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, transferamt.getText(), Charges, totdebitamt.getText(), "-", corres.getText(), remi.getText(), vat.getText(), referenceNumber.getText(), status, " - ");

        }
        else {
            MobileElement transferamt = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            assertions.Assertions(iptransferamount2, transferamt.getText());
            //el5.click();
            MobileElement remi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            assertions.Assertions(ipremittance_fee, remi.getText());
            ;
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            assertions.Assertions(ipvatamount, vat.getText());
            ;

            ;
            ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, transferamt.getText(), Charges, totdebitamt.getText(), "-", "-", remi.getText(), vat.getText(), referenceNumber.getText(), status, " - ");
        }
            MobileElement el2 = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/abc_btn_title");
            el2.click();

    }
    else {
        logger.info("Status of payment: " + status);
        MobileElement reason = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textReason']");
        reason.getText();
        back_button(driver);
        back_button(driver);
        ex.getdats(FromAccountNumber, BeneficiaryAccount, currency, iptransferamount1, Charges, ipdebitamount, "-", ipcorr_fee, ipremittance_fee, ipvatamount, "-", status,reason.getText());
        back_button(driver);
        back_button(driver);
    }

}

    public void perform_getTextFinal(AndroidDriver driver,String FROMACCOUNT,String currency) throws InterruptedException, IOException {
        MobileElement Payment_Status = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
        String status=Payment_Status.getText();
         ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
        logger.info("\n\nPayment Status: "+Payment_Status.getText()+"!!!");
        MobileElement getting_Amount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]");
        String Amount01= getting_Amount.getText();
        logger.info("Amount : "+getting_Amount.getText());
        MobileElement Fromacc = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[2]");
        String FromAccount=Fromacc.getText();
        logger.info("From Account : "+Fromacc.getText());
        MobileElement ToAcc = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView[2]");
        String ToAcoount=ToAcc.getText();
        logger.info("To Account : "+ToAcc.getText());
        Thread.sleep(1000);
if(status.contains("submitted"))
{
    scrollToText(driver,"Continue");
    Thread.sleep(2000);
     ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
}
else {
    scrollToText(driver, "Edit and resubmit");
    Thread.sleep(2000);
     ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
}
if(FROMACCOUNT.equals(currency)){
    MobileElement referrence_num = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=12]//android.widget.TextView[@index=2]");
    String ReferenceNumber=referrence_num.getText();
    logger.info("Reference Number : "+referrence_num.getText()+"\n\n");

    MobileElement charges = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=7]//android.widget.TextView[@index=2]");

    MobileElement fees = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=9]//android.widget.TextView[@index=2]");
    int len=ipremittance_fee.length();
    int feecalculation=Integer.parseInt(ipremittance_fee.substring(5,len)+ipcorr_fee);

    assertions.Assertions(fees.getText(),Integer.toString(feecalculation));
    MobileElement vat = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=10]//android.widget.TextView[@index=2]");
assertions.Assertions(ipvatamount,vat.getText());
    MobileElement debamount = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=11]//android.widget.TextView[@index=2]");
   assertions.Assertions(ipdebitamount,debamount.getText());
   // ex.getdats(status,Amount01,FromAccountNumber,BeneficiaryAccount,charges.getText(),"-","-",fees.getText(),
            //vat.getText(),debamount.getText(),referrence_num.getText());
}
else {
    MobileElement referrence_num = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=14]//android.widget.TextView[@index=2]");
    String ReferenceNumber = referrence_num.getText();
    logger.info("Reference Number : " + referrence_num.getText() + "\n\n");

    MobileElement charges = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=7]//android.widget.TextView[@index=2]");

    MobileElement exrate = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=9]//android.widget.TextView[@index=2]");
assertions.Assertions(ipexcrate,exrate.getText());
    MobileElement calculatedamount = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=10]//android.widget.TextView[@index=2]");
assertions.Assertions(ipequivalentamount,calculatedamount.getText());
    MobileElement fees = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=11]//android.widget.TextView[@index=2]");
    int len=ipremittance_fee.length();
    int feecalculation=Integer.parseInt(ipremittance_fee.substring(5,len)+ipcorr_fee);

    assertions.Assertions(fees.getText(),Integer.toString(feecalculation));
    MobileElement vat = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=12]//android.widget.TextView[@index=2]");
    assertions.Assertions(ipvatamount,vat.getText());
    MobileElement debamount = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index=13]//android.widget.TextView[@index=2]");
    assertions.Assertions(ipdebitamount,debamount.getText());
    // MobileElement referencenum = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.TextView[2]");
    //ex.getdats(status, Amount01, FromAccountNumber, BeneficiaryAccount, charges.getText(), exrate.getText(), calculatedamount.getText(), fees.getText(),
      //      vat.getText(), debamount.getText(), referrence_num.getText());
}
        if(status.contains("submitted"))
        {
            System.out.println("PASSED");
        }
        else {
            back_button(driver);
        }

//ex.getdats(status,FromAccount,ToAcoount,ReferenceNumber);
    }

public static void balance_validation(AndroidDriver driver,String before_bal,String after_balance) throws InterruptedException {
        //String DebitedAmount=ipdebitamount;
     debitamount=changetoint(ipdebitamount);
     beforebalnce=changetoint(before_bal);
     afterbalance=changetoint(after_balance);
     if(status.contains("Failed")){
         assertions.Balance_validation(beforebalnce,afterbalance);
         Double db=beforebalnce-afterbalance;
         ex.writeBalance(beforebalnce,afterbalance,db);
     }else {
         deviation = beforebalnce - debitamount;
         Double db = afterbalance - deviation;
         assertions.Balance_validation(deviation, afterbalance);
         ex.writeBalance(beforebalnce, afterbalance, db);
     }

}
public static Double changetoint(String STr){
    String bb=STr.substring(4,STr.length());
    String dummy=bb.replace(",","");
    Double c=Double.parseDouble(dummy);
    return c;
}
    public static void chargesDet(AndroidDriver driver,String fromacc,String curr) throws InterruptedException, IOException {
      //  ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
        Thread.sleep(2000);
       // InternationaTransfers.scrollToText(driver,"Continue");
        WebDriverWait wait=new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.backbase.retail.neoUATMob:id/showHideBreakdown")));
        MobileElement breakdown = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/showHideBreakdown");
        breakdown.click();
        MobileElement Amount=(MobileElement) driver.findElementByAccessibilityId("Amount");
        iptransferamount1=Amount.getText();
        Thread.sleep(1000);
        InternationaTransfers.scrollToText(driver,"Continue");
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'"+ScreenShot.c+++"'.png");
        MobileElement DebitAmount = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/totalAmount");
        ipdebitamount=DebitAmount.getText();
        logger.info("Debited Amount :"+DebitAmount.getText());
        if(fromacc.equals(curr)){
            MobileElement transammount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            iptransferamount2=transammount.getText();
            transammount.getText();
            MobileElement remittancefee = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipremittance_fee=remittancefee.getText();
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            ipvatamount=vat.getText();
        }
        else {
            MobileElement equi = (MobileElement) driver.findElementByXPath("(//android.widget.EditText[@content-desc=\"Amount\"])[2]");
            ipequivalentamount=equi.getText();
            MobileElement ER = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/exchangeRateValue");
            ipexcrate=ER.getText();
            MobileElement transferamount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
            iptransferamount2=transferamount.getText();
            MobileElement remi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
            ipremittance_fee=remi.getText();
            MobileElement vat = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
            ipvatamount=vat.getText();



        }

    }



    public MobileElement getBeneandme(AndroidDriver driver) {
        MobileElement  beneandme= (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        return beneandme;
    }

    public MobileElement getIpayallcharges(AndroidDriver driver) {
        MobileElement ipayallcharges = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        return ipayallcharges;
    }
MobileElement USDACC,GBPACC,SARACC,EURACC,AEDACC;

    public MobileElement getUSDACC(AndroidDriver driver) {
        USDACC = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductName");
        return USDACC;
    }

    public MobileElement getGBPACC(AndroidDriver driver) {
        GBPACC = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductName");
        return GBPACC;
    }

    public MobileElement getSARACC(AndroidDriver driver) {
        SARACC = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductName");
        return SARACC;
    }

    public MobileElement getEURACC(AndroidDriver driver) {
        EURACC = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductName");
        return EURACC;
    }

    public MobileElement getAEDACC(AndroidDriver driver) {
        AEDACC = (MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textProductName");
        return AEDACC;
    }





    public static  void select_transfer_currency(AndroidDriver driver, String currency) throws InterruptedException {
        String cur=currency;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        if ("AUD".equals(cur)) {
            AUD(driver).click();
        } else if ("BHD".equals(cur)) {
            BHD(driver).click();
        } else if ("EUR".equals(cur)) {
            EUR(driver).click();
        } else if ("JPY".equals(cur)) {
            JPY(driver).click();
        } else if ("CAD".equals(cur)) {
            CAD(driver).click();
        } else if ("HKD".equals(cur)) {
            HKD(driver).click();
        } else if ("JOD".equals(cur)) {
            JOD(driver).click();
        } else if ("SAR".equals(cur)) {
            //swipeTillText(driver, "US Dollar (USD)");
scrollToText(driver,"US Dollar (USD)");
Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(SAR(driver)));
            SAR(driver).click();
        } else if ("SGD".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            SGD(driver).click();
        } else if ("OMR".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            OMR(driver).click();
        } else if ("KWD".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            KWD(driver).click();
        } else if ("GBP".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            GBP(driver).click();
        } else if ("AED".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            AED(driver).click();
        } else if ("USD".equals(cur)) {
            scrollToText(driver,"US Dollar (USD)");
            Thread.sleep(1000);
            USD(driver).click();
        } else {
            logger.info("Select proper currency");
        }



    }




    public static void scrollToText(AndroidDriver<MobileElement> driver, String text) throws InterruptedException {
Thread.sleep(2000);
        MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
    }

    public static void scrollToTexting(AndroidDriver<MobileElement> driver, String text) throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().textContains(\"" + text + "\"));");
    }


}
