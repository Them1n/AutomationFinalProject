package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatchesPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[@class='feed-header']")
    private WebElement matchesHeader;

    public MatchesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getMatchesHeader() {
        return matchesHeader.isDisplayed();
    }
}