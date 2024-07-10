
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageNegativeTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyRegistrationWithEmptyUsername() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='reg-link']")));
        homePage.navigateToRegister();
        homePage.navigateToRegister();
        registerPage.register("", "s1nedlab3@gmail.com", "Qwerty1234","Qwerty1234");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Этот логин уже занят");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyRegistrationWithInvalidEmail() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='reg-link']")));
        homePage.navigateToRegister();
        homePage.navigateToRegister();
        registerPage.register("Messi1234", "s1nedlab3", "Qwerty1234","Qwerty1234");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Неправильный Email");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyRegistrationWithShortPassword() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='reg-link']")));
        homePage.navigateToRegister();
        homePage.navigateToRegister();
        registerPage.register("Messi1234", "s1nedlab3@gmail.com", "123", "123");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Короткий или пустой пароль");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denys")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    public void verifyRegistrationWithEmptyFields() {
        homePage.clickToCloseAdvertisement();
        homePage.clickToCloseDialogHostWindow();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='reg-link']")));
        homePage.navigateToRegister();
        homePage.navigateToRegister();
        registerPage.register("", "", "","");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Этот логин уже занят");
    }
}
