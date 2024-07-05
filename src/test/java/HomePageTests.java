import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;

public class HomePageTests extends BaseTest {
    @Test
    public void verifyHomePageTitle() {
        homePage.clickToCloseAdvertisement();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Football.ua - Новини футболу - Футбол онлайн - Результати матчів, трансляції — football.ua");
    }

    @Test
    public void verifyNavigationToNewsSection() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToNews();
        NewsPage newsPage = new NewsPage(driver);
        Assert.assertEquals(newsPage.getNewsHeader().toUpperCase(), "НОВИНИ УКРАЇНСЬКОГО ТА СВІТОВОГО ФУТБОЛУ");
    }

    @Test
    public void verifyNavigationToMatchesSection() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToMatches();
        MatchesPage matchesPage = new MatchesPage(driver);
        Assert.assertTrue(matchesPage.getMatchesHeader());
    }

    @Test
    public void verifySearchFunctionality() {
        homePage.clickToCloseAdvertisement();
        homePage.search("Лига чемпионов");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("search"));
    }

    @Test
    public void verifyVideosSectionNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToVideos();
        VideosPage videosPage = new VideosPage(driver);
        Assert.assertEquals(videosPage.getVideosHeader().toUpperCase(), "ОГЛЯДИ МАТЧІВ, ВІДЕО ГОЛІВ ТА ПРЯМІ ТРАНСЛЯЦІЇ");
    }

    @Test
    public void verifyPhotosSectionNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToPhotos();
        PhotosPage photosPage = new PhotosPage(driver);
        Assert.assertEquals(photosPage.getPhotosHeader().toUpperCase(), "ФОТО: ЯСКРАВІ КАДРИ ТА ГАЛЕРЕЇ З МАТЧІВ ТА ТРЕНУВАНЬ");
    }

    @Test
    public void verifyClickingOnNewsArticle() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToNews();
        NewsPage newsPage = new NewsPage(driver);
        newsPage.clickFirstArticle();
        ArticlePage articlePage = new ArticlePage(driver);
        String articleTitle = articlePage.getArticleTitle();
        Assert.assertFalse(articleTitle.isEmpty());
    }

    @Test
    public void verifyLoginFunctionality() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("s1nedlab2@gmail.com", "Qawsed2410");
        homePage.clickToCloseAdvertisement();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='user-name']")).isDisplayed());
    }

   // @Test
    //public void verifyRegistrationFunctionality() {
        //homePage.clickToCloseAdvertisement();
       // homePage.navigateToRegister();
        //RegisterPage registerPage = new RegisterPage(driver);
        //registerPage.register("newuser111", "s1nedlab2@gmail.com", "qawsed2410","qawsed2410");
       // registerPage.clickOnAgreementState();
       // registerPage.clickOnRecaptcha();
       // String currentUrl = driver.getCurrentUrl();
       // Assert.assertEquals(currentUrl, "https://football.ua/");  // //span[@id='ui-id-1'] - successful registration massage
   // }

    @Test
    public void verifyFacebookLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToFacebook();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://www.facebook.com/footballua/"));
    }

    @Test
    public void verifyTwitterLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToTwitter();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://x.com/foot_ua/"));
    }

    @Test
    public void verifyRssLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToRss();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://football.ua/rss2.ashx"));
    }
}

