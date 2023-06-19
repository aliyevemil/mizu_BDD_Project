package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

    public Login_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "EmailLogin")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement signin;

    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement profile;

    @FindBy(xpath = "//span[@class='policy-popup__close icon-close js-policy-close']")
    public WebElement popup;


}
