package dk.tv2.automation.selenium.tv2play;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    private String browserName;
    private String testURL;

    private WebDriver driver;

    Browser(String browserName, String testURL) throws MalformedURLException {
        this.browserName = browserName;
        this.testURL = testURL;

        switch (browserName.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getTestURL() {
        return testURL;
    }
}        
