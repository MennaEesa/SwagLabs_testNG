package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriver getNewInstance(String browserName)
    {
        switch (browserName.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case  "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                ChromeOptions options =new ChromeOptions();
                options = new ChromeOptions();
                // TODO: handle browsers options
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);

                options.addArguments("start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.setExperimentalOption("prefs", prefs);
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);
        }
    }
}
