package pageObjects.SauceLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.BasePage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By appLogo = By.className("app_logo");
    private By productSortSelect = By.xpath("//select[@class='product_sort_container']");
    private By productNameList = By.xpath("//div[@id='inventory_container' and @class='inventory_container']//div[@class='inventory_item_name']");
    private By productPriceList = By.xpath("//div[@id='inventory_container' and @class='inventory_container']//div[@class='inventory_item_price']");
    //String addToCartBtnOfProduct ="//button[@class='btn_primary btn_inventory']//parent::div[@class='pricebar']//preceding-sibling::div[@class='inventory_item_label']//div[contains(text(), '%s')]";
    String product = "//div[@class='inventory_item_label']//div[contains(text(), '%s')]";
    private By addToCartBtn = By.xpath("//button[@class='btn_primary btn_inventory']");
    private By shoppingCart = By.id("shopping_cart_container");
    private By productDescription = By.xpath("//div[@class='cart_item_label']");
    private By checkoutBtn = By.xpath("//a[@class='btn_action checkout_button']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipcode = By.id("postal-code");
    private By continueBtn = By.xpath("//div[@class='checkout_buttons']//input");
    private By informationInOverviewPage = By.id("checkout_summary_container");
    private By finishBtn = By.xpath("//a[@class='btn_action cart_button']");
    private By orderSuccess = By.xpath("//h2[@class='complete-header']");

    public Boolean isHomePageLogoDisplayed() {
        return isElementDisplayed(appLogo);
    }
    public List<String> getDefaultProductNameList(){
        List<WebElement> productsNameDefaultList = getElements(productNameList);
        List<String> productsNameDefault = new ArrayList<>();
        for (WebElement productPriceDefault : productsNameDefaultList){
            productsNameDefault.add(productPriceDefault.getText());
        }
        return productsNameDefault;
    }
    public List<Double> getSortDefaultPriceProductList (){
        List<WebElement> productsPriceDefaultList = getElements(productPriceList);
        List<Double> productsPriceDefault = new ArrayList<>();

        for (WebElement productPriceDefault : productsPriceDefaultList){
            productsPriceDefault.add(Double.valueOf(productPriceDefault.getText().replace("$", " ")));
        }
        Collections.sort(productsPriceDefault);
        for (Double productPriceDefault: productsPriceDefault){
            System.out.println(productPriceDefault);
        }

        return productsPriceDefault;
    }

    public List<Double> getReverseDefaultPriceProductList (){
        List<WebElement> productsPriceDefaultList = getElements(productPriceList);
        List<Double> productsPriceDefault = new ArrayList<>();

        for (WebElement productPriceDefault : productsPriceDefaultList){
            productsPriceDefault.add(Double.valueOf(productPriceDefault.getText().replace("$", " ")));
        }
        Collections.sort(productsPriceDefault);
        Collections.reverse(productsPriceDefault);
        for (Double productPriceDefault: productsPriceDefault){
            System.out.println(productPriceDefault);
        }

        return productsPriceDefault;
    }
    public void selectSortProduct (String sortProductText){
        Select select = new Select(getElement(productSortSelect));
        select.selectByVisibleText(sortProductText);
    }
    public List<String> productSortZToA (){

        List<WebElement> productsList = getElements(productNameList);

        List<String> productsNameTextZToA = new ArrayList<>();
        for (WebElement productName : productsList){
            productsNameTextZToA.add(productName.getText());
        }
        return productsNameTextZToA;
    }

    public List<String> productSortAToZ(){
        List<WebElement> productsList = getElements(productNameList);
        List<String> productsNameTextAToZ = new ArrayList<>();
        for (WebElement productName : productsList){
            productsNameTextAToZ.add(productName.getText());
        }

        for (String productName : productsNameTextAToZ){
            System.out.println(productName);
        }
        return productsNameTextAToZ;
    }

    public List<Double> sortProductPriceLowToHigh(){
        List<WebElement> productsPriceList = getElements(productPriceList);
        List<Double> productsPriceLowToHigh = new ArrayList<>();
        for (WebElement productPrice : productsPriceList){
            productsPriceLowToHigh.add(Double.valueOf(productPrice.getText().replace("$", " ")));

        }
        for (Double productPrice: productsPriceLowToHigh){
            System.out.println(productPrice);
        }
        return  productsPriceLowToHigh;
    }

    public List<Double> productSortPriceHighToLow(){
        List<WebElement> productsPriceList = getElements(productPriceList);
        List<Double> productsPriceHighToLow = new ArrayList<>();
        for (WebElement productPrice : productsPriceList){
            productsPriceHighToLow.add(Double.valueOf(productPrice.getText().replace("$", " ")));
        }
        for (Double productPrice: productsPriceHighToLow){
            System.out.println(productPrice);
        }
        return productsPriceHighToLow;
    }

    public void clickProduct (String productName){
        getElementByDynamicLocator(product, productName).click();
    }
    public void clickAddToCartBtn (){
        getElement(addToCartBtn).click();
    }
    public void clickCart(){
        getElement(shoppingCart).click();
    }

    public boolean verifyProductInformation(){
        Assert.assertTrue(getElement(productDescription).isDisplayed());
        System.out.println(getElement(productDescription).getText());
        return true;
    }
    public void clickCheckout(){
        getElement(checkoutBtn).click();
    }
    public void inputInformation(String firstnameText, String lastnameText, String zipcodeText){
        getElement(firstName).sendKeys(firstnameText);
        getElement(lastName).sendKeys(lastnameText);
        getElement(zipcode).sendKeys(zipcodeText);
    }
    public void clickContinueBtn (){
        getElement(continueBtn).click();
    }

    public boolean verifyInformationInOverviewPage (){
        Assert.assertTrue(getElement(informationInOverviewPage).isDisplayed());
        System.out.println(getElement(informationInOverviewPage).getText());
        return true;
    }
    public void clickFinishBtn(){
        getElement(finishBtn).click();
    }
    public boolean verifyOrderSuccess (){
        Assert.assertTrue(getElement(orderSuccess).isDisplayed());
        System.out.println(getElement(orderSuccess).getText());
        return true;
    }

}


