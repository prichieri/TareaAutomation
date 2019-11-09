import Pages.CarroPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.PhonePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class CarroTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

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

  /*@AfterClass
  public void tearDown() {
    driver.quit();
  }*/

  @Test
  public void carro() {
    driver.get("http://opencart.abstracta.us/index.php?route=common/home"); // Abre la Web
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    home.carroMacBook.click(); // Agrega MacBook al carro
    home.entrarCarro.click(); //Entra en el carro
    CarroPage carr = PageFactory.initElements(driver, CarroPage.class);
    carr.catProduct("10");
    CheckoutPage che = PageFactory.initElements(driver, CheckoutPage.class);
    home.validateValue(carr.cantProd,"10"); // Verifica que la cantidad del producto sea 10
    carr.delCarro(); // Borra MacBook del carro
    che.pau(500);
    home.entraTelefonos.click();
    PhonePage tel = PageFactory.initElements(driver, PhonePage.class);
    tel.accesPhone(tel.carroPalm); // Agrega Palm al carro
    home.entrarCarro.click(); // Entra en el carro
    home.validateText(carr.nomProd,"Palm Treo Pro"); // Verifica que el producto sea una Palm
  }

}
