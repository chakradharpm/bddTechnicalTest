package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "div.buybox-module_price_2YUFa>span.currency-module_currency_29IIm")
    private WebElement productPrice;


    public int verifyProductPrice(){
        String price = productPrice.getText();
        return Integer.parseInt(price);
    }

}
