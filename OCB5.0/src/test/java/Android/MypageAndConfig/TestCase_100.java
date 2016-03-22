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

public class TestCase_100 {
	/**
	 * Created by daearcdo on 2016. 1. 11.. LMB 메뉴 내 모든 버튼 실행
	 * 
	 */

	public AndroidDriver driver;

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

		System.out.println("TestCase_100 Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// LMB 클릭

		/**
		 * 닉네임 설정 내 정보
		 */

		while (count > 0) {
			try {
				Thread.sleep(1000);

				// LMB 클릭
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
				driver.findElement(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_drawer_setting")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/sbtn_gps")).click();

				System.out.println("현재 위치정보 상태 : "
						+ driver.findElement(By.id("com.skmc.okcashbag.home_google:id/sbtn_gps")).isSelected());

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/overflow_btn")).click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]"))
						.click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_topbar_place_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_cancel")).click();

				System.out.println("현재 표시된 지역명 : "
						+ driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
				driver.findElement(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_drawer_setting")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/sbtn_gps")).click();

				System.out.println("현재 위치정보 상태 : "
						+ driver.findElement(By.id("com.skmc.okcashbag.home_google:id/sbtn_gps")).isSelected());


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

			break;
		}

	}

}
