package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private String baseUrl = "https://www.hepsiburada.com/";

    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/span[2]")
    private WebElement loginArea;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement cookieApprovalButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(baseUrl);
        clickCookieApprovalButton();
    }

    public void clickLoginButton() {
        Actions actions = new Actions(driver);
        waitUntilElementVisible(loginArea);
        actions.moveToElement(loginArea).perform();
        waitUntilElementInteractable(loginButton);

        // Introduce a small delay before clicking the login button
        try {
            Thread.sleep(1000); // Adjust the delay time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginButton.click();
    }

    private void waitUntilElementVisible(WebElement element ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    private void waitUntilElementInteractable(WebElement element ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickCookieApprovalButton() {
        waitUntilElementVisible(cookieApprovalButton);
        cookieApprovalButton.click();
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void close() {
        driver.quit();
    }
}
