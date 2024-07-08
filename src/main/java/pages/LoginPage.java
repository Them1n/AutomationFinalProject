package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "loginemail")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='loginblock']//button[@class='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@id='logincontent']//p[@class='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@class='user-name']")
    private WebElement userName;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }

    public boolean getUserName() { return userName.isDisplayed();}

    public void clickLoginSubmitButton() { loginButton.click(); }
}