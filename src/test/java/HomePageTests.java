import io.qameta.allure.*;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.ArrayList;

public class HomePageTests extends BaseTest {
    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyHomePageTitle() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Football.ua - Новини футболу - Футбол онлайн - Результати матчів, трансляції — football.ua");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyNavigationToNewsSection() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToNews();
        NewsPage newsPage = new NewsPage(driver);
        Assert.assertEquals(newsPage.getNewsHeader().toUpperCase(), "НОВИНИ УКРАЇНСЬКОГО ТА СВІТОВОГО ФУТБОЛУ");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyNavigationToMatchesSection() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToMatches();
        MatchesPage matchesPage = new MatchesPage(driver);
        Assert.assertTrue(matchesPage.getMatchesHeader());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifySearchFunctionality() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.search("Лига чемпионов");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("search"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyVideosSectionNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToVideos();
        VideosPage videosPage = new VideosPage(driver);
        Assert.assertEquals(videosPage.getVideosHeader().toUpperCase(), "ОГЛЯДИ МАТЧІВ, ВІДЕО ГОЛІВ ТА ПРЯМІ ТРАНСЛЯЦІЇ");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyPhotosSectionNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToPhotos();
        PhotosPage photosPage = new PhotosPage(driver);
        Assert.assertEquals(photosPage.getPhotosHeader().toUpperCase(), "ФОТО: ЯСКРАВІ КАДРИ ТА ГАЛЕРЕЇ З МАТЧІВ ТА ТРЕНУВАНЬ");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyClickingOnNewsArticle() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToNews();
        NewsPage newsPage = new NewsPage(driver);
        newsPage.clickFirstArticle();
        ArticlePage articlePage = new ArticlePage(driver);
        String articleTitle = articlePage.getArticleTitle();
        Assert.assertFalse(articleTitle.isEmpty());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyLoginFunctionality() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.clickOnDisclaimerButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='enter-link']")));
        homePage.navigateToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("s1nedlab2@gmail.com", "Qawsed2410");
        loginPage.clickLoginSubmitButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='user-name']")));
        Assert.assertTrue(loginPage.getUserName());
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
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyFacebookLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToFacebook();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://www.facebook.com/footballua/"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyTwitterLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToTwitter();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://x.com/foot_ua/"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyRssLinkNavigation() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToRss();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://football.ua/rss2.ashx"));
    }
}

