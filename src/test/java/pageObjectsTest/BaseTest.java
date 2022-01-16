package pageObjectsTest;

import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.Screenshot;
import helpers.Token;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.MainPage;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;
    protected String username;
    protected String password;
    protected String incorrectPassword;
    protected String token;


    @Parameters({"url", "username", "password", "incorrectPassword"})
    @BeforeMethod
    public void startUp(String url, String username, String password, String incorrectPassword) {
    // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = BrowserFabric.getWebDriver(BrowserType.CHROME);
        wait = new WebDriverWait(driver, 10, 500);
        this.url = url;
        this.username = username;
        this.password = password;
        this.incorrectPassword = incorrectPassword;
        token = Token.get(username, password);

    }

    @AfterMethod
    public void finish(ITestResult testResult) throws InterruptedException {
        if(testResult.getStatus()==testResult.FAILURE){
            Screenshot.get(driver,testResult.getName());
        }

        Thread.sleep(5000);
        driver.quit();

    }

    public MainPage login(String token){
        driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","jwt-token","\""+token+"\"");
        driver.navigate().refresh();
        return new MainPage(driver);

    }

}
