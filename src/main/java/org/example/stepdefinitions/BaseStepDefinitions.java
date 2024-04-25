package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseStepDefinitions {

    public WebDriver newDriver;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mustafa.cobanlar\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        newDriver = new ChromeDriver(options);

        newDriver.get("https://www.hepsiburada.com/");

        newDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("done");
    }
}