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

public class Methods {
    public static InternationaTransfers it = new InternationaTransfers();
public static ScreenShot scrshot=new ScreenShot();
static TransactionPage TP=new TransactionPage();
static BeneficiaryInternationaltransfer beneficiary=new BeneficiaryInternationaltransfer();
    public static void International_Transfer(AndroidDriver driver,String FROM_ACCOUNT,String currency,String charges) throws InterruptedException, IOException {
if(FROM_ACCOUNT.contains("L")){
    executeScheduler(driver);
}else {
    WebDriverWait wait = new WebDriverWait(driver, 100);
    wait.until(ExpectedConditions.elementToBeClickable(InternationaTransfers.Paymenttab(driver)));
    InternationaTransfers.Paymenttab(driver).click();
    Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOf(InternationaTransfers.international_transfer_button(driver)));
    InternationaTransfers.international_transfer_button(driver).click();
    Thread.sleep(3000);
    String before_Balance = AccountSelection(driver, FROM_ACCOUNT);
    Thread.sleep(1000);
    InternationaTransfers.getFromAccount(driver);
    InternationaTransfers.Transfer_Currency(driver).click();
    //InternationaTransfers.Transfer_Currency(driver).click();
    Thread.sleep(2000);
    InternationaTransfers.select_transfer_currency(driver, currency);
    Thread.sleep(1000);
    InternationaTransfers.Amount(driver).click();
    InternationaTransfers.Amount(driver).sendKeys("10");
    ScreenShot.screenShot(driver, "D:\\Automation screenshots\\InternationalTransfer'" + ScreenShot.c++ + "'.png");
    Thread.sleep(500);
    it.done_button1(driver);
    //it.back_button(driver);
    Thread.sleep(6000);
    if (charges.equals("IPAC")) {
        InternationaTransfers.chargesDetails(driver, FROM_ACCOUNT, currency);
    } else {
        if (FROM_ACCOUNT.equals(currency)) {
            wait.until(ExpectedConditions.visibilityOf(InternationaTransfers.Chrges_dropdown_Same(driver)));
            InternationaTransfers.Chrges_dropdown_Same(driver).click();
            Thread.sleep(2000);
            it.getBeneandme(driver).click();
            Thread.sleep(4000);
            InternationaTransfers.chargesDet(driver, FROM_ACCOUNT, currency);
            Thread.sleep(2000);
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")));
            InternationaTransfers.Chrges_dropdown(driver).click();
            Thread.sleep(2000);
            it.getBeneandme(driver).click();
            Thread.sleep(4000);
            InternationaTransfers.chargesDet(driver, FROM_ACCOUNT, currency);
            Thread.sleep(2000);
        }
    }
    Thread.sleep(2000);
    InternationaTransfers.continue1_button(driver).click();
    Thread.sleep(5000);
    beneficiary.FillBeneficiaryDetails(driver);
    InternationaTransfers.beneficiary_details_screen(driver);
    InternationaTransfers.continue2_button(driver).click();
    Thread.sleep(1000);
    InternationaTransfers.Transfer_purpose(driver).click();
    Thread.sleep(1000);
    InternationaTransfers.Transfer_purpose_reaseon(driver).click();
    Thread.sleep(1000);
    InternationaTransfers.Additional_Details(driver).click();
    InternationaTransfers.Additional_Details(driver).sendKeys("Test");
    Thread.sleep(500);
    it.back_button(driver);
    Thread.sleep(1000);
    InternationaTransfers.continue3_button(driver).click();
    Thread.sleep(1000);
    if (FROM_ACCOUNT.equals(currency)) {
        InternationaTransfers.Samecurrency_review_screen(driver, charges, currency);
    } else {
        InternationaTransfers.Review_payment_Screen(driver, charges, currency);
    }
    InternationaTransfers.continue3_button(driver).click();
    Thread.sleep(1000);
    InternationaTransfers.confirmpay(driver);
    Thread.sleep(2000);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView[2]")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textStatus']")));
    it.FinalScreen(driver, FROM_ACCOUNT, currency, charges);
    Thread.sleep(1000);
    Thread.sleep(1000);
    MobileElement OVERVIEW = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Overview\"]/android.widget.ImageView");
    OVERVIEW.click();
    String After_Balance = AccountOverview.getAccbalance(driver, FROM_ACCOUNT);
    //it.balance_validation(driver,String before_Balance,String After_Balance);
    it.balance_validation(driver, before_Balance, After_Balance);
TP.clickAllpayments(driver,FROM_ACCOUNT,currency);
    //it.back_button(driver);
}
    }
    public static void executeScheduler(AndroidDriver driver) throws InterruptedException {
        logout(driver);
        Thread.sleep(3000);
        Login(driver);
    }

    public static void Login(AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout"))

        ));

        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@content-desc=\"More\"]/android.widget.ImageView"))
        ));

    }

    public static void logout(AndroidDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@content-desc=\"More\"]/android.widget.ImageView"))
        ));
        MobileElement more = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"More\"]/android.widget.ImageView");
        more.click();
        InternationaTransfers.scrollToText(driver,"Sign out");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Sign out']"))
        ));
        MobileElement Signout = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Sign out']");
        Signout.click();
        Thread.sleep(500);
        MobileElement Confirm = (MobileElement) driver.findElementById("android:id/button1");
        Confirm.click();
        Thread.sleep(1000);
    }

    public static void swipingAcc(AndroidDriver driver) {


        TouchAction touchAction = new TouchAction(driver);
        //touchAction.press(PointOption.point(920,  548)).moveTo(PointOption.point(154, 545)).release().perform();// 1257, y: 664})
        //  .moveTo({x: 242: y: 646})
        touchAction.press(PointOption.point(1257,  664)).moveTo(PointOption.point(242, 646)).release().perform();
    }
    public static void swipingAccJ5(AndroidDriver driver) {


        TouchAction touchAction = new TouchAction(driver);
        //touchAction.press(PointOption.point(920,  548)).moveTo(PointOption.point(154, 545)).release().perform();// 1257, y: 664})
        //  .moveTo({x: 242: y: 646})
        touchAction.press(PointOption.point(643,  321)).moveTo(PointOption.point(53, 323)).release().perform();



    }


public static String AccountSelection(AndroidDriver driver,String FROMACC) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.id("com.backbase.retail.neoUATMob:id/textBalance"))
    ));
    MobileElement Element=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textBalance");
    String k=Element.getText();

    Logger logger = Logger.getLogger("rootLogger");


        while(!(k.contains(FROMACC))){
            swipingAcc(driver);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.backbase.retail.neoUATMob:id/textBalance"))
            ));
            MobileElement Element1=(MobileElement) driver.findElementById("com.backbase.retail.neoUATMob:id/textBalance");
             k=Element1.getText();
            Thread.sleep(500);
        }

        int len=k.length();
        String m= k.substring(5,len);
       // System.out.println(m);

        if(m.equals("0"))
        {
            System.out.println("Your Account Balance is not enough to make International Transfers: "+m);
        }
        else {
            logger.info("\nAccount Balance: "+k+"\n");
        }
        return k;
    }

}

