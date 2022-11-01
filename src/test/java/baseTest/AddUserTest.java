package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.HomePage;

public class AddUserTest extends BaseTests{


    @Test(dataProvider = "userData")
    public static void main(String firstName,String lastName, String userName,String password, String email,String cellPhone ){
     AddUserPage addUserTest = homePage.clickAddUser();
     addUserTest.setFirstName(firstName);
     addUserTest.setLastName(lastName);
     addUserTest.setUserName(userName);
     addUserTest.setPassword(password);
     addUserTest.setEmail(email);
     addUserTest.setCellPhone(cellPhone);
     addUserTest.setCompanyA();
     addUserTest.setCompanyB();
     addUserTest.saveButton();
     addUserTest.setRoles();
    }
    @DataProvider
    public Object[][] userData(){
        Object [][] data = new Object[2][6];

        data[0][0] = "FName1"; data[0][1] = "LName1"; data[0][2] = "User1"; data[0][3] = "Pass1"; data[0][4] = "admin@mail.com"; data[0][5] = "082555";
        data[1][0] = "FName2"; data[1][1] = "LName2"; data[1][2] = "User2"; data[1][3] = "Pass2";  data[1][4] = "customer@mail.com"; data[1][5] = "083444";

        return data;
    }

}
