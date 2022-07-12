package testClasses;

import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    @Test
    public void loginTest(){
        loginPage.enterEmail("abcd@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();

        String expectedMessage = "Successfully Logged in...!";
        String actualMessage = message.getMessage();

        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
