import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TransactionPage {
ScreenShot screenshot=new ScreenShot();
ExReporter exReporter=new ExReporter();
InternationaTransfers IT=new InternationaTransfers();
    public void International_Transactionpage(AndroidDriver driver, String DEVICE,String Fromaccount, String Currency,String Name) throws IOException, InterruptedException {
     WebDriverWait wait = new WebDriverWait(driver, 50);

      AccountOverview.AccountClick(driver, Fromaccount,DEVICE).click();

       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.backbase.retail.neoUATMob:id/displayFilterName")));
        MobileElement Allpayments=(MobileElement)driver.findElementById("com.backbase.retail.neoUATMob:id/displayFilterName");
        Allpayments.click();
        Thread.sleep(2000);
     getTransferName(driver,Name);
        Thread.sleep(2000);
        MobileElement getFirstTransaction=(MobileElement)driver.findElementByXPath("//android.widget.RelativeLayout[@index=1 and @resource-id='com.backbase.retail.neoUATMob:id/cardView']");
        getFirstTransaction.click();
        Thread.sleep(1000);
        MobileElement ToAccountHoldername=(MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]");
        ToAccountHoldername.getText();

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
      

    }

    public  void getTransferName(AndroidDriver driver,String Name){
     if(Name.toUpperCase().contains("WITHINILA")){
      MobileElement debits=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Debits' and @resource-id='com.backbase.retail.neoUATMob:id/filterOption']");
      debits.click();
     }
     else if(Name.toUpperCase().contains("INTERNATIONAL")){
      MobileElement Pendingpayments=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Pending Payments' and @resource-id='com.backbase.retail.neoUATMob:id/filterOption']");
      Pendingpayments.click();
     }
     else {
      System.out.println(" NAME REQUIRED");
     }

    }


}
