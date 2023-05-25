import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/larryallen/QA/chromedriver");

        WebDriver driver;
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://admin.mobiletechrx.com");

        //Login to Admin Portal
        driver.findElement(By.name("email")).sendKeys("iosqatest@mobiletechrx.com");
        driver.findElement(By.name("pwd")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".btn.btn-blue.btn-block")).click();
        //Explicit wait to confirm nav bar for company info page of Admin Portal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("navbar-brand")));

        String confirm = driver.findElement(By.className("page-title")).getText();
        //Assertion to confirm that SETTINGS is found on the company info page.
        Assert.assertEquals("SETTINGS", confirm);

        driver.quit();

    }
}
