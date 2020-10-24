package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyLoader;
import utils.WebdriverHelper;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "firstname")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "surname")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "email2")
    private WebElement retypeEmail;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwd;

    @FindBy(how = How.ID, using = "password2")
    private WebElement retypepasswd;

    @FindBy(how = How.ID, using = "telno1")
    private WebElement mobileNo;

    @FindBy(how = How.ID, using = "newsletter_general")
    private WebElement newsLetterOptions1;

    @FindBy(how = How.ID, using = "newsletter_daily-deals")
    private WebElement newsLetterOptions2;

    @FindBy(how = How.ID, using = "smsPromotions")
    private WebElement specialOffers1;

    @FindBy(how = How.ID, using = "partnerPromotions")
    private WebElement specialOffers2;

    @FindBy(how = How.ID, using = "")
    private WebElement registerNowButton;

    public void navigateToRegistrationPage(){
        WebdriverHelper.navigateToURL(PropertyLoader.loadProperty("url"),driver);
    }

    public void fillMandatoryFields(){
        firstName.sendKeys("TestFirstName");
        lastName.sendKeys("TestLastName");
        email.sendKeys(PropertyLoader.loadProperty("emailAddress"));
        retypeEmail.sendKeys(PropertyLoader.loadProperty("emailAddress"));
        passwd.sendKeys(PropertyLoader.loadProperty("password"));
        retypepasswd.sendKeys(PropertyLoader.loadProperty("password"));
        mobileNo.sendKeys("07715646440");

    }

    public void unCheckNewsLetterOptions(){
        newsLetterOptions1.click();
        newsLetterOptions2.click();
    }

    public void unCheckSpecialOffers(){
        specialOffers1.click();
        specialOffers2.click();
    }

    public void clickOnRegisterButton(){
        WebdriverHelper.javaScriptExecutor("document.querySelector('input.btn').click()",driver);
    }
}
