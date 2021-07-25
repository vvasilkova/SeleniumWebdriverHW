package waits;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverSyncDemoFluent {

    public static void main(String[] args) throws InterruptedException {

        //no remote webdriver run during this demo
        WebDriver driver = new ChromeDriver();

        driver.get("http://yandex.by/");
        //risky point here
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());

        WebElement searchInput = waitForElementLocatedBy(driver, By.id("text"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']"));
        searchBtn.get(0).click();
        //risky point here


        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result list was exceeded!");

        List<WebElement> searchResults = wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(By.xpath("//div[contains(@class,'Organic organic') and contains(.,'selenium') and contains(., 'java')]"));
            }
        });

        System.out.println("Search results number for requested term: " +searchResults.size());

        driver.quit();

        }

        private static WebElement waitForElementLocatedBy (WebDriver driver, By by){
            return new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
