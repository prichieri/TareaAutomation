package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class HomePage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "[title~=Shopping]") // Ir al carro
        public WebElement entrarCarro;
    @FindBy(how = How.CSS, using = "a[href$=\"compare\"]") // Ir a comparar
        private WebElement entrarComparar;
    @FindBy(how = How.CSS, using = "#wishlist-total") // Ir a comparar
        private WebElement entrarWish;
    @FindBy(how = How.CSS, using = "a[href$=\"checkout\"]") // Ir a checkout
        private WebElement entraCheckout;
    @FindBy(how = How.CSS, using = "[href$=\"path=24\"]") // Ir a telefonos
        public WebElement entraTelefonos;

    @FindBy(how = How.XPATH, using = "//button[@onclick=\"cart.add(\'43\');\"]") // Comprar MacBook
        public WebElement carroMacBook;

    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'43\');\"]") // Compara MacBook
        private WebElement comparaMacBook;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'42\');\"]") // Compara Cinema
        private WebElement comparaCinema;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'40\');\"]") // Compara Iphone
        private WebElement comparaIphone;

    @FindBy(how = How.CSS, using = "input[name=\"search\"]") // Campo de busqueda
        public WebElement search;
    @FindBy(how = How.CSS, using = "i.fa.fa-search") // Boton busqueda
        public WebElement botonSearch;
    @FindBy(how = How.CSS, using = "h4 a") // Titulo busqueda
    public WebElement searchTitle;

    @FindBy(how = How.CSS, using = "a[href$=\"account\"]") // Ir al cuenta
        private WebElement menuCuenta;
    @FindBy(how = How.CSS, using = "a[href$=\"register\"]") // Ir a registrar
        private WebElement menuRegistrar;
    @FindBy(how = How.CSS, using = ".dropdown-menu a[href$=\"logout\"]") // Ir a logout
        private WebElement menuLogout;
    @FindBy(how = How.CSS, using = "a[href$=\"login\"]") // Ir a login
        private WebElement menuLogin;

    @FindBy(how = How.XPATH, using = "//button[@onclick=\"wishlist.add(\'43\');\"]") // Comprar MacBook
        public WebElement wishMacBook;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"wishlist.add(\'40\');\"]") // Comprar MacBook
        public WebElement wishIphone;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"wishlist.add(\'42\');\"]") // Comprar MacBook
        public WebElement wishCinema;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"wishlist.add(\'30\');\"]") // Comprar MacBook
        public WebElement wishCanon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWeb () {
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
    }
    public void goHome() {
        driver.findElement(By.cssSelector("img.img-responsive")).click();
    }
    public void goCarro() {
        entrarCarro.click(); // Va al Carro
    }
    public void goComparar() {
        entrarComparar.click(); // Va a menu comparar
    }
    public void goWish() {
        entrarWish.click();
    }
    public void goCheckout() {
        entraCheckout.click(); // Va a menu checkout
    }
    public void goTelefonos() {
        entraTelefonos.click(); // Va a menu telefonos
    }

    public void goCuenta() {
        menuCuenta.click(); // Va a menu cuenta
    }
    public void goRegistrar() {
        menuRegistrar.click(); // Va a menu registrar
    }

    public void buyProduct(WebElement locator) {
        locator.click(); //
    }

    public void comparaProducto(WebElement locator) {
        locator.click(); //
    }

    public void searchProd(String text) {
        (search).sendKeys(text);
        (botonSearch).click();
    }

    public void goLogout() {
        menuLogout.click();
    }
    public void goLogin() {
        menuLogin.click();
    }

    public void wishProduct(WebElement locator) {
        locator.click();
    }

    public void doLogin(String mail) {
        driver.findElement(By.cssSelector("#input-email")).sendKeys(mail); // Ingresa usuario
        driver.findElement(By.cssSelector("#input-password")).sendKeys("hola2019"); // Ingresa contrasena
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click(); // Boton continuar
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void validateText(WebElement locator, String text) {
        WebElement textToValidate = locator;
        assertEquals(textToValidate.getText(), text);
    }

    public void validateValue(WebElement locator, String text) {
        WebElement textToValidate = locator;
        assertEquals(textToValidate.getAttribute("value"), text);
    }

    public void noEstaProd(List<WebElement> locator) {
        List<WebElement> elements = locator;
        assertEquals(elements.size(),0);
    }

}
