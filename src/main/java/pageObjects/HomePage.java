package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverHelper;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@class='search-field ']")
    private WebElement searchField;

    @FindBy(how = How.CSS, using = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "div.auto .top-nav-module_name-item_3ROu0")
    private WebElement nameOfTheUser;

    @FindBy(how = How.ID, using = "53705822")
    private WebElement productLink;

    @FindBy(how = How.CSS, using = "div.search-count")
    private WebElement searchResults;


    public void perform_Search(String text){
        searchField.sendKeys(text);
    }

    public void clickOnSearchIcon(){
        searchButton.click();
    }

    public void clickOnProduct(){
        productLink.click();
        WebdriverHelper.waitForNewPageToLoad(driver);
    }

    public String accountUserName(){
        return nameOfTheUser.getText();
    }

    public String homePageUrl(){
        return WebdriverHelper.getCurrentPageUrl(driver);
    }

    public String productSearchResults(){
        return searchResults.getText();
    }
}
