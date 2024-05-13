package pageObjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By productsNameList = By.xpath("//span[@class='mr-2']//a");
    private By searchBox = By.xpath("//input[@id='searchBox']");
    private By forms = By.xpath("//div[contains(text(), 'Forms')]");
    private By practiceForm = By.xpath("//li[@id='item-0']//span[contains(text(), 'Practice Form')]");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By mobilePhone = By.id("userNumber");
    private By currentAddress = By.id("currentAddress");
    String gender = "//div[@class='custom-control custom-radio custom-control-inline']//label[contains(text(), '%s')]";

    private By dateOfBirthBox = By.xpath("//input[@id='dateOfBirthInput']");
    private By monthOfBirth = By.xpath("//select[@class='react-datepicker__month-select']");
    private By yearOfBirth = By.xpath("//select[@class='react-datepicker__year-select']");

    String dayOfBirth = "//div[@class='react-datepicker__month']//div[@class='react-datepicker__week']//following-sibling::div[text()= '%s']";
    private By subjectsBox = By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']");

    private By uploadPicture = By.xpath("//input[@id='uploadPicture']");
    String hobbiesRadio = "//div[@class='custom-control custom-checkbox custom-control-inline']//label[contains(text(), '%s')]";

    private By submitBtn = By.xpath("//div[@class='text-right col-md-2 col-sm-12']//button[@id='submit']");
    private By inforOfTable = By.xpath("//div[@class='table-responsive']");
    private By subJectsList = By.xpath("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']//div");
    public void getBooks(String textOfBook) {
        getElement(searchBox).sendKeys(textOfBook);
    }


    public List<String> getProductDisplay() {
        List<WebElement> booksList = getElements(productsNameList);
        List<String> booksListText = new ArrayList<>();
        for (WebElement book : booksList) {
            booksListText.add(String.valueOf(book.getSize()));
        }
        for (String book : booksListText) {
            System.out.println(book);
        }

        return booksListText;
    }

    public void clickPracticeForm (){
        getElement(forms).click();
        getElement(practiceForm).click();
    }

    public void inputInformation (String firstNametext, String lastNameText, String emailText, String mobilePhoneNumber, String currentAddressText){
        getElement(firstName).sendKeys(firstNametext);
        getElement(lastName).sendKeys(lastNameText);
        getElement(email).sendKeys(emailText);
        getElement(mobilePhone).sendKeys(mobilePhoneNumber);
        getElement(currentAddress).sendKeys(currentAddressText);
    }

    public void selectGender (String genderText){
        getElementByDynamicLocator(gender, genderText ).click();
    }

    public void dateOfBirth (String month, String year, String day){
        getElement(dateOfBirthBox).click();
        selectElement(monthOfBirth, month);
        selectElement(yearOfBirth, year);
        getElementByDynamicLocator(dayOfBirth, day).click(); //cái này nó k phải thẻ select như dropdown, mà là thẻ div nên sử dụng click
        System.out.println(day);
    }

    public void inputSubjects (String keyword){
        getElement(subjectsBox).click();
        getElement(subjectsBox).sendKeys(keyword);

    }
    public void selectHobbies (String hobbyText){
        getElementByDynamicLocator(hobbiesRadio, hobbyText).click();
    }

    public void clickUploadPicture (String picture){
        getElement(uploadPicture).sendKeys(picture);
    }

    public void clickSubmitBtn (String text){
        executorClickElement(submitBtn, text);
    }
    public boolean verifyInformationOfTable (){
        Assert.assertTrue(getElement(inforOfTable).isDisplayed());
        System.out.println(getElement(inforOfTable).getText());
        return true;
    }
    public void selectSubject(){
        
    }




}

