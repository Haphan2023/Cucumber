package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    JavascriptExecutor executor = (JavascriptExecutor)driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getElement(By locator){ //tìm element dựa trên locator
        return driver.findElement(locator);
    }
   /* public String getElementText (By locator){
        return getElement(locator).getText();
    }*/

    public void clickElement(By locator){
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
        getElement(locator).click();

    }
    public WebElement getElementByDynamicLocator(String locator, String value){
        return driver.findElement(By.xpath(String.format(locator,value)));
        /*thì bên page phải là private String checkbox = " "
         * public void click checkbo(String checkboxLabel){
         * getElementByDynamicLOcator(checkboxLocator, checkboxLabel).click;
         *
         * Bên Test
         * .clickCHeckbox */
    }

    public void sendKeyToElement ( By locator, String value) {
        getElement(locator).clear();
        getElement(locator).click();
        getElement(locator).sendKeys(value);
    }

    public void selectValueDropDown (By locator, String value ){
        Actions actions = new Actions(driver);

        actions.scrollToElement(getElement(locator));
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public void clickBtnToElement (By locator){
        Actions actions = new Actions(driver);
        actions.scrollToElement(getElement(locator));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
        clickElement(locator);
    }


    public void clickByJS (By locator){
        Actions actions = new Actions(driver);

        actions.scrollToElement(getElement(locator));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
        getElement(locator).click();
        executor.executeScript("arguments[0].click();", locator);
    }
    public String getElementText (By locator){
        Assert.assertTrue(getElement(locator).isDisplayed());
        return  getElement(locator).getText();

    }
    public void waitForElementClickable(By locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
    }

    public boolean isElementDisplayed(By locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
        return getElement(locator).isDisplayed();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void selectElement (By locator, String text){
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);


        /*Select selectDynamicElement =new Select(getElementByDynamicLocator(String.valueOf(locator),text));
        selectDynamicElement.selectByVisibleText(text);*/
    }

    public void executorClickElement(By locator, String text){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(locator);
        executor.executeScript("arguments[0].click();", element);

    }

}


