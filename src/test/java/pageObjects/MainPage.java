package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getDropDownButton(){
        By getDropDownButtonBy = By.xpath("//*[@id='USER_DROPDOWN_ID']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDropDownButtonBy));
        return driver.findElement(getDropDownButtonBy);
    }
    //check for log in
    public boolean isMainPage() {
        try {
            return getDropDownButton().isDisplayed();
        } catch (TimeoutException err){
            return false;
        }
    }

    public WebElement getSearchField(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='search']")));
        return driver.findElement(By.xpath("//*[@type='search']"));
    }

    public WebElement getHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[span='test']")));
        return driver.findElement(By.xpath("//*[span='test']"));
    }
    public boolean isSearchTrue() {
        try {
            return getHeading().isDisplayed();
        } catch (TimeoutException err){
            return false;
        }
    }




}
