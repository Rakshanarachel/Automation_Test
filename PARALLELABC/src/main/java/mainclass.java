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
ExReporter International=new ExReporter();
ExReporter Within_ila=new ExReporter();
ExcelReporter ALL=new ExcelReporter();
ExcelReader read=new ExcelReader();
TransactionPage tnp=new TransactionPage();
BeneficiaryInternationaltransfer beneficiary=new BeneficiaryInternationaltransfer();
Logger logger;
    WithinILA ila=new WithinILA();
public static Methods m=new Methods();
BetweenOwnAccouns betweenOwnAccouns=new BetweenOwnAccouns();
    @BeforeTest
    public void launchDevice() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM J5");
        dc.setCapability(MobileCapabilityType.UDID, "42105b60ac1d946d");//42105b60ac1d946d,ce0117110d33510204

        dc.setCapability("platformName", "Android");
        //dc.setCapability("platformVersion", "10");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.backbase.retail.neoUATMob");
        dc.setCapability("appActivity", "com.backbase.model.view.activity.LancherActivity");
        dc.setCapability("noReset", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4725/wd/hub"), dc);
    }

    @Test(priority = 0)
    public  void Login() throws InterruptedException, MalformedURLException {
        m.Login(driver);
        logger=Logger.getLogger("rootLogger");
        logger.info("Logged IN successfully");

    }
/*
   @Test(priority = 1)
    public  void CreateSheet() throws InterruptedException, IOException {
//Within_ila.createsheet_ilatransfer();
//Within_ila.createSheet_TransactionPage();
//ALL.GeneralCreateSheet("BetweenAccounts");
        International.createsheet();
        International.createSheet_Beneficiary();
        International.createSheet_TransactionPage();

        Thread.sleep(2000);


    }
*/
/*
    @Test(priority = 2, dataProvider = "ILA_ExecutionData")
    public  void ILATRANSFER(String FROMACC,String TOACC,String currency,String payment,String transfer_amount,String desc) throws InterruptedException, IOException {

    ila.Withinila_Transfer(driver,FROMACC, TOACC, currency, payment, transfer_amount, desc);
    }


*/

    @Test(priority =2, dataProvider="ExecutionData")
    public  void International_Transfer(String device,String fromacc, String currency,String charges,String Amount,String bene_name,String bene_acc,String address1,String address2,String country,String details) throws InterruptedException, IOException {
        m.International_Transfer(driver,device,fromacc,currency,charges,Amount,bene_name,bene_acc,address1,address2,country,details);
        Thread.sleep(3000);

    }


    @DataProvider(name="ExecutionData")
    public Object[][] ExecutionData() {
        Object[][] arrayObject = read.getExcelData("D:\\testdatasss\\PARALLELABC\\src\\main\\DataSheets\\datasheet.xls","Sheet1");
        return arrayObject;
    }

/*
    @DataProvider(name="ILA_ExecutionData")
    public Object[][] ILA_ExecutionData() {
        Object[][] arrayObject = read.getExcelData("D:\\testdatasss\\androidscript\\ABC-PART-2\\src\\main\\DataSheets\\ILATRANSFER.xls","Sheet1");
        return arrayObject;
    }

    @Test(priority =3)
    public  void BetweenOwnAccounts() throws IOException, InterruptedException {
        betweenOwnAccouns.BetweenOwnACcount_Transfer(driver,"BHD","GBP","Destination","TEst");
    }
*/
    @Test(priority =3)
    public  void logout() throws InterruptedException {
        m.logout(driver);
        logger.info("Logged out successfully!!!!!");
    }
    @AfterTest
    public void CloseApp(){
        driver.closeApp();
    }
}




