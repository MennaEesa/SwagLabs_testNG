package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Utilities;

import java.util.List;


public class P02_HomePage {
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addToCartElement = By.xpath("//button[@class=\"btn_primary btn_inventory\"]");
    private final By itemPriceText = By.xpath("//div[@class=\"inventory_item_price\"]");
    private final By cartPage = By.xpath("//a[@href=\"./cart.html\"]");

    static float totalPrice = 0;

    public P02_HomePage addProductsToCart() {
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartElement);
        for (int i = 0; i < addToCartButtonsList.size(); i++) {
            addToCartButtonsList.get(i).click();
            totalPrice += Utilities.removeFirstLetterAndReturnFloatNumber(driver.findElements(itemPriceText).get(i).getText());
        }
        System.out.println("Total price in home page "+totalPrice);
        return this;
    }


    public P02_HomePage openCartPage() {
        driver.findElement(cartPage).click();
        return this;
    }

}

