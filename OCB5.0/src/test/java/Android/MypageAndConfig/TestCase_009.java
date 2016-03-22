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

public class TestCase_009 {
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

		System.out.println("TestCase_009 Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// LMB 클릭

		/**
		 * 닉네임 설정 내 정보
		 */

		while (count > 0) {
			try {
				Thread.sleep(1000);

				driver.findElement(By.className("android.widget.TextView").name("쓰기")).click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[2]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[2]/android.view.View[1]"))
						.click();

				driver.findElement(By
						.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.widget.ListView[1]/android.view.View[1]/android.view.View[2]"))
						.click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Button[1]"))
						.click();

				driver.findElement(By
						.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.ListView[3]/android.view.View[2]/android.widget.CheckBox[1]"))
						.click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[9]"))
						.click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/password0")).sendKeys("0325");

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/doneButton")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/overflow_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/over_home_layout")).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
				driver.findElement(By.className("android.widget.ImageView")
						.id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_drawer_mycoupon_button")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/list_type_btn")).click();

				driver.findElement(By.className("android.widget.TextView").name("유료쿠폰")).click();

				driver.findElement(By.className("android.widget.TextView").name("기프티콘")).click();

				// 상단바 메달 클릭하기
				driver.openNotifications();

				driver.findElement(By.id("com.android.systemui:id/clear_all_button")).click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]"))
						.click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[3]"))
						.click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();
				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[3]"))
						.click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();
				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[3]"))
						.click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();
				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[3]"))
						.click();
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[4]"))
						.click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]"))
						.click();

				driver.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]"))
						.click();

				driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[2]")).click();
				
				driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

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
