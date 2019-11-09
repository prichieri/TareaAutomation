package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WishPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href$=\"remove=43\"]") // Borra MacBook de wish list
    public WebElement borraMacBookWish;
    @FindBy(how = How.CSS, using = "a[href$=\"remove=42\"]") // Borra Apple Cinema de wish list
    public WebElement borraCinemaWish;
    @FindBy(how = How.CSS, using = "a[href$=\"remove=40\"]") // Borra Apple iPhone de wish list
    public WebElement borraIphoneWish;
    @FindBy(how = How.CSS, using = "a[href$=\"remove=30\"]") // Borra Canon de wish list
    public WebElement borraCanonWish;
    @FindBy(how = How.CSS, using = "#content h2") // Borra Canon de wish list
    public WebElement title;
    @FindBy(how = How.CSS, using = ".table .text-left a") // Borra Canon de wish list
    public WebElement elemWish;

    public WishPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeWish(WebElement locator) {
        locator.click();
    }











}
