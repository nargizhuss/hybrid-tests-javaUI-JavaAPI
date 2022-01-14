package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    // Constructor
    public MainPage(WebDriver driver) {
        super(driver);
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

    // create function (getter) which will return play list elements / fields - locators
    private void clickPlusButton(){
        By plusButtonLocator = By.xpath("//*[@title='Create a new playlist']");
//        wait.until(ExpectedConditions.elementToBeClickable(plusButtonLocator));
        // custom wait - 20 attempts to click on the element
        for (int i=0; i<20; i++){
            try {
            driver.findElement(plusButtonLocator).click();
            return;
            } catch (NoSuchElementException | ElementClickInterceptedException err){
                try {
                    Thread.sleep(200);
                } catch(InterruptedException ignored){}

                }
            }
            throw new TimeoutException("Element not found");

        }



    private WebElement getNewPlayList(){
        return driver.findElement(By.xpath("//*[contains(text(),'New Playlist')]"));
    }

    private WebElement getNewPlaylistInput(){
        return driver.findElement(By.xpath("(//*[@required='required'])[1]"));
    }

    public String createPlayList(String playListName) {

        clickPlusButton();
        getNewPlayList().click();
        getNewPlaylistInput().sendKeys(playListName);
        getNewPlaylistInput().sendKeys(Keys.RETURN);
        // Assert that playlist has been created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='success show']")));
        String url = driver.getCurrentUrl();
        System.out.println(url);
        // Split String to few parts - url and unique ID
        String [] splitUrlString = url.split("/");
        // the unique ID is the 6th part of the url - index 5
        System.out.println(splitUrlString[5]);
        return splitUrlString[5];

    }

    private WebElement getPlaylist(String id){
        return driver.findElement(By.xpath("//*[@href='#!/playlist/"+id+"']"));
    }

    private WebElement editField(){
        By editFieldLocator = By.xpath("//*[@class='playlist playlist editing']/input");
        wait.until(ExpectedConditions.elementToBeClickable(editFieldLocator));
        return driver.findElement(editFieldLocator);
    }

    public boolean playlistExist(String playlistID, String playListName) {
        try {
        return getPlaylist(playlistID).isDisplayed() && getPlaylist(playlistID).getText().equals(playListName);
        } catch (NoSuchElementException err){
        return false;
    }
}

    public void  renamePlaylist(String playlistID, String newName) {
        // Here I found playlist and saved in the variable
        WebElement playlist = getPlaylist(playlistID);
        //This will scroll the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", playlist);
        // double click. In this case I use Action to click
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        // select all in edit field
        editField().sendKeys(Keys.CONTROL + "a");
        editField().sendKeys(newName);
        editField().sendKeys(Keys.RETURN);
        // I need to wait for the second green pop-up to appear - playlist created and then renamed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='success show' and contains (text(),'"+newName+"')]")));


    }
}

