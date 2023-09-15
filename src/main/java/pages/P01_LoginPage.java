package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utility.Utilities;


public class P01_LoginPage {

    WebDriver driver;
    public P01_LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Todo:define locators using By
    private final By EMAIL =By.xpath("//input[@data-test=\"username\"]");
    private final By PASSWORD =By.xpath("//input[@data-test=\"password\"]");
    private final By LOGINBUTTON =By.id("login-button");
    private final By failErrorMessage= By.xpath("//h3[@data-test=\"error\"]");

    // TODO: add action methods
    public P01_LoginPage enterEmail(String email)
    {
        driver.findElement(this.EMAIL).sendKeys(email);
        return this;
    }
    public P01_LoginPage enterPassword(String password)
    {
        driver.findElement(this.PASSWORD).sendKeys(password);
        return this;
    }
    public P01_LoginPage clickLoginButton()
    {
        driver.findElement(this.LOGINBUTTON).click();
        return this;
    }

    public boolean assertSuccessLogin()
    {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html");
    }

    public boolean assertFailLogin()
    {
        return driver.findElement(failErrorMessage).getText().contains("Username and password do not match any user in this service");
    }
}
