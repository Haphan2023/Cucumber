package pageObjects.SauceLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");

    public void loginToSystem(String userName, String password){
        getElement(userNameInput).sendKeys(userName);
        getElement(passwordInput).sendKeys(password);
        getElement(loginBtn).click();

    }


}
