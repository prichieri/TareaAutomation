package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#cart-total") // Total carro
    private WebElement total;
    @FindBy(how = How.CSS, using = "[value~=guest]") // Opcione guest checkout
    private WebElement guest;
    @FindBy(how = How.CSS, using = "#button-account") // Boton continuar 1
    private WebElement conti1;
    @FindBy(how = How.CSS, using = "#input-payment-country") // Campo pais
    private WebElement ordPais;
    @FindBy(how = How.CSS, using = "#input-payment-firstname") // Campo nombre
    private WebElement ordNombre;
    @FindBy(how = How.CSS, using = "#input-payment-lastname") // Campo apellido
    private WebElement ordApellido;
    @FindBy(how = How.CSS, using = "#input-payment-email") // Campo email
    private WebElement ordEmail;
    @FindBy(how = How.CSS, using = "#input-payment-telephone") // Campo telefono
    private WebElement ordPhone;
    @FindBy(how = How.CSS, using = "#input-payment-address-1") // Campo direccion
    private WebElement ordAddress;
    @FindBy(how = How.CSS, using = "#input-payment-city") // Campo ciudad
    private WebElement ordCity;
    @FindBy(how = How.CSS, using = "#input-payment-postcode") // Campo postcode
    private WebElement ordPostcode;
    @FindBy(how = How.CSS, using = "#input-payment-zone") // Campo zona
    private WebElement ordZone;
    @FindBy(how = How.CSS, using = "#button-guest") // Boton continuar 2
    private WebElement conti2;
    @FindBy(how = How.CSS, using = "#button-shipping-method") // Boton continuar 3
    private WebElement conti3;
    @FindBy(how = How.CSS, using = "input[name=\"agree\"]") // Terminos y condicones
    private WebElement ordTerCond;
    @FindBy(how = How.CSS, using = "#button-payment-method") // Boton continuar 4
    private WebElement conti4;
    @FindBy(how = How.CSS, using = "#button-confirm") // Boton continuar 5
    private WebElement conti5;

    @FindBy(how = How.CSS, using = "#content p") // Confirmar orden
    public WebElement confOrder;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pau(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void guestCheckout() {
        guest.click();
        conti1.click();
        pau(1000); // Pausa
        ordPais.sendKeys("Uruguay");
        ordNombre.sendKeys("name");
        ordApellido.sendKeys("last");
        ordEmail.sendKeys("email@gmail.com");
        ordPhone.sendKeys("123456789");
        ordAddress.sendKeys("Calle 1234");
        ordCity.sendKeys("Montevideo");
        ordPostcode.sendKeys("11800");
        ordZone.sendKeys("Montevideo");
        conti2.click();
        pau(1500); // Pausa
        conti3.click(); // Boton continuar
        pau(1500); // Pausa
        ordTerCond.click(); // Acepto terminos y condicones
        conti4.click(); // Boton continuar
        pau(1500); // Pausa
        conti5.click(); // Boton confirmar orden
        pau(1500);
    }







}
