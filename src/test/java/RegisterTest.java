import Pages.HomePage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class RegisterTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  // E-mail Builder
  String x = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private String createMail(int count) {
      StringBuilder builder = new StringBuilder();
      while (count-- != 0) {
        int character = (int)(Math.random()*x.length());
        builder.append(x.charAt(character));
      }
    String a = builder.toString();
    String b = "@gmail.com";
    return a+b;
  }
  String mail = createMail(7);
  WebElement textToValidate;

  /*@BeforeClass
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
  }*/

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void register() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    RegisterPage reg = PageFactory.initElements(driver,RegisterPage.class);
    home.openWeb();
    home.goCuenta();
    home.goRegistrar();
    home.validateText(reg.titleFound, "Register Account");
    reg.registroUsuario();
    home.validateText(reg.titleFound, "Your Account Has Been Created!");
    home.goCuenta();
    home.goLogout();
    home.validateText(reg.titleFound,"Account Logout");
    home.goCuenta();
    home.goLogin();
    home.validateText(reg.forgotten,"Forgotten Password");
    home.doLogin(mail);
    home.validateText(reg.account, "My Account");
  }
}
