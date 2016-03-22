package Android.Auth;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

//@Ignore
public class OcbAutoTest {
    /**
     * Created by daearcdo on 2016. 1. 11..
     */

public AppiumDriver driver;

    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "test");
        capabilities.setCapability("platformVersion", "5.1");
        //capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard" , true);
        File file = new File("/Users/daearcdo/Downloads/OCBTEST/ocb5.6.2-20160310_103958-R6840.apk");

        capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
        capabilities.setCapability("appActivity", ".activities.Entrypoint");
        capabilities.setCapability("noRest", true);
        capabilities.setCapability("fullReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {


        driver.findElement(By.className("android.widget.TextView").name("회원인증 하기")).click();
       // driver.findElement(By.className("android.widget.Button").name("취소")).click();
        driver.findElement(
                By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/regOKCashBagButton"))
                .click();

        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/cardno1"))
                .sendKeys("2100");
        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/cardno2"))
                .sendKeys("4114");
        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/cardno3"))
                .sendKeys("3170");
        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/cardno4"))
                .sendKeys("0437");
        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/cardpwd"))
                .sendKeys("0325");

        driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/reqOtp"))
                .click();

        driver.findElement(
                By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2"))
                .click();

        String e1 = driver
                .findElement(
                        By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/otpNumber"))
                .getText();
        while (e1.length() != 6) {
            Thread.sleep(1000);
            e1 = driver
                    .findElement(
                            By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/otpNumber"))
                    .getText();

        }
        driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/doneButton")).click();




        driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/agreeAll")).click();
        driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/doneButton")).click();


driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/password1")).sendKeys("0325");
        driver.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/password2")).sendKeys("0325");
        driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/cardPasswordCheckBox")).click();
        driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/doneButton")).click();











        }
    }



