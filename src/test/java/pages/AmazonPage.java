package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//a[@class='nav-a nav-a-2   nav-progressive-attribute'] )[1]")
    public WebElement konto;

 @FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
    public WebElement anmelden;
 @FindBy(className = "a-input-text a-span12 auth-autofocus auth-required-field")
    public WebElement email;
 @FindBy(className= "a-button-input")
    public WebElement weiter;


}
