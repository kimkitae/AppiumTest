package ocb.UIauto;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@Ignore
public class Test_Start {
	/**
	 * Created by daearcdo on 2016. 1. 11.. 
	 * 메인피드 제일 하단에 위치한 배너부분 각 정상작동 유무 확인 작
	 */

	public AppiumDriver driver;

	@Before
	public void setUp() throws Exception {

		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "test");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		// File file = new File("/Users/daearcdo/OneDrive/ocb.apk");

		// capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
		capabilities.setCapability("appActivity", ".activities.Entrypoint");
		capabilities.setCapability("noRest", true);
		// capabilities.setCapability("fullReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		System.out.println("Test Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		int WindowsY = 752;
		int y;
		int x1;
		int y1;
		int start;
		int starty;
		int end;
		int endy;
		final int maxcount = 20;
		int count = maxcount;
		WebElement element = null;

	
		while (count > 0) {
			try {
				Thread.sleep(1000);
				
				break;
			} catch (NoSuchElementException nsee) {
				System.out.println("현재 화면에서 찾지 못함. scroll 진행.");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
			count--;
		}
		

		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		
	driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/eventbanner_message")).click();
	
	HashMap<String, String> scrollObject = new HashMap<String, String>();
    RemoteWebElement element1 = (RemoteWebElement)((AndroidDriver) driver).findElementByAndroidUIAutomator(
    "new UiSelector().className(\"android.widget.ListView\")");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String webElementId = ((RemoteWebElement) element).getId();
    scrollObject.put("text", "OK캐쉬백 후원하기 16.01.26~16.04.30 포인트쓰기");
    scrollObject.put("element", webElementId);
    js.executeScript("mobile: scrollTo", scrollObject);
	
	
		
	}
}

