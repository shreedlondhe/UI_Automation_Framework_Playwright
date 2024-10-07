package base;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TestBase {

    public static Browser browser;
    public static Page page;
    Properties prop;

    public TestBase() {
       prop=new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") +"/src/main/java/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void initialization() {
     browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext incognitoContext = browser.newContext();
       page = incognitoContext.newPage();
        page.setDefaultTimeout(30000);
       // page.navigate(prop.getProperty("url")); //  for local
        page.navigate(System.getProperty("url")); //  for jenkins

        }


    }












