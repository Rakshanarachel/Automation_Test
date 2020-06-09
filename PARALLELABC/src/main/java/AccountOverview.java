import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.interactions.touch.TouchActions;

public class AccountOverview {

public static String getAccbalance(AndroidDriver driver, String Account,String devicename) throws InterruptedException {
String str;
    char a = Account.charAt(0);
    switch (a) {
        case 'U':

            str= getUSD(driver, devicename).getText();
        break;
        case 'B':
            str= getBHD(driver, devicename).getText();

        break;
        case 'E':
            str= getEUR(driver, devicename).getText();
        break;
        case 'A':
            str= getAED(driver,devicename).getText();
        break;
        case 'S':
            str= getSAR(driver, devicename).getText();
        break;
        case 'G':
            str= getGBP(driver, devicename).getText();
        //return getGBP(driver).getText();
        break;


        default:
            throw new IllegalStateException("Unexpected value: " + a);
    }


return str;
}
    public static MobileElement AccountClick(AndroidDriver driver, String Account,String devicename) throws InterruptedException {
        MobileElement mb;
        char a = Account.charAt(0);
        switch (a) {
            case 'U':

                mb= getUSD(driver, devicename);
                break;
            case 'B':
                mb= getBHD(driver, devicename);

                break;
            case 'E':
                mb= getEUR(driver, devicename);
                break;
            case 'A':
                mb= getAED(driver,devicename);
                break;
            case 'S':
                mb= getSAR(driver, devicename);
                break;
            case 'G':
                mb= getGBP(driver, devicename);
                //return getGBP(driver).getText();
                break;


            default:
                throw new IllegalStateException("Unexpected value: " );
        }


        return mb;
    }
MobileElement USD,BHD,GBP,AED,SAR,EUR;

    public static MobileElement getUSD(AndroidDriver driver,String devicename) throws InterruptedException {
        try {


            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]");

            return accbalance;
        }catch (Exception EX)
        {
            swipingWithName(driver,devicename);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'USD')]");

            return accbalance;

        }
    }

    public static MobileElement getBHD(AndroidDriver driver,String devicename) throws InterruptedException {

        try {


            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]");
            return accbalance;
        }catch (Exception E){
            swipingWithName(driver,devicename);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'BHD')]");
            return accbalance;
        }
       // return BHD;

    }

    public static MobileElement getGBP(AndroidDriver driver,String devicename) throws InterruptedException {

        try {


            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]");

            return accbalance;
        }catch (Exception we){
            swipingWithName(driver,devicename);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'GBP')]");

            return accbalance;
        }
    }

    public static MobileElement getAED(AndroidDriver driver,String devicename) throws InterruptedException {

       try {
           WebDriverWait wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.or(
                   ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]"))
           ));
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]");

           return accbalance;
       }catch (Exception e){
           swipingWithName(driver,devicename);
          Thread.sleep(1000);
        MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'AED')]");

        return accbalance;
    }}

    public static MobileElement getSAR(AndroidDriver driver,String devicename) throws InterruptedException {

       try {
           WebDriverWait wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.or(
                   ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]"))
           ));
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]");

           return accbalance;
       }catch (Exception E){
           swipingWithName(driver,devicename);
           MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'SAR')]");

           return accbalance;
       }
    }
    public  static void swipingWithName(AndroidDriver driver,String DEVICE_NAME) throws InterruptedException {
        if(DEVICE_NAME.toUpperCase().contains("S7"))
        {
            scrollDownS7(driver);
        }
        else
        {
            scrollDownJ5(driver);
        }
    }
    public static void scrollDownS7(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction mobileaction = new TouchAction(driver);
        mobileaction.press(PointOption.point(1412, 2149)).moveTo(PointOption.point(1387, 365)).release().perform();
        


    }
    public  static void scrolldownlg(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction mobileaction = new TouchAction(driver);
        mobileaction.press(PointOption.point(1056, 1763)).moveTo(PointOption.point(1059, 421)).release().perform();

    }
    public static void scrollDownJ5(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction mobileaction = new TouchAction(driver);
        mobileaction.press(PointOption.point(702, 1134)).moveTo(PointOption.point(706, 162)).release().perform();


    }

    public static MobileElement getEUR(AndroidDriver driver,String devicename) throws InterruptedException {



     //  InternationaTransfers.scrollToTexting(driver,acc);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]"))
            ));
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]");

            return accbalance;
        }catch (Exception e){
            swipingWithName(driver,devicename);
            MobileElement accbalance = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.backbase.retail.neoUATMob:id/textProductMainAmount' and starts-with(@text,'EUR')]");

            return accbalance;
        }


    }


}
