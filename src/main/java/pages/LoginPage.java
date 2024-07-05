package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='loginemail']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='loginblock']//button[@class='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@id='logincontent']//p[@class='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }
}