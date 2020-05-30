import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.interactions.touch.TouchActions;

public class AccountOverview {

public static String getAccbalance(AndroidDriver driver, String Account) throws InterruptedException {
String str;
    char a = Account.charAt(0);
    switch (a) {
        case 'U':

            str= getUSD(driver, Account).getText();
        break;
        case 'B':
            str= getBHD(driver, Account).getText();

        break;
        case 'E':
            str= getEUR(driver, Account).getText();
        break;
        case 'A':
            str= getAED(driver,Account).getText();
        break;
        case 'S':
            str= getSAR(driver, Account).getText();
        break;
        case 'G':
            str= getGBP(driver, Account).getText();
        //return getGBP(driver).getText();
        break;


        default:
            throw new IllegalStateException("Unexpected value: " + a);
    }


return str;
}
    public static MobileElement AccountClick(AndroidDriver driver, String Account) throws InterruptedException {
        MobileElement mb;
        char a = Account.charAt(0);
        switch (a) {
            case 'U':

                mb= getUSD(driver, Account);
                break;
            case 'B':
                mb= getBHD(driver, Account);

                break;
            case 'E':
                mb= getEUR(driver, Account);
                break;
            case 'A':
                mb= getAED(driver,Account);
                break;
            case 'S':
                mb= getSAR(driver, Account);
                break;
            case 'G':
                mb= getGBP(driver, Account);
                //return getGBP(driver).getText();
                break;


            default:
                throw new IllegalStateException("Unexpected value: " );
        }


        return mb;
    }
MobileElement USD,BHD,GBP,AED,SAR,EUR;

    public static MobileElement getUSD(AndroidDriver driver,String acc) throws InterruptedException {
        try {


            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]");

            return accbalance;
        }catch (Exception EX)
        {
            scrollDownS7(driver);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]");

            return accbalance;

        }
    }

    public static MobileElement getBHD(AndroidDriver driver,String acc) throws InterruptedException {

        try {


            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]");
            return accbalance;
        }catch (Exception E){
            scrollDownS7(driver);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]");
            return accbalance;
        }
       // return BHD;

    }

    public static MobileElement getGBP(AndroidDriver driver,String acc) throws InterruptedException {

        try {


            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]");

            return accbalance;
        }catch (Exception we){
            scrollDownS7(driver);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]");

            return accbalance;
        }
    }

    public static MobileElement getAED(AndroidDriver driver,String acc) throws InterruptedException {

       try {
           WebDriverWait wait = new WebDriverWait(driver, 5);
           wait.until(ExpectedConditions.or(
                   ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]"))
           ));
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]");

           return accbalance;
       }catch (Exception e){
           scrollDownS7(driver);
          Thread.sleep(1000);
        MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]");

        return accbalance;
    }}

    public static MobileElement getSAR(AndroidDriver driver,String acc) throws InterruptedException {

       try {
           WebDriverWait wait = new WebDriverWait(driver, 5);
           wait.until(ExpectedConditions.or(
                   ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]"))
           ));
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]");

           return accbalance;
       }catch (Exception E){
           scrollDownS7(driver);
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]");

           return accbalance;
       }
    }
    public static void scrollDownS7(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction mobileaction = new TouchAction(driver);
        mobileaction.press(PointOption.point(1412, 2149)).moveTo(PointOption.point(1387, 365)).release().perform();
        


    }
    public static void scrollDownJ5(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction mobileaction = new TouchAction(driver);
        mobileaction.press(PointOption.point(702, 1134)).moveTo(PointOption.point(706, 162)).release().perform();


    }

    public static MobileElement getEUR(AndroidDriver driver,String acc) throws InterruptedException {



     //  InternationaTransfers.scrollToTexting(driver,acc);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]");

            return accbalance;
        }catch (Exception e){
            scrollDownS7(driver);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]");

            return accbalance;
        }


    }


}
