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

public class TestCase_002 {
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

		System.out.println("TestCase_002 Start");

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
				placename = driver.findElement(By.id("com.skmc.okcashbag.home_google:id/txt_placename"));
				comment = driver.findElement(By.id("com.skmc.okcashbag.home_google:id/txt_comment"));
				rating = driver.findElement(By.id("com.skmc.okcashbag.home_google:id/rb_rating"));
				data = driver.findElement(By.id("com.skmc.okcashbag.home_google:id/txt_date"));
				System.out.println(placename.getText());
				System.out.println(comment.getText());
				System.out.println(data.getText());

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/txt_placename")).click();
				driver.scrollTo("삭제").click();
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

				break;
			}

			catch (NoSuchElementException nsee) {
				System.out.println("등록된 후기가 없습니다. 후기를 등록합니다.");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_topbar_place_btn")).click();
			driver.findElement(By
					.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.widget.ExpandableListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]"))
					.click();
			// ScrollSearch();
			driver.scrollTo("내 평점.리뷰 남기기").click();
			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/edt_comment")).sendKeys("Very Good!");
			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/btn_regist")).click();
			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
			driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

			count--;
		}

	}

	public void ScrollSearch() {

		final int MAXCOUNT = 15;
		int count = MAXCOUNT;

		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.20);
		int x2 = (int) (size.width * 0.80);
		int x3 = (int) (size.height * 0.50);

		int w = (int) (size.width * 0.50);
		int StartX = (int) (size.height * 0.80);
		int EndX = (int) (size.height * 0.20);

		WebElement element = null;
		// driver.context("WEBVIEW");

		while (count > 0) {
			try {
				Thread.sleep(1000);
				System.out.println(driver.getPageSource());
				driver.findElementByXPath(("//android.view.View[@content-desc='내 평점.리뷰 남기기']")).click();

				break;

			}

			catch (NoSuchElementException nsee) {
				System.out.println("다시 스크롤 합니다. ");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

			driver.swipe(w, StartX, w, EndX, 6000);
			count--;
		}
	
		driver.findElementByXPath(("//android.view.View[@content-desc='내 평점.리뷰 남기기']")).click();
	}
}



