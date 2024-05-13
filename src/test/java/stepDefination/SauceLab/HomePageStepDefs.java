package stepDefination.SauceLab;
import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.SauceLab.HomePage;
import utilities.ExcelHelpers;

import java.util.List;


public class HomePageStepDefs {
    WebDriver driver;
    HomePage homePage;
    ExcelHelpers excelHelpers;
    List<String> defaultNameProductList;
    List<String> listNameTextAfterSort;

    List<Double> defaultList;
    List<Double> listAfterSort;

    /*String firstName = "Ha";
    String lastName = "Phan";
    String zip = "8787";*/


    public HomePageStepDefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new HomePage(driver);
    }

    @Then("user can go to home page successfully")
    public void userCanGoToHomePageSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
    }


    @When("user choose sort name Z to A")
    public void userChooseSortNameZToA() {
        defaultNameProductList = homePage.getDefaultProductNameList();
        homePage.selectSortProduct("Name (Z to A)");
    }

    @Then("products will be sorted by Z to A")
    public void productsWillBeSortedByZToZA() {
        listNameTextAfterSort = homePage.productSortZToA();
        Assert.assertEquals(listAfterSort, defaultList);
    }

    @When("user choose sort name A to Z")
    public void userChooseSortNameAToZ() {
        defaultNameProductList = homePage.getDefaultProductNameList();
        homePage.selectSortProduct("Name (A to Z)"); //sửa lại chỗ select này bên HomePage
    }

    @Then("products will be sorted by A to Z")
    public void productsWillBeSortedByAToZ() {
        listNameTextAfterSort = homePage.productSortAToZ();
        Assert.assertEquals(listAfterSort, defaultList);
    }

    @When("user choose sort price Low to High") //ĐANG VERIFY SAI GIÁ
    public void userChooseSortPriceLowToHigh() {
        defaultList = homePage.getSortDefaultPriceProductList();
        homePage.selectSortProduct("Price (low to high)");
    }

    @Then("products will be sorted by Low to High")
    public void productsWillBeSortedByLowToHigh() {
        listAfterSort = homePage.sortProductPriceLowToHigh();
        Assert.assertEquals(listAfterSort, defaultList);
    }

    @When("user choose sort price High to Low") //verify sai giá
    public void userChooseSortPriceHighToLow() {
        defaultList = homePage.getReverseDefaultPriceProductList();

        homePage.selectSortProduct("Price (high to low)");
    }

    @Then("products will be sorted by High to Low")
    public void productsWillBeSortedByHighToLow() {
        listAfterSort = homePage.productSortPriceHighToLow();
        Assert.assertEquals(listAfterSort , defaultList);
    }

    @When("user add Sauce Labs Backpack to cart")
    public void userAddSauceLabsBackpackToCart() {
        homePage.clickProduct("Sauce Labs Backpack");
        homePage.clickAddToCartBtn();
    }

   @Then("go to cart page and verify product information")
    public void goToCartPageAndVerifyProductInformation() {
        homePage.clickCart();
        homePage.verifyProductInformation();
    }

    @Then("user go to checkout")
    public void userGoToCheckout() {
        homePage.clickCheckout();
    }

   @And("user input information and continue")
    public void userInputInformationAndContinue() throws Exception {
        System.out.println(excelHelpers);
        System.out.println(excelHelpers.getCellData("First Name", 1));
        System.out.println(excelHelpers.getCellData("Last Name", 1));
        System.out.println(excelHelpers.getCellData("Zip Code", 1));

        String firstName =excelHelpers.getCellData("First Name", 1);
        String lastName = excelHelpers.getCellData("Last Name", 1);
        String zip = excelHelpers.getCellData("Zip Code", 1);
        homePage.inputInformation(firstName, lastName, zip);
        homePage.clickContinueBtn();
    }

   @Then("verify product information in overview page")
    public void verifyProductInformationInOverviewPage() {
        homePage.verifyInformationInOverviewPage();
    }

    @Then("verify order product successfully")
    public void verifyOrderProductSuccessfully() {
        homePage.clickFinishBtn();
        homePage.verifyOrderSuccess();
    }
}
