import Pages.CarroPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.PhonePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class OrderTest {
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
  public void order() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    PhonePage pho = PageFactory.initElements(driver, PhonePage.class);
    CarroPage car = PageFactory.initElements(driver, CarroPage.class);
    CheckoutPage che = PageFactory.initElements(driver, CheckoutPage.class);
    home.openWeb(); // Abre la web
    home.searchProd("htc"); // Buscar HTC
    home.validateText(home.searchTitle,"HTC Touch HD");       // HTC fue encontrado
    pho.accesPhone(pho.carroHtc);
    home.goCarro();
    home.validateText(car.nomProd,"HTC Touch HD");
    home.goCheckout();
    home.validateText(car.totalCarro,"1 item(s) - $122.00");
    che.guestCheckout();
    home.validateText(che.confOrder,"Your order has been successfully processed!");
  }
}
