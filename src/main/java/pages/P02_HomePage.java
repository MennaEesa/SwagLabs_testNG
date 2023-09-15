package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class P02_HomePage {
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addToCartElement = By.xpath("//button[@class=\"btn_primary btn_inventory\"]");
    private final By cartPage = By.xpath("//a[@href=\"./cart.html\"]");

    public P02_HomePage addAllToCart() {
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartElement);
        for (int i = 0; i < addToCartButtonsList.size(); i++) {
            addToCartButtonsList.get(i).click();
        }
        return this;
    }

    public P02_HomePage openCartPage() {
        driver.findElement(cartPage).click();
        return this;
    }

}

