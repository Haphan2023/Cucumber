package stepDefination.DemoQA;
import hooks.CucumberHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.DemoQA.HomePage;
import utilities.ExcelHelpers;

import java.util.List;

public class HomePageStepdefs {
    WebDriver driver;
    HomePage homePage;
    ExcelHelpers excelHelpers;

    List<String> booksList;
    public HomePageStepdefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new HomePage(driver);
    }
    @Given("there are books named “Learning JavaScript Design Patterns” and “Designing Evolvable Web APIs with ASP.NET”; And the user is on Book Store page")
    public void thereAreBooksNamedLearningJavaScriptDesignPatternsAndDesigningEvolvableWebAPIsWithASPNETAndTheUserIsOnBookStorePage() {

    }

    @When("the user input book name “Design” or “design”") //ĐANG LỖI QUẺ CHI ĐÓ KHÔNG BIẾT
    public void theUserInputBookNameDesignOrDesign() {
        homePage.getBooks("Design");
        booksList = homePage.getProductDisplay();
        Assert.assertListContainsObject(booksList, "Design", "Learning JavaScript Design Patterns"); //đang trả kết quả k đúng
        Assert.assertEquals(homePage.getProductDisplay(),'2');
    }


    @Then("all books match with input criteria will be displayed.")
    public void allBooksMatchWithInputCriteriaWillBeDisplayed() {
    }


    @Given("user is on practice form page")
    public void userIsOnPracticeFormPage() {
        homePage.clickPracticeForm();
    }

    @When("user input all the valid information")
    public void userInputAllTheValidInformation() throws Exception {
        System.out.println(excelHelpers.getCellData("First Name", 1));
        System.out.println(excelHelpers.getCellData("Last Name", 1));
        System.out.println(excelHelpers.getCellData("Email", 1));
        System.out.println(excelHelpers.getCellData("Mobile", 1));
        System.out.println(excelHelpers.getCellData("Current Address", 1));

        String firstName = excelHelpers.getCellData("First Name", 1);
        String lastName = excelHelpers.getCellData("Last Name", 1);
        String email = excelHelpers.getCellData("Email", 1);
        String mobilePhone = excelHelpers.getCellData("Mobile", 1);
        String currentAddress = excelHelpers.getCellData("Current Address", 1);
        homePage.inputInformation(firstName, lastName, email, mobilePhone, currentAddress);
        homePage.selectGender("Female");
        homePage.dateOfBirth("July", "1997", "4"); //đang bị vướng tại day
        homePage.selectHobbies("Music");
        homePage.clickUploadPicture("D:\\MY PICS\\7ac5cd4002c6af98f6d721.jpg");
        homePage.clickSubmitBtn("Submit");
    }

    @Then("user information will be displayed correctly")
    public void userInformationWillBeDisplayedCorrectly() {
        homePage.verifyInformationOfTable();
    }
}
