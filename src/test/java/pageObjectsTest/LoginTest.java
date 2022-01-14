package pageObjectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest_correctCredentials_loggedToApp(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPage.isError());

    }

    @Test
    public void loginTest_correctCredentials_loggedToApp01(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame01(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPage.isError());

    }

    @Test
    public void loginTest_correctCredentials_loggedToApp02(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame02(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPage.isError());

    }

    @Test
    public void loginTest_correctCredentials_loggedToApp03(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame03(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPage.isError());

    }


}
