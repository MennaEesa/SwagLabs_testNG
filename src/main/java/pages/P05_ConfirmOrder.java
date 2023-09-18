package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Utilities;

import java.util.List;

import static pages.P02_HomePage.totalPrice;

public class P05_ConfirmOrder {
    static float expectedFinalTotal;

    WebDriver driver;

    public P05_ConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemsPriceList = By.xpath("//div[@class=\"inventory_item_price\"]");
    private final By itemsTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
    private final By Tax = By.xpath("//div[@class=\"summary_tax_label\"]");
    private final By FinalTotal = By.xpath("//div[@class=\"summary_total_label\"]");
    private final By FinishButton = By.xpath("//a[@class=\"btn_action cart_button\"]");




    public boolean checkTotalPriceBeforeTax()
    {
        return driver.findElement(itemsTotal).getText().equals("Item total: $" +totalPrice);
    }

        public P05_ConfirmOrder getSumTotalPriceAndTax() {
        String taxString;
        float taxFloat ;
        taxString = driver.findElement(Tax).getText();
        taxFloat = Utilities.string_to_Float(taxString,"Tax: $");
        System.out.println("Tax price = "+taxFloat);
        //Expected final total = Total Items + Tax
        expectedFinalTotal = totalPrice + taxFloat;
        System.out.println("Total with tax = "+expectedFinalTotal);
        return this;
    }

        public boolean assertFinalPrice() {
        return driver.findElement(FinalTotal).getText().equals("Total: $" + expectedFinalTotal);
    }

    public P05_ConfirmOrder pressFinishButton() {
        driver.findElement(FinishButton).click();
        return this;
    }



////// ANOTHER WAY ////

    //    double totalDouble = 0.0;
//    public void checkSumTotal() {
//        String totalString;
//
//        List<WebElement> items = driver.findElements(itemsPriceList);
//        for (int i = 0; i < items.size(); i++) {
//            items.get(i).getText();
//            totalString = items.get(i).getText();
//            totalString = totalString.replace("$", "");
//            totalDouble += Double.parseDouble(totalString);
//        }
//        System.out.println("Total items price = " + totalDouble);
//    }
//
//    public boolean assertTotalPrice() {
//        checkSumTotal();
//        return driver.findElement(itemsTotal).getText().equals("Item total: $" + totalDouble);
//    }
//


}
