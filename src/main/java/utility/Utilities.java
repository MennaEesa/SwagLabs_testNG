package utility;

//import com.google.gson.JsonObject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate = new Date();
        String screenshot = screenshotName + currntDate.toString().replace(" ", "-").replace(":", "-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + screenshot + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static float string_to_Float(String text, String replaceValu) {
        text = text.replace(replaceValu, "");
        return Float.parseFloat(text);
    }

    public static float removeFirstLetterAndReturnFloatNumber(String string) {
        if (string == null || string.isEmpty()) {
            return 0.0f;
        }

        try {
            return Float.parseFloat(string.substring(1));
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }
    // read data from json file
    public static String getData(String jsonPath, String field) {
        try{
        // define object of json parser
        JSONParser parser=new JSONParser();
        // define object of file reader
        FileReader reader=new FileReader(jsonPath);
        Object object= parser.parse(reader);
        JSONObject jsonObject= (JSONObject) object;
        return jsonObject.get(field).toString();}
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    // TODO: Read Data From Excel Sheet
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data/logindata.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }
}
