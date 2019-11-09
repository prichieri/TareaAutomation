package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PhonePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@onclick=\"cart.add(\'29\', \'1\');\"]") // Compra Palm
        public WebElement carroPalm;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"cart.add(\'28\', \'1\');\"]") // Compra HTC
        public WebElement carroHtc;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'28\');\"]") // Compara HTC
        public WebElement compareHtc;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"compare.add(\'29\');\"]") // Compara Palm
        public WebElement comparePalm;

    public PhonePage(WebDriver driver) {
        this.driver = driver;
    }

    public void accesPhone(WebElement locator) {
        locator.click();
    }

}