package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import retry.MyRetry;
import utility.Utilities;

@Epic("login Feature")
@Story("login")
public class TC01_Login extends TestBase {

    /// define test data
//    public static String USERNAME=Utilities.getData(System.getProperty("user.dir")+"/src/test/resources/data/logindata.json","username");
//    public static String PASSWORD=Utilities.getData(System.getProperty("user.dir")+"/src/test/resources/data/logindata.json","password");
    static String USERNAME ;
    static String PASSWORD ;

    // positive testcases
    // TODO: create test case to check login with valid email and password
    @Test(priority = 1,description = "Check Login with Valid username and password",retryAnalyzer = MyRetry.class)
    @Description("Login with Valid username and password")
    @Severity(SeverityLevel.CRITICAL)
    public void checkLoginWithValidEmailandPassword_P(){
        USERNAME =Utilities.getExcelData(1,0,"sheet1");
        PASSWORD =Utilities.getExcelData(1,1,"sheet1");
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
