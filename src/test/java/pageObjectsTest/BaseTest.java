package pageObjectsTest;

import enums.BrowserType;
import helpers.BrowserFabric;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;

    @BeforeMethod
    public void startUp() {
    // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

//        driver = BrowserFabric.getWebDriver(BrowserType.FIREFOX);
//        driver = BrowserFabric.getWebDriver(BrowserType.OPERA);
//        driver = BrowserFabric.getWebDriver(BrowserType.EDGE);
        driver = BrowserFabric.getWebDriver(BrowserType.CHROME);



        wait = new WebDriverWait(driver, 10, 500);
        url = "https://bbb.testpro.io";

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }

}
