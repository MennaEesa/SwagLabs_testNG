package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P04_CheckoutInfoPage {
    WebDriver driver;
    public P04_CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode= By.id("postal-code");
    private final By userInfoContinueButton = By.xpath("//input[@class=\"btn_primary cart_button\"]");


    public P04_CheckoutInfoPage enterFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public P04_CheckoutInfoPage enterLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public P04_CheckoutInfoPage enterPostalCode(String postalCode) {
        driver.findElement(this.postalCode).sendKeys(postalCode);
        return this;
    }

    public P04_CheckoutInfoPage pressUserInfoContinueButton() {
        driver.findElement(userInfoContinueButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }



}
