import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageNegativeTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
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
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
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
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
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