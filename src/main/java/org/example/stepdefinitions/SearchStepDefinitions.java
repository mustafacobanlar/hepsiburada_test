package org.example.stepdefinitions;

import io.cucumber.java.en.When;
import pages.*;

public class SearchStepDefinitions {

    private SearchPage searchPage;

    public SearchStepDefinitions() {
        searchPage = new SearchPage(DriverFactory.getDriver());
    }

    @When("I search for the keyword kalem")
    public void i_search_for_the_keyword() throws InterruptedException {
        //homePage.hoverOverLoginArea();
        searchPage.searchKeyword("kalem");
    }
}
