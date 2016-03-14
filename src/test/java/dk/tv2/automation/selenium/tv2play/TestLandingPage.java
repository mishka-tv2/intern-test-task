package dk.tv2.automation.selenium.tv2play;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLandingPage {
    private Browser browser;
    private LandingPage landingPage;
    
    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void setUp(String Browser,
                      String URL) throws MalformedURLException {
        this.browser = new Browser(Browser, URL);
        
        landingPage = new LandingPage(browser);
        
        landingPage.OpenPage();
    }
    
    @AfterTest
    public void tearDown() {
        WebDriver driver = browser.getDriver();
        
        driver.quit();
    }
    
    @Test
    public void testCreateUser() {
        landingPage.CreateUser();
    }

    @Test
    public void testLogIn() {
        landingPage.LogIn();
    }
    
    @Test
    public void testViewPackages() throws InterruptedException {
        landingPage.ViewPackages();
    }
    
    @Test
    public void testGoToContent() {
        landingPage.GoToContent();
    }
    
}
