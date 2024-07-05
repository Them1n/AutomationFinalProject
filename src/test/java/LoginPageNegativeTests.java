import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageNegativeTests extends BaseTest {

    @Test
    public void verifyLoginWithInvalidCredentials() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToLogin();
        loginPage.login("!!!bye", "$$$$");
        boolean errorMessage = loginPage.getErrorMessage();
        //Assert.assertEquals(errorMessage, "Неверный логин или пароль");
        Assert.assertTrue(errorMessage, "Error message is not displayed.");
    }

    @Test
    public void verifyLoginWithEmptyUsername() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToLogin();
        loginPage.login("", "Qwerty1234");
        boolean errorMessage = loginPage.getErrorMessage();
        //Assert.assertEquals(errorMessage, "Неверный логин или пароль");
        Assert.assertTrue(errorMessage, "Error message is not displayed.");
    }

    @Test
    public void verifyLoginWithEmptyPassword() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        homePage.navigateToLogin();
        loginPage.login("s1nedlab2@gmail.com", "");
        boolean errorMessage = loginPage.getErrorMessage();
        //Assert.assertEquals(errorMessage, "Неверный логин или пароль");
        Assert.assertTrue(errorMessage, "Error message is not displayed.");
    }
}