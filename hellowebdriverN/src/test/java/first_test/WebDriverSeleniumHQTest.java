package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import waits.CustomConditions;

import java.util.List;

public class WebDriverSeleniumHQTest {

    @Test
    public void commonSearchTermReResultsNotEmpty() {

        //no remote webdriver run during this demo
        WebDriver driver = new ChromeDriver();

        driver.get("http://yandex.by/");
        //risky point here
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(CustomConditions.jQueryAJAXsCompleted());


        WebElement searchInput = waitForElementLocatedBy(driver, By.id("text"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']"));
        searchBtn.get(0).click();
        //risky point here
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'Organic organic') and contains(.,'selenium') and contains(., 'java')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class,'Organic organic') and contains(.,'selenium') and contains(., 'java')]"));
        System.out.println("Search results number for requested term: " + searchResults.size());

        Assert.assertTrue(searchResults.size()>0,"Search results are empty");

        driver.quit();

    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
