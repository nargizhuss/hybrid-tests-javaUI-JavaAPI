package pageObjectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.LoginPageFactory;
import pageObjects.MainPage;

public class LoginFactoryTest extends BaseTest {

    @Test
    public void loginTestFactory_correctLogin_loggedToApp(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        MainPage mainPage = loginPageFactory.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        loginPageFactory.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPageFactory.isError());

    }

    @Test
    public void loginTestFactory_correctLogin_loggedToApp01(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        MainPage mainPage = loginPageFactory.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame01(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        loginPageFactory.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPageFactory.isError());

    }

    @Test
    public void loginTestFactory_correctLogin_loggedToApp02(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        MainPage mainPage = loginPageFactory.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame02(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        loginPageFactory.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPageFactory.isError());

    }

    @Test
    public void loginTestFactory_correctLogin_loggedToApp03(){
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        MainPage mainPage = loginPageFactory.loginToApp("nargiz.rza@gmail.com", "te$t$tudent");
        Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_incorrectCredentials_redFrame03(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.open(url);
        loginPageFactory.loginToApp("nargiz.rza@gmail.com", "wrongPassword");
        Assert.assertTrue(loginPageFactory.isError());

    }

}
