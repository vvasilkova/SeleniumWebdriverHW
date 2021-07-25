package pageobject_model_pagefactory.page.pagefactory.with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class SeleniumHQHomePagePFAbstractPO extends AbstractPage {

    private static final String HOMEPAGE_URL = "http://yandex.by/";

//    @FindAll({@FindBy(id = "q"), @FindBy(name = "abc")})
//    private WebElement searchInput;

    @FindBy(id = "text")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']")
    private WebElement searchButton;

    public SeleniumHQHomePagePFAbstractPO(WebDriver driver) {
        super(driver);
    }

    public SeleniumHQHomePagePFAbstractPO openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPagePFMixedWithAbstractPO searchForTerms(String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPagePFMixedWithAbstractPO(driver, term);
    }

}
