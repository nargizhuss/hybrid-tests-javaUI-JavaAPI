package pageObjectsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlayListTest {
    private WebDriver driver;
    private String url;
//    private WebDriverWait wait;


    @BeforeMethod
    public void startUp(){

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://bbb.testpro.io/";
//        wait = new WebDriverWait(driver,10, 300);

    }

    @AfterMethod
    public void finish() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void playListTest_createPlayList_playListCreated(){

//        String playListName = TestDataGenerator.getRandomString(5);
        String playListName = "RandomPlayListName";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        mainPage.createPlayList(playListName);
        System.out.println();



    }



}
