package pageObjectsTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlayListTest extends BaseTest{


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
