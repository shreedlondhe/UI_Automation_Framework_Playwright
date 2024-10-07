package utils;

import base.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static base.TestBase.page;

public class TestUtil {

    public static void click(String locator,String msg){
        page.waitForSelector(locator,new Page.WaitForSelectorOptions().setTimeout(15000));
        page.click(locator);
        LogUtils.info(msg);

    }
    public static void  fill(String locator,String value,String msg){
        page.waitForSelector(locator,new Page.WaitForSelectorOptions().setTimeout(15000));
        page.fill(locator,value);
        LogUtils.info(msg);

}
    public static void clear(String locator,String msg){
        page.waitForSelector(locator,new Page.WaitForSelectorOptions().setTimeout(15000));
        page.locator(locator).clear();
        LogUtils.info(msg);

    }
    public static void getScreenShot(){
        try {
            Path screenshotPath = Paths.get("example_screenshot.png");

            // Take a screenshot and save it as a file
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

            // Create a File object from the saved screenshot path
            File screenshotFile = screenshotPath.toFile();

            Allure.addAttachment("Screenshot " + getTimeStamp(), FileUtils.openInputStream(screenshotFile));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    public static String PastDate(int days) {
        LocalDateTime currentDateTime = LocalDateTime.now().minusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);
    }

    public static String FutureDate(int days) {
        LocalDateTime currentDateTime = LocalDateTime.now().plusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);
    }

    public static String PresentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);

    }
    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        return timeStamp;
    }

}
