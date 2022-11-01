package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
    private static WebDriver driver;

    private By firstName = By.name("FirstName");

    private By lastName = By.name("LastName");
    private By userName = By.name("UserName");
    private By password = By.name("Password");

    private By companyAAA = By.cssSelector("input[type='radio'][value= '15'");
   private By companyBBB = By.cssSelector("input[type='radio'][value= '16'");


    private By email = By.name("Email");
    private By cellPhone = By.name("Mobilephone");
    //private By saveButton = By.cssSelector("body > div.modal.ng-scope > div.modal-footer > button.btn.btn-success");


    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }



    public void setFirstName(String inputName) {
        driver.findElement(firstName).sendKeys(inputName);
    }
    public void setLastName(String inputSurname){
        driver.findElement(lastName).sendKeys(inputSurname);
    }
    public void setUserName(String inputUsername){
        driver.findElement(userName).sendKeys(inputUsername);
    }
    public void setPassword(String inputPassword){
        driver.findElement(password).sendKeys(inputPassword);
    }

    public void setCompanyA ()
    {
        driver.findElement (companyAAA).click();
    }

    public void setCompanyB()
    {
        driver.findElement (companyBBB).click();
    }



    public void setRoles (){
        Select roleIdDropDown = new Select(driver.findElement(By.name("RoleId")));
        roleIdDropDown.selectByValue("2");
        roleIdDropDown.selectByValue("1");
    }
    public void setEmail(String inputEmail){
        driver.findElement(email).sendKeys(inputEmail);
    }
    public void setCellPhone(String inputCellPhone){
        driver.findElement(cellPhone).sendKeys(inputCellPhone);
    }

    public HomePage saveButton(){
        driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-footer > button.btn.btn-success")).click();
        return new HomePage(driver);

    }

}
