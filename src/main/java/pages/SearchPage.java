package pages;

import org.example.stepdefinitions.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    WebDriver driver = DriverFactory.getDriver();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#SearchBoxOld_b2ae2209-616b-46ee-2ca0-961306173631 > div > div > div.searchBoxOld-M1esqHPyWSuRUjMCALPK > div.searchBoxOld-P2GCKq3V7DvEXIgWsSCP")
    private WebElement searchActivate;

    @FindBy(xpath = "//*[@id=\"SearchBoxOld_a1424806-eba3-4d5c-8d53-2ae477bb1f24\"]/div/div/div[1]/div[2]/input")
    public WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"SearchBoxOld_50243b86-dd8c-4bc6-b54a-d581ffea2e83\"]/div/div/div[2]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"fiyat\"]/div/div/div/div[2]/div/div/div[2]/label/div/div")
    private WebElement priceRangeButton;

    public void searchKeyword(String keyword) {
        //waitUntilElementVisible(searchActivate);
        searchActivate.click();
        waitUntilElementVisible(searchInput);
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void selectPriceRange(){
        waitUntilElementVisible(priceRangeButton);
        priceRangeButton.click();
    }

    private void waitUntilElementVisible(WebElement element ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
