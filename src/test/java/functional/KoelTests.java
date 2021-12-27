package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KoelTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void startUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 300);

        // Pre-condition
        driver.get("https://bbb.testpro.io");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void correctCredentials_successfulLogin() {

        By usernameLocator = By.xpath("//*[@type='email']");
        WebElement usernameField = driver.findElement(usernameLocator);

        By passwordLocator = By.cssSelector("[type=password]");
        WebElement passwordField = driver.findElement(passwordLocator);

        By loginButtonLocator = By.xpath("//*[@type='submit']");
        WebElement loginButton = driver.findElement(loginButtonLocator);

        // Action
        usernameField.sendKeys("nargiz.rza@gmail.com");
        passwordField.sendKeys("te$t$tudent");
        loginButton.click();

        // Assertion
        By homeIconLocator = By.className("home");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
        WebElement homeIcon = driver.findElement(homeIconLocator);
        Assert.assertTrue(homeIcon.isDisplayed());
    }

    @Test
    public void incorrectCredentials_errorFrame() throws InterruptedException {

        By usernameLocator = By.xpath("//*[@type='email']");
        WebElement usernameField = driver.findElement(usernameLocator);

        By passwordLocator = By.cssSelector("[type=password]");
        WebElement passwordField = driver.findElement(passwordLocator);

        By loginButtonLocator = By.xpath("//*[@type='submit']");
        WebElement loginButton = driver.findElement(loginButtonLocator);

        // Action
        usernameField.sendKeys("koeluser06@testpro.io");
        passwordField.sendKeys("wrongPassword");
        loginButton.click();

        // Assertion
        By errorFrameLocator = By.className("error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorFrameLocator));
        WebElement errorFrame = driver.findElement(errorFrameLocator);
        Assert.assertTrue(errorFrame.isDisplayed());

    }

    @Test
    public void create_newPlayList() throws InterruptedException {

        By emailFieldLocator = By.xpath("//*[@type='email']");
        WebElement emailField = driver.findElement(emailFieldLocator);

        By passwordFieldLocator = By.cssSelector("[type=password]");
        WebElement passwordField = driver.findElement(passwordFieldLocator);

        By loginButtonLocator = By.xpath("//*[@type='submit']");
        WebElement loginButton = driver.findElement(loginButtonLocator);

        // Action
        emailField.sendKeys("nargiz.rza@gmail.com");
        passwordField.sendKeys("te$t$tudent");
        loginButton.click();
        Thread.sleep(2000);

        // Create a play list
        // Click on New Play List Plus button
        By newPlayListIconLocator = By.xpath("//*[@title='Create a new playlist']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPlayListIconLocator));
        WebElement newPlayListIconButton = driver.findElement(newPlayListIconLocator);
        newPlayListIconButton.click();

        // Click on New Play List
        By newPlayListLocator = By.xpath("//*[contains(text(),'New Playlist')]");
        WebElement newPlayList = driver.findElement(newPlayListLocator);
        newPlayList.click();

        // Enter info in the input field and then click Enter
        By playlistFieldLocator = By.xpath("(//*[@required='required'])[1]");
        WebElement playListField = driver.findElement(playlistFieldLocator);

        playListField.sendKeys("Roxette");
        playListField.sendKeys(Keys.RETURN);
    }
}