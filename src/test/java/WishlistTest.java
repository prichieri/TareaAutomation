import Pages.HomePage;
import Pages.RegisterPage;
import Pages.WishPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class WishlistTest {
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
    driver.findElement(By.cssSelector("a[href$=\"remove=30\"]")).click(); // Borra Canon de la lista
    driver.quit();
  }

  @Test
  public void wishlist() {
    driver.get("http://opencart.abstracta.us/index.php?route=common/home"); // Abre la web
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    RegisterPage reg = PageFactory.initElements(driver,RegisterPage.class);
    WishPage wish = PageFactory.initElements(driver,WishPage.class);
    home.goCuenta();
    home.goLogin();
    home.validateText(reg.forgotten,"Forgotten Password");
    home.doLogin("mb22@gmail.com");
    home.validateText(reg.account, "My Account");
    home.goHome();
    home.wishProduct(home.wishMacBook); // Agrega MacBook al la lista
    pau(1000); // Pausa
    home.wishProduct(home.wishIphone); // Agrega iPhone al la lista
    pau(1000); // Pausa
    home.wishProduct(home.wishCinema); // Agrega Apple Cinema al la lista
    pau(1000); // Pausa
    home.wishProduct(home.wishCanon); // Agrega Canon al la lista
    pau(1000); // Pausa
    home.goWish(); // Enta a la lista
    home.validateText(wish.title, "My Wish List");   // en la lista
    wish.removeWish(wish.borraIphoneWish); // Borra iPhone de la lista
    wish.removeWish(wish.borraCinemaWish); // Borra Apple Cinema de la lista
    wish.removeWish(wish.borraMacBookWish); // Borra MacBook de la lista
    home.validateText(wish.elemWish,"Canon EOS 5D"); // Verifica que Canon
  }
}

