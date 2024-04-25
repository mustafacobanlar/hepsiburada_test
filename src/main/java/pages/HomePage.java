package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mustafa.cobanlar\\chromedriver");
        this.driver = driver;
        PageFactory.initElements(driver, this);
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