package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import  Pages.CheckoutPage;

public class CarroPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = ".btn-block .form-control") // Cantidad de producto
        public WebElement cantProd;
    @FindBy(how = How.CSS, using = "i.fa.fa-refresh") // Actualiza producto
        private WebElement refreshProd;
    @FindBy(how = How.XPATH, using = "//button[@data-original-title=\"Remove\"]") //
        public WebElement borraCarro;
    @FindBy(how = How.CSS, using = "[title~=Shopping]") //
        private WebElement entrarACarro;
    @FindBy(how = How.CSS, using = "[href$=\"path=24\"]") //
        private WebElement entraTelefonos;
    @FindBy(how = How.CSS, using = ".table-responsive .text-left a") //
        public WebElement nomProd;
    @FindBy(how = How.CSS, using = "#cart-total") //
        public WebElement totalCarro;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"cart.add(\'43\');\"]") //
        private WebElement carroMacBook;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'29\', \'1\');\"]") //
        private WebElement carroPalm;

    public CarroPage(WebDriver driver) {
        this.driver = driver;
    }
    public void catProduct(String text) {
        cantProd.clear();
        cantProd.sendKeys(text);
        refreshProd.click();
    }
    public void delCarro() {
        borraCarro.click();
    }


}
