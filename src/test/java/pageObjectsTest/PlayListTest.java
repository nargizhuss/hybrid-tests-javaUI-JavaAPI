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
        Faker  faker = new Faker();
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

    @Test
    public void playListTest_renamePlayList_playlistRenamed(){

        Faker faker = new Faker();
        String playListName = faker.lordOfTheRings().character();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        // Save created unique ID
        String playlistID = mainPage.createPlayList(playListName);

        String newName = faker.ancient().god();
        mainPage.renamePlaylist(playlistID,newName);


        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistID,newName));

    }

    @Test
    public void playListTest_createPlayList_playListCreated01(){

//        String playListName = TestDataGenerator.getRandomString(5);
        Faker  faker = new Faker();
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

    @Test
    public void playListTest_renamePlayList_playlistRenamed01(){

        Faker faker = new Faker();
        String playListName = faker.lordOfTheRings().character();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        // Save created unique ID
        String playlistID = mainPage.createPlayList(playListName);

        String newName = faker.ancient().god();
        mainPage.renamePlaylist(playlistID,newName);


        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistID,newName));

    }

    @Test
    public void playListTest_createPlayList_playListCreated02(){

//        String playListName = TestDataGenerator.getRandomString(5);
        Faker  faker = new Faker();
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

    @Test
    public void playListTest_renamePlayList_playlistRenamed02(){

        Faker faker = new Faker();
        String playListName = faker.lordOfTheRings().character();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        // Save created unique ID
        String playlistID = mainPage.createPlayList(playListName);

        String newName = faker.ancient().god();
        mainPage.renamePlaylist(playlistID,newName);


        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistID,newName));

    }

    @Test
    public void playListTest_createPlayList_playListCreated03(){

//        String playListName = TestDataGenerator.getRandomString(5);
        Faker  faker = new Faker();
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

    @Test
    public void playListTest_renamePlayList_playlistRenamed03(){

        Faker faker = new Faker();
        String playListName = faker.lordOfTheRings().character();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        // Save created unique ID
        String playlistID = mainPage.createPlayList(playListName);

        String newName = faker.ancient().god();
        mainPage.renamePlaylist(playlistID,newName);


        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistID,newName));

    }

}
