package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.RegistrationPage;
import sun.rmi.runtime.Log;
import utils.PropertyLoader;
import utils.WebdriverHelper;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver = WebdriverHelper.getDriver();
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    RegistrationPage registrationPage;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    @Given("user is on the register page")
    public void user_is_on_the_register_page() {
        registrationPage = pageObjectManager.getRegistrationPage();
        registrationPage.navigateToRegistrationPage();
    }

    @When("the user fills in all the mandatory details")
    public void the_user_fills_in_all_the_mandatory_details() {
        registrationPage.fillMandatoryFields();
    }

    @And("uncheck all the news letter options")
    public void uncheck_all_the_news_letter_options() {
        registrationPage.unCheckNewsLetterOptions();
    }

    @And("uncheck all the special offer")
    public void uncheck_all_the_special_offer() {
        registrationPage.unCheckSpecialOffers();
    }

    @And("click on the register now button to register")
    public void click_on_the_register_now_button_to_register() {
        registrationPage.clickOnRegisterButton();
        WebdriverHelper.killDriver(driver);
    }


    @Given("user is on the takealot.com webpage")
    public void user_is_on_the_takealot_com_webpage() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateToLoginPage();
    }

    @When("the user enters email address")
    public void the_user_enters_email_address() {
        loginPage.enterEmailAddress(PropertyLoader.loadProperty("emailAddress"));
    }

    @And("the user enters password")
    public void the_user_enters_password() {
        loginPage.enterPassword(PropertyLoader.loadProperty("password"));
    }

    @When("click on the Login button")
    public void click_on_the_Login_button() {
        loginPage.clickOnLogin();
        WebdriverHelper.killDriver(driver);
    }

    @Then("the user should land on the home page with his name displayed on the navigation bar")
    public void the_user_should_land_on_the_home_page_with_his_name_displayed_on_the_navigation_bar() {
        Assert.assertEquals("Hi Test", homePage.accountUserName());
    }


    @Given("the user is in the homepage")
    public void the_user_is_in_the_homepage() {
        homePage = pageObjectManager.getHomePage();
        Assert.assertEquals("https://www.takealot.com/", homePage.homePageUrl());
    }

    @When("the user types GiGABYTE Solid state drive 120GB in the search bar")
    public void the_user_types_GiGABYTE_Solid_state_drive_120GB_in_the_search_bar() {
        homePage.perform_Search(PropertyLoader.loadProperty("searchItem"));
    }

    @And("the user click on the search button")
    public void the_user_click_on_the_search_button() {
        homePage.clickOnSearchIcon();
    }

    @Then("the user should be presented with the searched product")
    public void the_user_should_be_presented_with_the_searched_product() {
        Assert.assertTrue(homePage.productSearchResults().contains(PropertyLoader.loadProperty("searchItem")));
        WebdriverHelper.killDriver(driver);
    }

    @Given("the user is on the product page")
    public void the_user_is_on_the_product_page() {
        homePage.clickOnProduct();
        WebdriverHelper.waitForNewPageToLoad(driver);
    }

    @Then("the user should see the price of the product")
    public void the_user_should_see_the_price_of_the_product() {
        productPage = pageObjectManager.getProductPage();
        int priceOfTheProduct = productPage.verifyProductPrice();
        System.out.println(priceOfTheProduct);
    }
}
