package pages;

import org.example.stepdefinitions.DriverFactory;
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
    WebDriver driver = DriverFactory.getDriver();
    private String baseUrl = "https://www.hepsiburada.com/";

    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/span[2]")
    private WebElement loginArea;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement cookieApprovalButton;
    @FindBy(xpath = "//*[@id=\"myAccount\"]/div")
    private WebElement menu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() throws InterruptedException {
        driver.get(baseUrl);
        clickCookieApprovalButton();
        Thread.sleep(5000);
    }

    public void clickLoginButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        waitUntilElementVisible(loginArea);
        actions.moveToElement(loginArea).perform();
        Thread.sleep(5000);
        actions.moveToElement(menu).perform();
        waitUntilElementInteractable(loginButton);
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
