import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TranslationInFileTestTwoTest {
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
  public void translationInFileTestTwo() {
    driver.get("http://localhost:8080/TranslatorProject/");
    driver.manage().window().setSize(new Dimension(961, 821));
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.name("inputString")).click();
    driver.findElement(By.name("inputString")).click();
    {
      WebElement element = driver.findElement(By.name("inputString"));
      element.clear();
    }
    driver.findElement(By.name("inputString")).sendKeys("Head");
    driver.findElement(By.cssSelector("input:nth-child(2)")).click();
    driver.findElement(By.cssSelector("h2:nth-child(4)")).click();
    assertEquals("Word translation: Cabeça", driver.findElement(By.cssSelector("h2:nth-child(4)")).getText());
  }
}
