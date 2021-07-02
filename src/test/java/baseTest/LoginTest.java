package baseTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTest extends BaseTestObjects{
    @Test(enabled = false)
    public void loginTest_loginWithCorrectCredentials_mainPageOpened(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isMainPage());
    }
    @Test(enabled = false)
    public void loginTest_loginWithUnCorrectCredentials_mainPageOpened() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, "wrongPass");
        Assert.assertTrue(loginPage.loginFailCheck());
    }
    @Test
    public void serchFieldTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        mainPage.getSearchField().sendKeys("test");
        mainPage.getSearchField().sendKeys(Keys.RETURN);
        Assert.assertTrue(mainPage.isSearchTrue());
    }

}
