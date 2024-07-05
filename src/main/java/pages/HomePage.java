package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//li//a[@href ='https://football.ua/newsarc/']")
    private WebElement newsLink;

    @FindBy(xpath = "//li//a[@href ='https://football.ua/scoreboard/']")
    private WebElement matchesLink;

    @FindBy(xpath = "//li//a[@href ='https://football.ua/video/']")
    private WebElement videosLink;

    @FindBy(xpath = "//li//a[@href ='https://football.ua/galleries/']")
    private WebElement photosLink;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@id='searchInputButton']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='enter-link']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@id='reg-link']")
    private WebElement registerLink;

    @FindBy(xpath = "//li[@class='fb']")
    private WebElement facebookLink;

    @FindBy(xpath = "//li[@class='twitter']")
    private WebElement twitterLink;

    @FindBy(xpath = "//li[@class='rss']")
    private WebElement rssLink;
    @FindBy(xpath = "//svg[@style='position: relative; display: block; width: 100%; height: 100%;']") // //a[@style='position: absolute; display: block; width: 40px; height: 40px; top: -20px; right: -20px; background-color: transparent; cursor: pointer;']//svg
    private WebElement advertisement;

    @FindBy(xpath = "//div[@class=\"grv-dialog-host\"]")
    private WebElement dialogHost;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToNews() {
        newsLink.click();
    }

    public void navigateToMatches() {
        matchesLink.click();
    }


    public void navigateToVideos() {
        videosLink.click();
    }

    public void navigateToPhotos() {
        photosLink.click();
    }

    public void search(String query) {
        searchInput.sendKeys(query);
        searchButton.click();
    }

    public void navigateToLogin() {
        loginLink.click();
    }

    public void navigateToRegister() {
        registerLink.click();
    }

    public void navigateToFacebook() { facebookLink.click(); }

    public void navigateToTwitter() {
        twitterLink.click();
    }

    public void navigateToRss() {
        rssLink.click();
    }

    public void clickToCloseAdvertisement(){ advertisement.click(); }

    public void clickToCloseDialogHostWindow() { dialogHost.click(); }
}