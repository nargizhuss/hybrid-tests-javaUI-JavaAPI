package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5, 500);
    }


    public boolean isOpen() {
        By homeIconLocator = By.className("active");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
            return true;
        } catch (TimeoutException err){
            return false;
        }
    }

    // create function (getter) which will return play list elements / fields
    private WebElement getPlusButton(){
        By plusButtonLocator = By.xpath("//*[@title='Create a new playlist']");
        wait.until(ExpectedConditions.elementToBeClickable(plusButtonLocator));
        return driver.findElement(plusButtonLocator);
    }

    private WebElement getNewPlayList(){
        return driver.findElement(By.xpath("//*[contains(text(),'New Playlist')]"));
    }

    public void createPlayList(String playListName) {

        getPlusButton().click();
        getNewPlayList().click();

    }

}
