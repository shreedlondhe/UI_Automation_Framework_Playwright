package testCases;
import base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import listeners.iTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LogUtils;
import utils.TestUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Listeners(iTestListener.class)
public class TC001 extends TestBase {
    @BeforeMethod
    void setUp(){
        initialization();

    }
    @Test()
    void test1() throws IOException {

   LogUtils.info("Inside the test 1");
        TestUtil.getScreenShot();

    }
    @AfterMethod
    void tearDown(){
        page.close();
        browser.close();
    }


}
