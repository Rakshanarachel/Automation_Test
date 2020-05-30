import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class mainclass {
    AndroidDriver<AndroidElement> driver;
InternationaTransfers I=new InternationaTransfers();
ExReporter Er=new ExReporter();
ExcelReader read=new ExcelReader();
TransactionPage tnp=new TransactionPage();
Logger logger;

public static Methods m=new Methods();
    @BeforeTest
    public void launchDevice() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM S7");
        dc.setCapability(MobileCapabilityType.UDID, "ce0117110d33510204");
        dc.setCapability("platformName", "Android");
        //dc.setCapability("platformVersion", "10");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.backbase.retail.neoUATMob");
        dc.setCapability("appActivity", "com.backbase.model.view.activity.LancherActivity");
        dc.setCapability("noReset", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Test(priority = 0)
    public  void Login() throws InterruptedException, MalformedURLException {
        m.Login(driver);
        logger=Logger.getLogger("rootLogger");
        logger.info("Logged IN successfully");

    }

    /*
    String FromAcc="USD";
    @Test(priority = 2)
    public  void International_Transfer1() throws InterruptedException, IOException {
        m.International_Transfer(driver,FromAcc,"USD","IPAC");
        Thread.sleep(3000);

    }
    @Test(priority = 1)
    public  void CreateSheet() throws InterruptedException, IOException {

        Er.createsheet();
        Er.createSheet_Beneficiary();

        Thread.sleep(2000);


    }*/
   @Test(priority = 1)
       public  void CreateSheet() throws InterruptedException, IOException {

           Er.createsheet();
           Er.createSheet_Beneficiary();
Er.createSheet_TransactionPage();
           Thread.sleep(2000);


       }


    @Test(priority =2, dataProvider="ExecutionData")
    public  void International_Transfer3(String fromacc, String currency,String charges) throws InterruptedException, IOException {
        m.International_Transfer(driver,fromacc,currency,charges);
        Thread.sleep(3000);

    }
    @DataProvider(name="ExecutionData")
    public Object[][] ExecutionData() {
        Object[][] arrayObject = read.getExcelData("D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\Sheets\\Book1.xls","Sheet1");
        return arrayObject;
    }
/*

       String FromAcc[]={"USD","EUR","AED","SAR","GBP"};
       String STR[]={"AUD","EUR","KWD","SGD","JOD","USD","JPY","HKD","OMR","AED","GBP","SAR","CAD"};
       @Test(priority = 2)
       public  void International_Transfer(String FromAcc[]) throws InterruptedException, IOException {
   for(int i=0;i<=FromAcc.length;i++) {
       for (int j = 0; j <= STR.length; j++){
           m.International_Transfer(driver, FromAcc[i], "AUD", "IPAC");//BHD
       Thread.sleep(2000);
   }

   }

       }

        */

    /*
String FromAcc="USD";
       @Test(priority = 2)
       public  void International_Transfer1() throws InterruptedException, IOException {
           m.International_Transfer(driver,FromAcc,"USD","BENE");
           Thread.sleep(3000);

       }

       @Test(priority = 3)
       public  void International_Transfer2() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"KWD","BENE");
           Thread.sleep(3000);

       }

       @Test(priority = 4)
       public  void International_Transfer3() throws InterruptedException, IOException {
           m.International_Transfer(driver,FromAcc,"EUR","IPAC");
           Thread.sleep(3000);
       }
       @Test(priority = 5)
       public  void International_Transfer4() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"HKD");
           Thread.sleep(3000);

       }
       @Test(priority = 6)
       public  void International_Transfer5() throws InterruptedException, IOException {
           m.International_Transfer(driver,FromAcc,"GBP");
           Thread.sleep(3000);

       }
       @Test(priority = 7)
       public  void International_Transfer6() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"AUD");
           Thread.sleep(3000);
       }
       @Test(priority = 8)
       public  void International_Transfer7() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"AED");
           Thread.sleep(3000);
       }
       @Test(priority = 9)
       public  void International_Transfer8() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"SGD");
           Thread.sleep(3000);

       }
       @Test(priority = 10)
       public  void International_Transfer9() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"SAR");
           Thread.sleep(3000);

       }
       @Test(priority = 11)
       public  void International_Transfer10() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"OMR");
           Thread.sleep(3000);

       }
       @Test(priority = 12)
       public  void International_Transfer11() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"JPY");
           Thread.sleep(3000);

       }
       @Test(priority = 13)
       public  void International_Transfer12() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"JOD");
           Thread.sleep(3000);

       }
       @Test(priority = 14)
       public  void International_Transfer13() throws InterruptedException, IOException {

           m.International_Transfer(driver,FromAcc,"USD");
           Thread.sleep(3000);

       }*/

    @Test(priority =3)
    public  void logout() throws InterruptedException {
        m.logout(driver);
    }
    @AfterTest
    public void CloseApp(){
        driver.closeApp();
    }
}




