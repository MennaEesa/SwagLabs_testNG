package testcases;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;

@Listeners(listener.Listener.class)
public class TestBase {
    WebDriver driver;

   public static Faker faker=new Faker();

    @Parameters("browser")
    @BeforeTest()
    public void setupChromeDriver(String browser) throws InterruptedException {

        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/v1/");
    }
    @AfterTest

    public void quite() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
