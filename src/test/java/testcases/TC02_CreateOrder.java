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


    @Test
    public void addAllItemsToCart() {
        //Todo: login with valid data
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        //Todo: Add all items To cart then open cart page
        new P02_HomePage(driver).addAllToCart().openCartPage();
        // Todo : calculate the total of product price then checkout
        new P03_CartPage(driver).pressCheckoutButton();
        //Todo: Fill user information
        new P04_CheckoutInfoPage(driver).enterFirstName(FirstName).enterLastName(LastName).enterPostalCode(postalCode).pressUserInfoContinueButton();
        //ToDo: Assert on actual total item price equal the expected total
        P05_ConfirmOrder confirmOrder = new P05_ConfirmOrder(driver);
        Utilities.captureScreenShot(driver,"P_sum Total Items Price");
        Assert.assertTrue(confirmOrder.assertTotalPrice());
        //ToDo Assert the sum of Items Total Price and Tax Price
        Utilities.captureScreenShot(driver,"P_Final Total with Tax");
        Assert.assertTrue(confirmOrder.assertFinalPrice());
        //ToDo: Press on Finish button
        new P05_ConfirmOrder(driver).pressFinishButton();
    }
}
