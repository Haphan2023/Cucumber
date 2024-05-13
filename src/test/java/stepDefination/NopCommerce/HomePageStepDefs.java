package stepDefination.NopCommerce;

import hooks.CucumberHooks;
import org.openqa.selenium.WebDriver;
import pageObjects.NopCommerce.HomePage;
import utilities.ExcelHelpers;

public class HomePageStepDefs {
    WebDriver driver;
    HomePage homePage;
    ExcelHelpers excelHelpers;

    public HomePageStepDefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new pageObjects.NopCommerce.HomePage(driver);
    }
}
