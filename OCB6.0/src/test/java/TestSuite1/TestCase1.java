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
public class TestCase1 {
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
		Thread.sleep(5000);
		assertEquals(element.getText(), "SK플래닛(주)사업자정보");
		// driver.findElement(By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/summary")).click();
		// element.click();

		int ey = element.getLocation().getY();
		int ex = element.getLocation().getX();
		int eh = element.getSize().getHeight();
		int ew = element.getSize().getWidth();

		Thread.sleep(2000);
		// WebElement ee =
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]"));
		WebElement ee = driver
				.findElement(By.className("android.view.View").id("com.skmc.okcashbag.home_google:id/empty_view"));
		int TestY = (ee.getLocation().getY() - ee.getSize().getHeight());
		System.out.println(ee.getLocation().getY() - ee.getSize().getHeight());
		System.out.println(ee.getLocation().getX());
		System.out.println(ee.getSize().getHeight());
		System.out.println(ee.getSize().getWidth());
		System.out.println("해당 위치 " + TestY);

		System.out.println(ey);
		System.out.println(ex);
		System.out.println(eh);
		System.out.println(ew);
		driver.tap(1, ex + (ew / 2), TestY + 10, 500);
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]")).click();

		/**
		 * 대표이사 주소 고객센터 사업자 등록번호 통신판매업자신고 이용약관 / 개인정보취급방침 / 사업자정보 확인 모든 내용 비교 후
		 * 맞으면 ture
		 */

		String[] Result = { "서진우", "경기도 성남시 판교로 264 The Planet", "1599-0512", "104-86-36968", "2014-경기성남-0036", "이용약관",
				"개인정보취급방침", "사업자정보 확인" };

		WebElement Bizceo = driver
				.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_ceo"));
		WebElement Addres = driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_address"));
		WebElement Bizcall = driver
				.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_call"));
		WebElement Bizlicense = driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_license"));
		WebElement Bizsalereport = driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_sale_report"));
		WebElement Bizuseagreement = driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_use_agreement"));
		WebElement Bizprivacy = driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_privacy"));
		WebElement Bizinfom = driver
				.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_infom"));

		assertEquals(Bizceo.getText(), Result[0].toString());
		assertEquals(Addres.getText(), Result[1].toString());
		assertEquals(Bizcall.getText(), Result[2].toString());
		assertEquals(Bizlicense.getText(), Result[3].toString());
		assertEquals(Bizsalereport.getText(), Result[4].toString());
		assertEquals(Bizuseagreement.getText(), Result[5].toString());
		assertEquals(Bizprivacy.getText(), Result[6].toString());
		assertEquals(Bizinfom.getText(), Result[7].toString());

		/**
		 * 이용약관 링크 / 개인정보취급방침 / 사업자정보 확인 클릭 시 해당 링크 이동 여부 확인
		 */

		/**
		 * 이용약관 확인
		 */
		Bizuseagreement.click();

		WebElement Title = driver
				.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt"));
		assertEquals(Title.getText(), "OK캐쉬백 이용약관");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		/*
		 * 메인피드 이동 후 개인정보취급방침으로 이
		 */

		driver.tap(1, ex + (ew / 2), TestY + 10, 500);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_privacy")));
		driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_privacy"))
				.click();
		// Bizprivacy.click();

		Title = driver
				.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt"));
		assertEquals(Title.getText(), "개인정보 취급방침");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		/*
		 * 메인피드 이동 후 사업자정보 확인(브라우저 새로 열림) 해당 주소 일치 여부 확인 후 뒤로가기 실
		 */
		driver.tap(1, ex + (ew / 2), TestY + 10, 500);
		
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/biz_infom")));

		Bizinfom.click();

		WebElement url = driver
				.findElement(By.className("android.widget.EditText").id("com.android.chrome:id/url_bar"));
		System.out.println(url.getText());
		Boolean UrlEquals = url.getText().contains("www.ftc.go.kr");
		assertTrue(UrlEquals);
		driver.navigate().back();
		
		

		
		/**
		 *이벤트 배너 클릭 하여 이벤트페이지 이
		 */
		
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
// android.widget.TextView / SK플래닛(주)사업자정보
