package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.pkcs11.wrapper.Constants;
import waits.CustomConditions;

import javax.swing.*;
import java.util.List;

public class BringItOut {
    @Test
    public void commonSaveData() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
//risky
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(CustomConditions.jQueryAJAXsCompleted());

        WebElement Input = waitForElementLocatedBy(driver, By.id("postform-text"));
        Input.sendKeys("git config --global user.name  'New Sheriff in Town'"
                + System.lineSeparator() + "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')"
                + System.lineSeparator() + "git push origin master --force");

        WebElement SyntaxDropDown = waitForElementLocatedBy(driver, By.id("select2-postform-format-container"));
        SyntaxDropDown.click();

        WebElement BashChoise = waitForElementLocatedBy(driver, By.xpath("//li[@class='select2-results__option'][text()='Bash']"));
        BashChoise.click();

        WebElement PasteExpDropDown = waitForElementLocatedBy(driver, By.xpath("//*[@id='w0']/div[5]/div[1]/div[2]/div/span/span[1]/span"));
        PasteExpDropDown.click();

        WebElement MinChoise = waitForElementLocatedBy(driver, By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
        MinChoise.click();

        WebElement PasteNameField = waitForElementLocatedBy(driver, By.id("postform-name"));
        PasteNameField.sendKeys("how to gain dominance among developers");

        List<WebElement> createNewBtn = driver.findElements(By.xpath("//button[@class='btn -big']"));
        createNewBtn.get(0).click();

        WebElement actualTitle = waitForElementLocatedBy(driver,By.xpath("//div[@class='info-top']/h1[text()='how to gain dominance among developers']"));
        String expectedTitle = "how to gain dominance among developers";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title name correct");
//
        } else
            System.out.println("Title mismach or not present");
//

        Assert.assertTrue(actualTitle.isDisplayed(), expectedTitle);
        System.out.println("Title = " + actualTitle);




//        WebElement TitleDocumentName = driver.getTitle();
//        TitleDocumentName.submit();

//        public String verifyElementTitle(String locator, String data) {
//            String expectedTxt = data;
//            String actualTxt = getElement(locator).getText();
//            if (actualTxt.equals(expectedTxt)) {
//                System.out.println("Title name present");
//                return Constants.PASS;
//            } else
//                System.out.println("Title mismach or not present");
//            return Constants.FAIL;
//        }

//        WebElement TitleName = driver.getTitle(driver, By.xpath("//div[@class='info-top']/h1[text()='how to gain dominance among developers']"));
//        TitleName.submit();
//
//        System.out.println("Title = ", TitleName.submit());




//div[@class='info-top']/h1[text()='how to gain dominance among developers']


//        List<WebElement> searchBtn = driver.findElements(By.xpath("//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']"));
//        searchBtn.get(0).click();
//        //risky point here
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions
//                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'Organic organic') and contains(.,'selenium') and contains(., 'java')]")));
//
//        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class,'Organic organic') and contains(.,'selenium') and contains(., 'java')]"));
//        System.out.println("Search results number for requested term: " + searchResults.size());
//
//        Assert.assertTrue(searchResults.size()>0,"Search results are empty");

//        driver.quit();

    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}