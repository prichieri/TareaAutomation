package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#input-country") // Campo pais
        private WebElement regPais;
    @FindBy(how = How.CSS, using = "#input-city") // Campo ciudad
        private WebElement regCity;
    @FindBy(how = How.CSS, using = "#input-firstname") // Campo nombre
        private WebElement regName;
    @FindBy(how = How.CSS, using = "#input-lastname") // Campo apellido
        private WebElement regApellido;
    @FindBy(how = How.CSS, using = "#input-email") // Campo email
        private WebElement regEmail;
    @FindBy(how = How.CSS, using = "#input-telephone") // Campo telefono
        private WebElement regPhone;
    @FindBy(how = How.CSS, using = "#input-address-1") // Campo direccion
        private WebElement regAddress;
    @FindBy(how = How.CSS, using = "#input-postcode") // Campo direccion
        private WebElement regPostcode;
    @FindBy(how = How.CSS, using = "#input-zone") // Campo direccion
        private WebElement regZone;
    @FindBy(how = How.CSS, using = "#input-password") // Campo direccion
        private WebElement regPassword;
    @FindBy(how = How.CSS, using = "#input-confirm") // Campo direccion
        private WebElement regConfirm;
    @FindBy(how = How.CSS, using = "input[name=\"agree\"]") // Campo direccion
        private WebElement regTerCond;
    @FindBy(how = How.CSS, using = "input[type=\"submit\"]") // Campo direccion
        private WebElement regContinuar;
    @FindBy(how = How.CSS, using = "#content h1") // Campo Titulo
        public WebElement titleFound;
    @FindBy(how = How.CSS, using = "a[href$=\"forgotten\"]") // Campo direccion
        public WebElement forgotten;
    @FindBy(how = How.CSS, using = "a[href$=\"account\"]") // Campo direccion
        public WebElement account;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public void registroUsuario() {
        regPais.sendKeys("Uruguay");
        regCity.sendKeys("Montevideo");
        regName.sendKeys("Nombre");
        regApellido.sendKeys("Apellido");
        regEmail.sendKeys(mail);
        regPhone.sendKeys("123456789");
        regAddress.sendKeys("Calle 1234");
        regPostcode.sendKeys("11800");
        regZone.sendKeys("Montevideo");
        regPassword.sendKeys("hola2019");
        regConfirm.sendKeys("hola2019");
        regTerCond.click();
        regContinuar.click();
    }


}
