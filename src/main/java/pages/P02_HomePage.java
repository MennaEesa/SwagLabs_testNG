package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.NumberGenerator;
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
    private final By removeButton = By.xpath("//button[@class=\"btn_secondary btn_inventory\"]");

    static float totalPrice = 0;
    static float totalPriceOfRemovedItems = 0;


    public P02_HomePage addRandomProductsToCart(int size) throws InterruptedException {
        NumberGenerator generator = new NumberGenerator();
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartElement);
        for (int i = 0; i < size; i++) {
            int uniqueRandomNumber = generator.generateUniqueRandomNumber(6);
            System.out.println(uniqueRandomNumber);
//            int random = Utilities.generateRandomInt(0,5);
            addToCartButtonsList.get(uniqueRandomNumber).click();

            totalPrice += Utilities.removeFirstLetterAndReturnFloatNumber(driver.findElements(itemPriceText).get(uniqueRandomNumber).getText());

        }
        System.out.println("Total price in home page "+totalPrice);
        Thread.sleep(3000);
        return this;
    }


    public P02_HomePage removeRandomProductsFromCart(int size) throws InterruptedException {
        List<WebElement> removeButtonsList = driver.findElements(removeButton);
        for (int i = 0; i < size; i++) {
            NumberGenerator generator = new NumberGenerator();
//            int random = Utilities.generateRandomInt(0,5);
            int uniqueRandomNumber = generator.generateUniqueRandomNumber(6);
            System.out.println(uniqueRandomNumber);
            WebElement item = removeButtonsList.get(uniqueRandomNumber);
            String printText = item.getText();
            System.out.println(printText);
            item.click();
            totalPriceOfRemovedItems += Utilities.removeFirstLetterAndReturnFloatNumber(driver.findElements(itemPriceText).get(uniqueRandomNumber).getText());
        }
        System.out.println("Total price of removed items in home page "+totalPriceOfRemovedItems);
        Thread.sleep(3000);
        return this;
    }

    public P02_HomePage openCartPage() {
        driver.findElement(cartPage).click();
        return this;
    }

}

