package pages;

import org.example.stepdefinitions.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver = DriverFactory.getDriver();
    private String username = "testerboy1995@gmail.com";
    private String password = "Testerboy1995";

    @FindBy(xpath = "//*[@id=\"txtUserName\"]")
    private WebElement usernameInput;
    @FindBy(xpath = "//*[@id=\"txtPassword\"]")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userEntersUsernameAndPassword() {
        waitUntilElementVisible(usernameInput);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(5000);
    }
    private void waitUntilElementVisible(WebElement element ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
