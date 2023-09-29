package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.Utilities;

import static testcases.TC01_Login.PASSWORD;
import static testcases.TC01_Login.USERNAME;

public class TC02_CreateOrder extends TestBase {

    String FirstName = faker.name().firstName();
    String LastName = faker.name().lastName();
    String postalCode = faker.number().digits(5);


    @Test(priority = 1 , description = "check add products to list and validate total")
    public void addAllItemsToCart() throws InterruptedException {
        //Todo: login with valid data
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        //Todo: Add all items To cart then calculate the total of product price and open cart page
        new P02_HomePage(driver).addRandomProductsToCart(6).openCartPage();

        // Todo : calculate the total of product price then checkout
        new P03_CartPage(driver).getTotalPriceList().pressCheckoutButton();
        //Todo: Fill user information
        new P04_CheckoutInfoPage(driver).enterFirstName(FirstName).enterLastName(LastName).enterPostalCode(postalCode).pressUserInfoContinueButton();
        //ToDo: Assert on actual total item price equal the expected total
        Utilities.captureScreenShot(driver,"P_sum Total Items Price");
        Assert.assertTrue(new P05_ConfirmOrder(driver).checkTotalPriceBeforeTax());
        //ToDo Assert the sum of Items Total Price and Tax Price
        Utilities.captureScreenShot(driver,"P_Final Total with Tax");
        Assert.assertTrue(new P05_ConfirmOrder(driver).getSumTotalPriceAndTax().assertFinalPrice());


//        //Todo : Go back to home page
//        driver.navigate().back();
//        driver.navigate().back();
//        driver.navigate().back();
//        //Todo: Remove items from cart and get their price
//        new P02_HomePage(driver).removeRandomProductsFromCart(2).openCartPage();
//        Thread.sleep(5000);
//        // Todo : calculate the total of product price then checkout
//        new P03_CartPage(driver).getTotalPriceList().pressCheckoutButton();
//        //Todo: Fill user information
//        new P04_CheckoutInfoPage(driver).enterFirstName(FirstName).enterLastName(LastName).enterPostalCode(postalCode).pressUserInfoContinueButton();
//        //ToDo: Assert on actual total item price equal the total price - removed items price
//        Utilities.captureScreenShot(driver,"P_sum Total Items Price");
//        Assert.assertTrue(new P05_ConfirmOrder(driver).checkTotalPriceAfterRemoveProduct());


        //ToDo: Press on Finish button
        new P05_ConfirmOrder(driver).pressFinishButton();


    }
}
