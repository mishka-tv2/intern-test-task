package dk.tv2.automation.selenium.tv2play;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    private final Browser browser;
    private final WebDriver driver;
 
    public LandingPage(Browser browser) {
        this.browser = browser;
        this.driver = this.browser.getDriver();
    }
    
    public void OpenPage() {
        driver.manage().window().maximize();
        driver.get(browser.getTestURL());
    }
    
    public void CreateUser() {
        String windowContext = driver.getWindowHandle();
        
        new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.className("cta-button")));

        WebElement tryBtn = driver.findElement(By.className("cta-button"));
        tryBtn.click();

        driver.switchTo().frame("payframe");
        new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
        
        driver.findElement(By.id("firstname")).sendKeys("Testuser");
        driver.findElement(By.id("surname")).sendKeys("Testuser");
        driver.findElement(By.id("birthday")).sendKeys("1900-01-01");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("phone")).sendKeys("12345678");
        driver.findElement(By.id("email")).sendKeys("testuser@mailinator.com");
        driver.findElement(By.id("repeat")).sendKeys("testuser@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("mysecretpassword");
        driver.findElement(By.id("acceptTerms")).click();
        
        WebElement closeBtn = driver.findElement(By.className("overlay-close"));
        
        String cmpStr = "Close";
        
        if (cmpStr.equalsIgnoreCase(closeBtn.getText())) {
            closeBtn.click();
        }
        
        driver.switchTo().window(windowContext);
    }
}
