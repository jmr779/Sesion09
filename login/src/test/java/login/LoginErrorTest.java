package login;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginErrorTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	  public void setUp() throws Exception {
		// Descargar Firefox driver (Gecko Driver) de https://github.com/mozilla/geckodriver/releases y copiar en carpeta drivers
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
		// Descargar Chrome driver de https://sites.google.com/a/chromium.org/chromedriver/downloads y copiar en carpeta drivers
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
		// System.setProperty("webdriver.opera.driver", "/path/to/operadriver");

		// Descargar IE driver from https://www.seleniumhq.org/download/ y copiar en carpeta drivers
		// System.setProperty("webdriver.ie.driver", "C:/path/to/IEDriverServer.exe");

		// System.setProperty("webdriver.edge.driver", "C:/path/to/MicrosoftWebDriver.exe");
		// System.setProperty("phantomjs.binary.path", "/path/to/phantomjs");

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		// driver = new HtmlUnitDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@Test
	public void testLoginError() throws Exception {
		driver.get("http://localhost:8080/login/servlet/com.example.login.MyUI$MyUIServlet");
		driver.findElement(By.id("gwt-uid-3")).click();
		driver.findElement(By.id("gwt-uid-3")).clear();
		driver.findElement(By.id("gwt-uid-3")).sendKeys("jose");
		driver.findElement(
				By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div/div/div/div/div[7]/div")).click();
		driver.findElement(By.id("gwt-uid-5")).click();
		driver.findElement(By.id("gwt-uid-5")).clear();
		driver.findElement(By.id("gwt-uid-5")).sendKeys("med");
		driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div/div/div/div/div[7]/div")).click();
	    //driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div[3]/div")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [doubleClick |
		// id=gwt-uid-15 | ]]
		}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
