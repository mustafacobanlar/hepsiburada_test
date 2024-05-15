package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class SearchStepDefinitions {

    private SearchPage searchPage;

    public SearchStepDefinitions() {
        searchPage = new SearchPage(DriverFactory.getDriver());
    }

    @When("I search for the keyword")
    public void i_search_for_the_keyword(){
        searchPage.searchKeyword("kalem");
    }

    @And("I filter products for the price range")
    public void i_filter_products() throws InterruptedException {
        searchPage.selectPriceRange();
    }
    @And("I get prices from 3 products")
    public void i_get_product_prices() {
        searchPage.getProductPrices(3);
    }
    @And("I get names from 3 products")
    public void i_get_product_names() {
        searchPage.getProductNames(3);
    }

    @Then("Product prices should be within the range")
    public void i_compare_prices() {
        searchPage.comparePrices();
    }
    @Then("Product names should contain the keyword")
    public void i_compare_names() {
        searchPage.compareNames();
    }
}
