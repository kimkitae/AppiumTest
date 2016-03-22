package Android.MypageAndConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCase_005 {
	/**
	 * Created by daearcdo on 2016. 1. 11.. LMB 메뉴 내 모든 버튼 실행
	 * 
	 */

	public AppiumDriver driver;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "test");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("unicodeKeyboard", true);
		// capabilities.setCapability("resetKeyboard", true);
		// File file = new File("/Users/daearcdo/OneDrive/ocb.apk");

		// capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
		capabilities.setCapability("appActivity", ".activities.Entrypoint");
		capabilities.setCapability("noRest", true);
		// capabilities.setCapability("fullReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		final int MAXCOUNT = 15;
		int count = MAXCOUNT;

		System.out.println("TestCase_005 Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// LMB 클릭

		/**
		 * 닉네임 설정 내 정보
		 */

		WebElement placename = null;
		WebElement comment = null;
		WebElement rating = null;
		WebElement data = null;

		while (count > 0) {
			try {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
				driver.findElement(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")).click();
				driver.findElement(By.className("android.widget.TextView")
						.id("com.skmc.okcashbag.home_google:id/gnb_drawer_profile_name")).click();
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/profile_setting_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/edt_p_name")).clear();
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/right_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/edt_p_name")).sendKeys("testtesttesttest");
				
				
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/right_btn")).click();

				break;
			}

			catch (NoSuchElementException nsee) {
				System.out.println("");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

			count--;
		}

	}

}
