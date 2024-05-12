package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.time.Duration;

public class LoginStepDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;

    public LoginStepDefinitions() {
        homePage = new HomePage(DriverFactory.getDriver());
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() throws InterruptedException {
        homePage.navigateToHomePage();
    }

    @When("I go to the login page")
    public void i_go_to_the_login_page() throws InterruptedException {
        //homePage.hoverOverLoginArea();
        homePage.clickLoginButton();
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        loginPage.userEntersUsernameAndPassword();
    }

    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        loginPage.clickSubmitButton();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Implement verification of successful login
    }

}