
package Android.IntegratedSearch;

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		System.out.println("TestCase_005 Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/gnb_topbar_search_btn")).click();

		// 인기 검색어 , 인기 검색 메뉴 타이틀 노출 여
		WebElement name1 = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]"));
		System.out.println(name1.getAttribute("name"));

		WebElement name2 = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]"));
		System.out.println(name2.getAttribute("name"));

		// 출석체크
		driver.findElement(By
				.xpath("android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

		// 도전룰렛

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[2]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

		// 게임2048
		driver.findElement(By
				.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 버거킹

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

		// 게임

		driver.findElement(By
				.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[2]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

		// 버거킹쿠폰
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[3]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 롯데리아
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[4]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 파리바게ㄸ
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[5]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 빕스

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[6]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 포인트소식

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]"))
				.click();
		// 마이메뉴

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[2]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 이벤트

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();
		// 알림

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[4]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

		// 쿠폰함
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[5]"))
				.click();
		System.out.println(driver.findElement(By.id("com.skmc.okcashbag.home_google:id/title_txt")).getText());

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/back_btn")).click();

	}
}
