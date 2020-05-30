import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class TransactionPage {
//index	1
//package	com.backbase.retail.neoUATMob
//class	android.widget.RelativeLayout
//text
//resource-id	com.backbase.retail.neoUATMob:id/cardView
ScreenShot screenshot=new ScreenShot();
ExReporter exReporter=new ExReporter();
InternationaTransfers IT=new InternationaTransfers();
    public void clickAllpayments(AndroidDriver driver,String Fromaccount,String Currency) throws IOException, InterruptedException {
       // AccountOverview.getAccbalance(driver,Fromaccount);
        AccountOverview.AccountClick(driver, Fromaccount).click();
       Thread.sleep(6000);
        MobileElement Allpayments=(MobileElement)driver.findElementById("com.backbase.retail.neoUATMob:id/displayFilterName");
        Allpayments.click();
        Thread.sleep(2000);
        //ScreenShot.screenShot(driver,"D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
        MobileElement Pendingpayments=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Pending Payments' and @resource-id='com.backbase.retail.neoUATMob:id/filterOption']");
        Pendingpayments.click();
        Thread.sleep(2000);
        MobileElement getFirstTransaction=(MobileElement)driver.findElementByXPath("//android.widget.RelativeLayout[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/cardView']");
        getFirstTransaction.click();
        Thread.sleep(1000);
        MobileElement ToAccountHoldername=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]");
        ToAccountHoldername.getText();
        ScreenShot.screenShot(driver,"D:\\Automation screenshots\\TransactionPage'" + ScreenShot.c++ + "'.png");
        MobileElement DebitAmount=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[2]");
        DebitAmount.getText();
        MobileElement Description=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Description']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Description.getText();
        MobileElement Transaction_date=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Transaction date']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Transaction_date.getText();
        MobileElement Value_date=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Value date']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Value_date.getText();
        MobileElement Reference=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Reference']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
        Reference.getText();
        if (Currency.equals(Fromaccount)){
         MobileElement Instructed_amount=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Instructed amount']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
         Instructed_amount.getText();
         exReporter.writeTransactionDetails(ToAccountHoldername.getText(),DebitAmount.getText(),Description.getText(),Transaction_date.getText(),Value_date.getText(),Reference.getText(),Instructed_amount.getText(),"-");
        }else {
         MobileElement Exchange_rate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Exchange rate']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
         Exchange_rate.getText();
         MobileElement Instructed_amount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Instructed amount']/following-sibling::android.widget.TextView[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/value']");
         Instructed_amount.getText();
         exReporter.writeTransactionDetails(ToAccountHoldername.getText(),DebitAmount.getText(),Description.getText(),Transaction_date.getText(),Value_date.getText(),Reference.getText(),Instructed_amount.getText(),Exchange_rate.getText());
        }
        //Instructed amount
IT.back_button(driver);
        IT.back_button(driver);
        IT.back_button(driver);
        //exReporter.writeTransactionDetails(ToAccountHoldername,DebitAmount,Description,Transaction_date,Value_date,Reference.getText(),);

    }


}
