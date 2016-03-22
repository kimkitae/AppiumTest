package TestSuite1;

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
public class TestCase2 {
	/**
	 * Created by daearcdo on 2016. 1. 11.. 이벤트 페이지 진입 후 "엔터식스 온라인몰 미리줌 행사" 배너
	 * 클릭
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

		start = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ListView[1]/android.widget.LinearLayout[3]"))
				.getLocation().getY();
		System.out.println(start);
		starty = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ListView[1]/android.widget.LinearLayout[3]"))
				.getSize().getHeight();
		System.out.println(starty);

		end = driver
				.findElement(
						By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/main_header"))
				.getLocation().getY();
		System.out.println(end);
		endy = driver
				.findElement(
						By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/main_header"))
				.getSize().getHeight();
		System.out.println(endy);
		y = start + starty;
		x1 = WindowsY / 2;
		y1 = end + endy;

		
		while (count > 0) {
			try {
				Thread.sleep(1000);
				element = driver.findElement(By.className("android.widget.TextView").name("SK플래닛(주)사업자정보"));
				break;
			} catch (NoSuchElementException nsee) {
				System.out.println("현재 화면에서 찾지 못함. scroll 진행.");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			driver.swipe(x1, y, x1, y1, 6000);
			count--;
		}
		
		System.out.println("찾음 " + element.getText());
		assertEquals(element.getText(), "SK플래닛(주)사업자정보");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/eventbanner_message")));

		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/eventbanner_message"))
				.click();

		driver.scrollTo("엔터식스 온라인몰 미리줌 행사").click();
		
		

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[2]/android.webkit.WebView[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[2]")));
		WebElement EventName = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[2]/android.webkit.WebView[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[2]"));
		assertEquals(EventName.getAttribute("name"), "엔터식스 온라인몰");
		System.out.println("현재 이벤트명은 " + EventName.getAttribute("name") + " 입니다");

		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();
		driver.navigate().back();

	}
}
