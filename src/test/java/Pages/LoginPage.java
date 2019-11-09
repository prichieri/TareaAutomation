package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#input-email") // Campo de usuario
        private WebElement usuario;
    @FindBy(how = How.CSS, using = "#input-password") // Campo contrasena
        private WebElement password;
    @FindBy(how = How.CSS, using = "input[type=\"submit\"]") // Boton ingresar
        private WebElement ingresar;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hacerLogin(String user, String pass) {
        usuario.sendKeys(user);
        password.sendKeys(pass);
        ingresar.click();
    }

}
