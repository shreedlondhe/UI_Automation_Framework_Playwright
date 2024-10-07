package listeners;

import base.TestBase;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class iTestListener extends TestBase implements org.testng.ITestListener  {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :"+result.getName());
        getScreenShot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
    public static void getScreenShot() {
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
    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        return timeStamp;
    }
}
