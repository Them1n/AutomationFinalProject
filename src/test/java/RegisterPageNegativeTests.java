import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterPageNegativeTests extends BaseTest {

    @Test
    public void verifyRegistrationWithEmptyUsername() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToRegister();
        registerPage.register("", "s1nedlab3@gmail.com", "Qwerty1234","Qwerty1234");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Этот логин уже занят");
    }

    @Test
    public void verifyRegistrationWithInvalidEmail() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToRegister();
        registerPage.register("Messi1234", "s1nedlab3", "Qwerty1234","Qwerty1234");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Неправильный Email");
    }

    @Test
    public void verifyRegistrationWithShortPassword() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToRegister();
        registerPage.register("Messi1234", "s1nedlab3@gmail.com", "123", "123");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Короткий или пустой пароль");
    }

    @Test
    public void verifyRegistrationWithEmptyFields() {
        homePage.clickToCloseAdvertisement();
        homePage.navigateToRegister();
        registerPage.register("", "", "","");
        registerPage.clickOnAgreementState();
        registerPage.clickOnRegisterButton();
        String errorMessage = registerPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Этот логин уже занят");
    }
}
