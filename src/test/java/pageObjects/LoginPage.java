package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends MainPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getEmailField(){
        By emailBy = By.xpath("//*[@id='loginUsername']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy));
        return driver.findElement(emailBy);
    }

    private WebElement getPasswordField(){
        return driver.findElement(By.xpath("//*[@id='loginPassword']"));
    }

    private WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button"));
    }

    public MainPage loginToApp(String username, String password){
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }

    private WebElement getWrongPassРighlight() { return driver.findElement(By.xpath("//*[div='Incorrect username or password']"));}

    public boolean loginFailCheck(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[div='Incorrect username or password']")));
        try {
            return getWrongPassРighlight().isDisplayed();
        } catch (TimeoutException err){
            return false;
        }
    }

    public void open(String url) {
        driver.get(url);
    }


}
