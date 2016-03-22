package Android.Auth;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
		capabilities.setCapability("unicodeKeyboard", false);
		// capabilities.setCapability("resetKeyboard" , true);
		File file = new File("/Users/daearcdo/Downloads/OCBTEST/ocb5.6.2-20160311_110128-R6848.apk");

		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
		capabilities.setCapability("appActivity", ".activities.Entrypoint");
		capabilities.setCapability("noRest", true);
		capabilities.setCapability("fullReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		// 튜토리얼

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/confirmButton")).click();

		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.20);
		System.out.println(x1);
		int x2 = (int) (size.width * 0.80);
		System.out.println(x2);
		int x3 = (int) (size.height * 0.50);
		System.out.println(x3);

		WebDriverWait wait = new WebDriverWait(driver, 60);

		// wait.until(ExpectedConditions.visibilityOf((WebElement)
		// By.className("android.widget.ImageView")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]")));

		driver.swipe(x2, x3, x1, x3, 1000);
		System.out.println("1");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]")));
		Thread.sleep(2000);
		driver.swipe(x2, x3, x1, x3, 1000);
		System.out.println("2");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]")));
		Thread.sleep(2000);
		driver.swipe(x2, x3, x1, x3, 1000);
		System.out.println("3");

		Thread.sleep(2000);
		driver.swipe(x2, x3, x1, x3, 1000);
		System.out.println("3");

		// 체크박스 체크하기
		int chksizey = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.widget.CheckBox[1]"))
				.getLocation().y;
		int chksizex = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.widget.CheckBox[1]"))
				.getLocation().x;

		driver.tap(1, chksizex / 3, chksizey, 500);

		// 엑스표 닫기
		int closex = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Button[1]"))
				.getLocation().x;
		int closey = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Button[1]"))
				.getLocation().y;

		driver.tap(1, closex / 3, closey, 500);

		// 팁 풍선 닫기
		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/tooltip_message")).click();
		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/tooltip_message")).click();

		driver.findElement(By.className("android.widget.TextView").name("회원인증 하기")).click();

		driver.findElement(
				By.className("android.widget.LinearLayout").id("com.skmc.okcashbag.home_google:id/regPhoneButton"))
				.click();

		driver.findElement(By.className("android.widget.ImageView").id("com.skmc.okcashbag.home_google:id/agreeAll"))
				.click();

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

		driver.findElement(
				By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/nameTextField"))
				.sendKeys("김기태");
		Thread.sleep(2000);

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/reqOtp")).click();

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/ocb_dialog_button2")).click();

		String e1 = driver
				.findElement(By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/otpNumber"))
				.getText();
		while (e1.length() != 6) {
			Thread.sleep(1000);
			e1 = driver
					.findElement(
							By.className("android.widget.EditText").id("com.skmc.okcashbag.home_google:id/otpNumber"))
					.getText();

		}
		driver.findElement(By.className("android.widget.Button").id("com.skmc.okcashbag.home_google:id/doneButton"))
				.click();

		driver.scrollTo("다음");

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/agreePersonalInfo")).click();

		driver.findElement(By.id("com.skmc.okcashbag.home_google:id/doneButton")).click();

	}

}
