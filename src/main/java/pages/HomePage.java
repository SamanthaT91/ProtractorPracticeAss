package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public AddUserPage clickAddUser(){
        driver.findElement(By.cssSelector("body > table > thead > tr:nth-child(2) > td > button")).click();
        return new AddUserPage(driver);

    }



}
