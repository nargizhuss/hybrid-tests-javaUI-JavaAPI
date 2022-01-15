package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    // create functions which will return email/password/button fields/element
    private WebElement getEmailField(){
        return driver.findElement(By.xpath("//*[@type='email']"));
    }

    private WebElement getPasswordField(){
        return driver.findElement(By.cssSelector("[type=password]"));
    }

    private WebElement getLoginButton(){
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public MainPage loginToApp(String username, String password){

        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);

    }

    public void open(String url){
        driver.get(url);
    }


    public boolean isError() {
        By errorLocator = By.className("error");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            return true;
        }catch(TimeoutException error){
            return false;
        }
    }

}
