package pageobject_model_pagefactory.page.pagefactory.without_abstract_page.SearchResultsPagePFMixed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class SeleniumHQHomePagePF {

    private static final String HOMEPAGE_URL = "http://yandex.by/";
    private WebDriver driver;

    @FindBy(id = "text")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']")
    private WebElement searchButton;

    public SeleniumHQHomePagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumHQHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPagePFMixed searchForTerms(String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPagePFMixed(driver, term);
    }

}
