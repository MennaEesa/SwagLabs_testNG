package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_CartPage {
    WebDriver driver;
    public P03_CartPage(WebDriver driver){
        this.driver=driver;
    }



    private final By itemsPriceList = By.xpath("//div[@class=\"inventory_item_price\"]");
    private final By checkoutButton = By.xpath("//a[@class=\"btn_action checkout_button\"]");


    public P03_CartPage getTotalPriceList() {
        double Total = 0.0;
        List<WebElement> priceList = driver.findElements(itemsPriceList);
        for (int i = 0; i <priceList.size(); i++) {
            Total += Double.parseDouble(priceList.get(i).getText());
        }
        System.out.println("Total Price in cart page  = "+Total);
    return this;
    }

    public P03_CartPage pressCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return this;
    }

}
