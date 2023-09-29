package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utility.Utilities;

public class TC01_Login extends TestBase {

    /// define test data
    public static String USERNAME=Utilities.getData(System.getProperty("user.dir")+"/src/test/resources/data/logindata.json","username");
    public static String PASSWORD=Utilities.getData(System.getProperty("user.dir")+"/src/test/resources/data/logindata.json","password");
    // positive testcases
    // TODO: create test case to check login with valid email and password
    @Test(priority = 1,description = "Check Login with Valid username and password")
    public void checkLoginWithValidEmailandPassword_P(){
        System.out.println("username:"+USERNAME);
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        // capture screenshot after login
        Utilities.captureScreenShot(driver,"P_login");
        // assert if login successfully
        Assert.assertTrue(new P01_LoginPage(driver).assertSuccessLogin());
    }
    // negative scenarios
    @Test(priority = 2,description = "Check Login with Valid username and Invalid password")
    public void checkLoginWithValidEmailandInvalidpassword_N(){
        PASSWORD="dfdsf";
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        // capture screenshot after login
        Utilities.captureScreenShot(driver,"N_login");
        // assert if login successfully
        Assert.assertTrue(new P01_LoginPage(driver).assertFailLogin());
    }
    @Test(priority = 3,description = "Check Login with Invalid username and Valid password")
    public void checkLoginWithInvalidEmailandValidpassword_N(){
        USERNAME="asdasd";
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        // capture screenshot after login
        Utilities.captureScreenShot(driver,"N_login");
        // assert if login successfully
        Assert.assertTrue(new P01_LoginPage(driver).assertFailLogin());
    }
    @Test(priority = 4,description = "Check Login with Invalid username and Invalid password")
    public void checkLoginWithInvalidEmailandInvalidpassword_N(){
        USERNAME="asdasd";
        PASSWORD="sdfsdf";
        new P01_LoginPage(driver).enterEmail(USERNAME).enterPassword(PASSWORD).clickLoginButton();
        // capture screenshot after login
        Utilities.captureScreenShot(driver,"N_login");
        // assert if login successfully
        Assert.assertTrue(new P01_LoginPage(driver).assertFailLogin());
    }


}
