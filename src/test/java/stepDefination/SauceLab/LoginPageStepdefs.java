package stepDefination.SauceLab;


import hooks.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.SauceLab.LoginPage;
import utilities.ExcelHelpers;


public class LoginPageStepdefs {
    WebDriver driver;

    LoginPage loginPage;

    ExcelHelpers excelHelpers;

    public LoginPageStepdefs(){
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        loginPage = new LoginPage(driver);
    }
    @Given("user is on login page")
    public void userIsOnLoginPage() {

    }

    @When("user login with valid username and password")
    public void userLoginWithValidUsernameAndPassword() throws Exception {
        System.out.println(excelHelpers);
        System.out.println(excelHelpers.getCellData("username", 1));
        System.out.println(excelHelpers.getCellData("password", 1));
        String username = excelHelpers.getCellData("username", 1);
        String password = excelHelpers.getCellData("password", 1);
        loginPage.loginToSystem(username, password);

    }


    @Given("user login into system")
    public void userLoginIntoSystem() throws Exception {
        String username = excelHelpers.getCellData("User Name", 1);
        String password = excelHelpers.getCellData("Pass Word", 1);
        loginPage.loginToSystem(username, password);
    }
}
