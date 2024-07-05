package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[@class='feed-header']")
    private WebElement newsHeader;
    @FindBy(xpath = "//h4") // Update the locator to match the first article link
    private WebElement firstArticleLink;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNewsHeader() {
        return newsHeader.getText();
    }

    public void clickFirstArticle() {
        firstArticleLink.click();
    }
}