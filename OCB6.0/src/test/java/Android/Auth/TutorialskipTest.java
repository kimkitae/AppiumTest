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

@Ignore
public class TutorialskipTest {
	/**
	 * Created by daearcdo on 2016. 1. 11..
	 */

	public AndroidDriver driver;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "test");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		// File file = new File("/Users/daearcdo/OneDrive/ocb.apk");

		// capabilities.setCapability("app", file.getAbsolutePath());
		//capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
		//capabilities.setCapability("appActivity", ".activities.Entrypoint");
		capabilities.setCapability("noRest", false);
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

		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.20);
		int x2 = (int) (size.width * 0.80);
		int x3 = (int) (size.height * 0.50);

		

		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextNames);
}
        
		

		// LMB 클릭
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")));
		driver.swipe(x2, x3, x1, x3, 4000);

		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")));
		driver.swipe(x2, x3, x1, x3, 4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageView")));
		driver.swipe(x2, x3, x1, x3, 4000);
		
		
		System.out.println();
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.widget.CheckBox[1]")).click();
		
		
		
		
	}
}
