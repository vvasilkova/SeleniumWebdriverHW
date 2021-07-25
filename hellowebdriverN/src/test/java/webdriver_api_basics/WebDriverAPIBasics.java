package webdriver_api_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriverAPIBasics {

    public static void main(String[] args) throws InterruptedException {

        //no remote webdriver run during this demo

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.yahoo.com/");
        WebElement searchInput = driver.findElement(By.id("ybar-sbq"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Search']"));
        searchBtn.get(0).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
