package pages;

import org.example.stepdefinitions.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    WebDriver driver = DriverFactory.getDriver();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[1]")
    private WebElement searchActivate;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/input")
    public WebElement searchInput;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[2]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"fiyat\"]/div/div/div/div[2]/div/div/div[2]/label/input")
    private WebElement priceRangeButton;

    List<String> productNames = new ArrayList<>();
    List<Integer> productPrices = new ArrayList<>();


    public void searchKeyword(String keyword) {
        waitUntilElementVisible(searchActivate);
        searchActivate.click();
        waitUntilElementVisible(searchInput);
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void selectPriceRange() throws InterruptedException {
        waitUntilElementVisible(priceRangeButton);
        priceRangeButton.click();
        Thread.sleep(5000);
    }

    public void getProductPrices(int amount){
        int count = 0;
        String price = "";
        for (int i = 0; i < 10; i++) {
            try {
                WebElement element = driver.findElement(By.xpath("//*[@id=\"i"+ i +"\"]/div/a/div[2]/div[3]"));
                waitUntilElementVisible(element);
                String priceRaw = element.getText();
                if (!priceRaw.contains("TL") || priceRaw.isEmpty() || priceRaw.equals("")|| priceRaw.contains("%")) {
                    continue;
                }else{
                    if(priceRaw.contains(",")){
                        int commaIndex = priceRaw.indexOf(',');
                        if (commaIndex != -1) {
                            price = priceRaw.substring(0, commaIndex);
                            productPrices.add(Integer.valueOf(price.replace(".", "")));
                        }
                    }else{
                        productPrices.add(Integer.valueOf(priceRaw.replace(".", "")));
                    }

                    count++;
                }
            } catch (NoSuchElementException e) {
                continue;
            }
            if(count >= amount){
                break;
            }
        }
    }

    public void getProductNames(int amount){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            try {
                WebElement element = driver.findElement(By.xpath("//*[@id=\"i"+ i +"\"]/div/a/div[2]/div[2]/h3"));
                waitUntilElementVisible(element);
                String name = element.getText();
                productNames.add(name);
                count++;
            } catch (NoSuchElementException e) {
                continue;
            }
            if(count >= amount){
                break;
            }
        }
    }
    public void compareNames(){
        int count = 0;
        for (String str : productNames) {
            if (str.toLowerCase().contains("kalem") || str.toLowerCase().contains("tükenmez") || str.toLowerCase().contains("fosforlu")) {
                System.out.println("Found keyword in: " + str);
            }else{
                count++;
            }
        }
        if (count > 0) {
            throw new IllegalStateException("There are " + count + " names that doesn't contain the keyword.");
        }
    }
    public void comparePrices(){
        int count = 0;
        for (int price : productPrices) {
            if (price >= 1100 && price <= 5700) {
                System.out.println("The price is between 1100 and 5700");
            } else {
                System.out.println("The price is not between 1100 and 5700");
                count++;
            }
        }
        if (count > 0) {
            throw new IllegalStateException("There are " + count + " prices that are not in the price range");
        }
    }

    private void waitUntilElementVisible(WebElement element ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
