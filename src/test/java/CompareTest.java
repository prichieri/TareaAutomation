import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class CompareTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  public void pau(int x) {
    try {
      Thread.sleep(x);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized"); // open Browser in maximized mode
    options.addArguments("disable-infobars"); // disabling infobars
    options.addArguments("--disable-extensions"); // disabling extensions
    options.addArguments("--disable-gpu"); // applicable to windows os only
    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
    options.addArguments("--no-sandbox"); // Bypass OS security model
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void compare() {
    driver.get("http://opencart.abstracta.us/index.php?route=common/home"); // Abre la web
    driver.findElement(By.xpath("//button[@onclick=\"compare.add(\'43\');\"]")).click(); // Agrega MacBook a comparar
    pau(1000); // Pausa
    driver.findElement(By.xpath("//button[@onclick=\"compare.add(\'42\');\"]")).click(); // Agrega Apple Cinema a comparar
    pau(1000); // Pausa
    driver.findElement(By.xpath("//button[@onclick=\"compare.add(\'40\');\"]")).click(); // Agrega iPhone a comparar
    pau(1000); // Pausa
    driver.findElement(By.cssSelector("a[href$=\"compare\"]")).click(); // Entra a menu comparar
    {
      WebElement textToValidate = driver.findElement(By.cssSelector("[href$=\"id=42\"] strong")); // Verifica que el ultimo
      assertEquals(textToValidate.getText(), "Apple Cinema 30\"");                      // elemento sea Apple Cinema
    }
    driver.findElement(By.cssSelector("a[href$=\"remove=43\"]")).click(); // Borra MacBook de comparar
    driver.findElement(By.cssSelector("a[href$=\"remove=42\"]")).click(); // Borra Apple Cinema de comparar
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("a[href$=\"remove=42\"]"));
      assertEquals(elements.size(),0); // Verifica que Apple Cinema no este en comparar
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("a[href$=\"remove=43\"]"));
      assertEquals(elements.size(),0);  // Verifica que MacBook no este en comparar
    }
    driver.findElement(By.cssSelector("[href$=\"path=24\"]")).click(); // Entra en telefonos
    driver.findElement(By.xpath("//button[@onclick=\"compare.add(\'28\');\"]")).click(); // Agrega HTC a comparar
    pau(1000); // Pausa
    driver.findElement(By.xpath("//button[@onclick=\"compare.add(\'29\');\"]")).click(); // Agrega Palm a comparar
    pau(1000); // Pausa
    driver.findElement(By.cssSelector("a[href$=\"compare\"]")).click(); // Entra a menu comparar
    pau(1000);
    driver.findElement(By.cssSelector("a[href$=\"remove=40\"]")).click(); // Borra iPhone de comparar
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("a[href$=\"remove=40\"]"));
      assertEquals(elements.size(),0); // Verifica que iPhone no este en comparar
    }
  }
}
