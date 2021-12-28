package pageObjectsTest;

import com.github.javafaker.Faker;
import helpers.TestDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlayListTest {
    private WebDriver driver;
    private String url;


    @BeforeMethod
    public void startUp(){

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://bbb.testpro.io/";

    }

    @AfterMethod
    public void finish() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void playListTest_createPlayList_playListCreated(){

//        String playListName = TestDataGenerator.getRandomString(5);
        Faker faker = new Faker();
        String playListName = faker.lordOfTheRings().character();
        System.out.println(playListName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        // Save created unique ID
        String playlistID = mainPage.createPlayList(playListName);
        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistID,playListName));

    }

}
