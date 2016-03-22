package TestSuite1;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;

import org.sikuli.script.Screen;

public class ImageCompareTest {
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
		// capabilities.setCapability("unicodeKeyboard", true);
		// capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("appPackage", "com.skmc.okcashbag.home_google");
		capabilities.setCapability("appActivity", ".activities.Entrypoint");
		capabilities.setCapability("noRest", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException, FindFailed {

		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]"))
				.click();
		Thread.sleep(2000);

		// 전체스크린샷 캡쳐 후 임시 폴더에 저장
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// List<WebElement>에 찾고자 하는 영역의 오브젝트 정보 저장
		List<WebElement> imageList = driver.findElementsByXPath(
				"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[2]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]");

		WebElement image = imageList.get(0);

		// 해당 오브젝트의 Location값 저장
		Point point = image.getLocation();

		// 해당 오브젝트의 높이, 넓이 값 저장
		int width = image.getSize().getWidth();
		int height = image.getSize().getHeight();
		// 이미지 읽어오기
		BufferedImage img = ImageIO.read(screen);

		// 해당 오브젝트의 Location값과, X, Y 값 만큼만 잘라내기
		BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width, height);

		// 이미지 파일 생성
		ImageIO.write(dest, "png", screen);
		System.out.println("/Users/daearcdo/Downloads/imageequ/" + screen.getName());

		// 지정한 경로 및 Screen 이름으로 파일 복사
		File file = new File("/Users/daearcdo/Downloads/imageequ/" + screen.getName());
		FileUtils.copyFile(screen, file);

		// 이미지의 데이터로 비교
		dataImage("/Users/daearcdo/Downloads/imageequ/" + screen.getName(),
				"/Users/daearcdo/Downloads/imageequ/test1.png");
		// 이미지의 픽셀정보로 비교
		pixelImage("/Users/daearcdo/Downloads/imageequ/" + screen.getName(),
				"/Users/daearcdo/Downloads/imageequ/test1.png");
	}

	public void dataImage(String image1, String image2) throws IOException {
		File firstImage = new File(image1);
		File secondImage = new File(image2);

		// 첫번째 이미지를 로드하여 변수에 저장
		BufferedImage firstInput = ImageIO.read(firstImage);
		// 이미지를 1개의 타일 정보를 저장
		DataBuffer firstdataInput = firstInput.getData().getDataBuffer();
		// 해당 이미지 사이즈를 저장
		int firstsizeInput = firstdataInput.getSize();

		// 두번째 이미지를 로드하여 변수에 저장
		BufferedImage secondInput = ImageIO.read(secondImage);
		DataBuffer seconddataInput = secondInput.getData().getDataBuffer();
		int secondsizeInput = seconddataInput.getSize();
		Boolean matchFlag = true;
		if (firstsizeInput == secondsizeInput) {
			for (int j = 0; j < firstsizeInput; j++) {
				if (firstdataInput.getElem(j) != seconddataInput.getElem(j)) {
					matchFlag = false;
					break;
				}
			}
		} else
			matchFlag = false;
		// Assert.assertTrue("이미지가 동일하지 않습니다.", matchFlag);
		if (matchFlag == true) {
			System.out.println("이미지 데이터 배열을 이용한 이미지 비교 : 이미지가 동일 합니다.");
		} else {
			System.out.println("이미지 데이터 배열을 이용한 이미지 비교 : 이미지가 동일하지 않습니다.");
		}
	}

	static void pixelImage(String file1, String file2) {

		Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

		try {
			// 이미지를 Grab (객체, Y값, X값, 넓이, 높이, RGB 컨버터 여부)
			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

			int[] data1 = null;

			if (grab1.grabPixels()) {
				// 로드한 이미지의 넓이와 높이 값 가져오기 및 픽셀 정보를 배열로 저장 
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}

			int[] data2 = null;

			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}

			System.out.println("이미지 픽셀을 이용한 이미지 비교하기 : " + java.util.Arrays.equals(data1, data2));

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
