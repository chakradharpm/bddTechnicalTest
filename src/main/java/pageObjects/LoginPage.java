package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverHelper;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement pwd;

    @FindBy(how = How.CSS, using = "button.g-recaptcha")
    private WebElement loginButton;

    public void navigateToLoginPage(){
        WebdriverHelper.navigateToURL("https://secure.takealot.com/account/login", driver);
    }

    public void enterEmailAddress(String emailAddress){
        email.sendKeys(emailAddress);
    }

    public void enterPassword(String passwd){
        pwd.sendKeys(passwd);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

}
