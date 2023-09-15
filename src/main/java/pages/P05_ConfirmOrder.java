package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_ConfirmOrder {
    double totalDouble = 0.0;
    WebDriver driver;

    public P05_ConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemsPriceList = By.xpath("//div[@class=\"inventory_item_price\"]");
    private final By itemsTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
    private final By Tax = By.xpath("//div[@class=\"summary_tax_label\"]");
    private final By FinalTotal = By.xpath("//div[@class=\"summary_total_label\"]");
    private final By FinishButton = By.xpath("//a[@class=\"btn_action cart_button\"]");


    public void checkSumTotal() {
        String totalString;
        List<WebElement> items = driver.findElements(itemsPriceList);
        for (int i = 0; i < items.size(); i++) {
            items.get(i).getText();
            totalString = items.get(i).getText();
            totalString = totalString.replace("$", "");
            totalDouble += Double.parseDouble(totalString);
        }
        System.out.println("Total items price = " + totalDouble);
    }

    public boolean assertTotalPrice() {
        checkSumTotal();
        return driver.findElement(itemsTotal).getText().equals("Item total: $" + totalDouble);
    }

    public Double getSumtTotalPriceAndTax() {
        double expectedFinalTotal;
        String taxString;
        double taxDouble ;
        taxString = driver.findElement(Tax).getText();
        taxString = taxString.replace("Tax: $", "");
        taxDouble = Double.parseDouble(taxString);
        System.out.println(taxDouble);
        //Expected final total = Total Items + Tax
        expectedFinalTotal = totalDouble + taxDouble;
        System.out.println(expectedFinalTotal);
        return expectedFinalTotal;
    }

    public boolean assertFinalPrice() {
        return driver.findElement(FinalTotal).getText().equals("Total: $" + getSumtTotalPriceAndTax());
    }

    public P05_ConfirmOrder pressFinishButton() {
        driver.findElement(FinishButton).click();
        return this;
    }

}
