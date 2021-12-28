package pageObjects;

import org.openqa.selenium.*;
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

    private WebElement getNewPlaylistInput(){
        return driver.findElement(By.xpath("(//*[@required='required'])[1]"));
    }

    public String createPlayList(String playListName) {

        getPlusButton().click();
        getNewPlayList().click();
        getNewPlaylistInput().sendKeys(playListName);
        getNewPlaylistInput().sendKeys(Keys.RETURN);
        // Assertion that playlist has been created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='success show']")));
        String url = driver.getCurrentUrl();
        // Split String to few parts - url and unique ID
        String [] parts = url.split("/");
        // the unique ID is teh 6 part - index 5
        System.out.println(parts[5]);
        return parts[5];

    }

    private WebElement getPlaylist(String id){
        return driver.findElement(By.xpath("//*[@href='#!/playlist/"+id+"']"));
    }

    public boolean playlistExist(String playlistID, String playListName) {
        try {
        return getPlaylist(playlistID).isDisplayed() && getPlaylist(playlistID).getText().equals(playListName);
        } catch (NoSuchElementException err){
        return false;
    }
}

    }

