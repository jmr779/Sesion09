package login;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginError() throws Exception {
    driver.get("http://localhost:8080/login/servlet/com.example.login.MyUI$MyUIServlet");
    driver.findElement(By.id("gwt-uid-15")).click();
    driver.findElement(By.id("gwt-uid-15")).clear();
    driver.findElement(By.id("gwt-uid-15")).sendKeys("jose");
    driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div/div/div/div/div[7]/div")).click();
    driver.findElement(By.id("gwt-uid-17")).click();
    driver.findElement(By.id("gwt-uid-17")).clear();
    driver.findElement(By.id("gwt-uid-17")).sendKeys("med");
    driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div/div/div/div/div[9]/div")).click();
    driver.findElement(By.id("gwt-uid-15")).click();
    driver.findElement(By.id("gwt-uid-15")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=gwt-uid-15 | ]]
    driver.findElement(By.id("gwt-uid-15")).clear();
    driver.findElement(By.id("gwt-uid-15")).sendKeys("Medina");
    driver.findElement(By.id("gwt-uid-17")).clear();
    driver.findElement(By.id("gwt-uid-17")).sendKeys("jmedina");
    driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div/div/div/div/div[9]/div")).click();
    driver.findElement(By.xpath("//div[@id='login-103149417']/div/div[2]/div/div/div/div/div[3]/div")).click();
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
