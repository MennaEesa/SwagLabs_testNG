package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Utilities {
    public static int generateRandomInt(int lower, int upper) {
        // Create a random number generator
        Random random = new Random();

        // Generate a random integer between the specified lower and upper bounds
        int randomInt = random.nextInt(upper - lower + 1) + lower;

        return randomInt;
    }

    //Todo: capture screenshot
    public static void captureScreenShot(WebDriver driver,String screenshotName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        String screenshot=screenshotName+currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE),new File(System.getProperty("user.dir")+"/src/test/resources/screenshots/"+screenshot+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
