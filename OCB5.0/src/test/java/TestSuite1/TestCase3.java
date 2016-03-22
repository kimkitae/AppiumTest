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
public class TestCase3 {
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

		final int MAXCOUNT = 15;
		int count = MAXCOUNT;

		System.out.println("Test Start");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		/**
		 * 닉네임 설정 내 정보
		 */

	
		driver.findElement(
				By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/gnb_drawer_profile_name"))
				.click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		/**
		 * 포인트 이동
		 */

		driver.findElement(By.className("android.widget.LinearLayout")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_mypoint_layout")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/my_point_filter_save_use_textbutton")).click();
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/my_point_filter_charge_textbutton")).click();
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/my_point_filter_gift_textbutton")).click();
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/my_point_filter_locker_textbutton")).click();
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/my_point_filter_coupon_textbutton")).click();

		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		/*
		 * 합산 버튼 클릭
		 */

		driver.findElement(
				By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/gnb_drawer_sum"))
				.click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 선물 버튼 클릭
		driver.findElement(
				By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/gnb_drawer_gift"))
				.click();
		
		driver.findElement(
				By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/ocb_dialog_button1"))
				.click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 교환 클릭
		driver.findElement(By.className("android.widget.TextView").name("교환")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 초기 카드명 가져온 뒤 다음 카드 눌러서 다시 처음 카드명이 나올때까지 다음 카드 클릭

		WebElement CardName = driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_name_text"));
		String Cardname = CardName.getText();
		System.out.println("현재 카드명 " + Cardname);
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_down"))
				.click();
		CardName = driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_name_text"));

		// while (Cardname.equals(CardName.getText()) == false) {
		// System.out.println(CardName.getText() + "/" + Cardname);
		// try {
		//
		// // CardName =
		// // driver.findElement(By.className("android.widget.TextView")
		// //
		// .id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_name_text"));
		// // System.out.println("1" + CardName.getText());
		// // break;
		// } catch (NoSuchElementException nee) {
		// System.out.println("추천 카드 입니다. 다음 카드로 이동 합니다.");
		// driver.findElement(
		// By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_down"))
		// .click();
		// }
		//
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// }
		// driver.findElement(By.className("android.widget.ImageView")
		// .id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_down")).click();
		// CardName = driver.findElement(By.className("android.widget.TextView")
		// .id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_name_text"));
		// System.out.println("2" + CardName.getText());
		// }

		///

		while (count > 0) {
			try {
				Thread.sleep(1000);
				CardName = driver.findElement(By.className("android.widget.TextView")
						.id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_name_text"));
				System.out.println(CardName.getText());
				if (Cardname == CardName.getText()) {
					System.out.println("Exit");
					break;
				}

			} catch (NoSuchElementException nsee) {
				System.out.println("추천카드 확인 다음카드 진행");
			} catch (InterruptedException e) {
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			driver.findElement(By.className("android.widget.ImageView")
					.id("com.skmc.okcashbag.home_google:id/gnb_drawer_card_down")).click();
			
			System.out.println("2 " + CardName.getText());
			count--;
		}

		///

		// 쿠폰함 클릭
		driver.findElement(By.className("android.widget.LinearLayout")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_mycoupon_button")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 스크랩 클릭
		driver.findElement(By.className("android.widget.LinearLayout")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_myscrap_button")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 복권 스탬프 클릭
		driver.findElement(By.className("android.widget.LinearLayout")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_mystamp_button")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 영수증 온라인 상품 쿠폰 적립
		driver.findElement(By.className(" android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_qrcode_button")).click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

		// 온오프 임시 비밀번호
		driver.findElement(By.className("android.widget.TextView")
				.id("com.skmc.okcashbag.home_google:id/gnb_drawer_onepass_button")).click();
		driver.findElement(
				By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/ocb_dialog_button1"))
				.click();


		// 알림함으로 이동
		driver.findElement(
				By.className("android.view.View").id("com.skmc.okcashbag.home_google:id/gnb_drawer_noti_list_button"))
				.click();
		System.out.println(driver.findElement(By.className("android.widget.TextView").id("com.skmc.okcashbag.home_google:id/title_txt")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn")));
		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/back_btn"))
				.click();

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn")));
		driver.findElement(
				By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/gnb_topbar_menu_btn"))
				.click();

	}
}
