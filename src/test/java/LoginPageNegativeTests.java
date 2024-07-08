import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='enter-link']")));
        homePage.navigateToLogin();
        loginPage.login("!!!bye", "$$$$");
        loginPage.clickLoginSubmitButton();
        boolean errorMessage = loginPage.getErrorMessage();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='enter-link']")));
        homePage.navigateToLogin();
        loginPage.login("", "Qwerty1234");
        loginPage.clickLoginSubmitButton();
        boolean errorMessage = loginPage.getErrorMessage();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='enter-link']")));
        homePage.navigateToLogin();
        loginPage.login("s1nedlab2@gmail.com", "");
        loginPage.clickLoginSubmitButton();
        boolean errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage, "Error message is not displayed.");
    }
}