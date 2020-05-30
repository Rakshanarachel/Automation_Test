/*import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public void get(AndroidDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        int count=1;
        FileUtils.copyFile(file, new File("D:\\Automation screenshots\\InternationalTransfer'"+count+++"'.png"));
    }
}*/


import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class  ScreenShot{
public  static int c=1;
    public  static int r;

    public static void screenShot(WebDriver driver, String filepath) throws IOException {
        Random randomnum=new Random();
        r=randomnum.nextInt();

        TakesScreenshot scrShot=((TakesScreenshot)driver);
        File Scrfile=scrShot.getScreenshotAs(OutputType.FILE);
        File destfile=new File(filepath);
        Files.copy (Scrfile,destfile);
    }


}
