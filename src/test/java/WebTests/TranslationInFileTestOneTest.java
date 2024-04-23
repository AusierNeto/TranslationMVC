package WebTests;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TranslationInFileTestOneTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeAll
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\arles\\Downloads\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterAll
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void translationInFileTestOne() {
    driver.get("http://localhost:8080/TranslatorProject/TranslatorProject/");
    driver.manage().window().setSize(new Dimension(961, 821));
    driver.findElement(By.name("inputString")).click();
    driver.findElement(By.name("inputString")).sendKeys("Information");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.cssSelector("h2:nth-child(3)")).click();
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.cssSelector("h2:nth-child(4)")).click();
    assertEquals("Word translation: Informação", driver.findElement(By.cssSelector("h2:nth-child(4)")).getText());
    driver.findElement(By.cssSelector("h2:nth-child(3)")).click();
    assertEquals("Original word: Information", driver.findElement(By.cssSelector("h2:nth-child(3)")).getText());
  }
}
