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


@Ignore

public class PhoneCardTest {
    /**
     * Created by daearcdo on 2016. 1. 11..
     */

    public AppiumDriver driver;

    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "test");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("unicodeKeyboard", true);
        //capabilities.setCapability("resetKeyboard" , true);
        //File file = new File("/Users/daearcdo/OneDrive/ocb.apk");

        //capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
        capabilities.setCapability("appActivity", ".activities.Entrypoint");
        capabilities.setCapability("noRest",false);
        // capabilities.setCapability("fullReset", true);

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
        driver.findElement(By.className("android.widget.Button").name("취소")).click();
        driver.findElement(
                By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/regPhoneButton"))
                .click();

        driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/agreeAll"))
                .click();
        driver.findElement(
                By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/nameTextField"))
                .sendKeys("김기태");

        driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/year")).click();

        String input1 = driver
                .findElement(By
                        .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.EditText[1]"))
                .getText();
        while (input1.equals("1988") == false) {
            driver.findElement(By
                    .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.Button[2]"))
                    .click();
            input1 = driver
                    .findElement(By
                            .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.EditText[1]"))
                    .getText();

        }
        input1 = driver
                .findElement(By
                        .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]/android.widget.EditText[1]"))
                .getText();
        while (input1.equals("10") == false) {
            driver.findElement(By
                    .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]/android.widget.Button[2]"))
                    .click();
            input1 = driver
                    .findElement(By
                            .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]/android.widget.EditText[1]"))
                    .getText();

        }

        input1 = driver
                .findElement(By
                        .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[3]/android.widget.EditText[1]"))
                .getText();
        while (input1.equals("07") == false) {
            driver.findElement(By
                    .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[3]/android.widget.Button[2]"))
                    .click();
            input1 = driver
                    .findElement(By
                            .xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[3]/android.widget.EditText[1]"))
                    .getText();

        }

        driver.findElement(By.className("android.widget.Button").id("android:id/button1")).click();


    }


}


