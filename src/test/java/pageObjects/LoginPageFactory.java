package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory {

    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver,this);
        // Lazy load
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
        PageFactory.initElements(factory,this);
    }

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    @FindBy(className = "error")
    private WebElement errorFrame;

    public MainPage loginToApp(String username, String password){
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);

    }

    public void open(String url){
        driver.get(url);
    }

    public boolean isError() {
        try {
            return errorFrame.isDisplayed();
        }catch(TimeoutException error){
            return false;
        }
    }

}
