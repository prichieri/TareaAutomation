package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComparePage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href$=\"remove=43\"]") // Borra MacBook de comparar
        private WebElement borraMacBookComparar;
    @FindBy(how = How.CSS, using = "a[href$=\"remove=42\"]") // Borra Apple Cinema de comparar
        private WebElement borrarCinemaComparar;
    @FindBy(how = How.CSS, using = "a[href$=\"remove=40\"]") // Borra iPhone de comparar
        private WebElement borrarIphoneComparar;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void borraComparar(WebElement locator) {
        locator.click();
    }

}
