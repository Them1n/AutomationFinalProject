package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password1']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='password2']")
    private WebElement repeatPasswordInput;

    @FindBy(xpath = "//button[@onclick='Login.Register(); return false;']")
    private WebElement registerButton;
    //@FindBy(xpath = "//div[@class='error-message']")
    //private WebElement errorMessage;
    @FindBy(xpath = "//div[@id='register']//p[@class='error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement recaptcha;
    @FindBy(xpath = "//input[@id='agreement']")
    private WebElement agreement;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void register(String username, String email, String password, String repeatPassword) {
        emailInput.sendKeys(email);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(repeatPassword);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickOnRecaptcha(){
        recaptcha.click();
    }

    public void clickOnAgreementState(){ agreement.click(); }

    public void clickOnRegisterButton(){ registerButton.click(); }
}