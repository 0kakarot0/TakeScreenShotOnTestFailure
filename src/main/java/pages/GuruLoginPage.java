package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuruLoginPage {
    private WebDriver driver;

    private By email = By.id("email");
    private By password = By.name("passwd");
    private By loginButton = By.id("SubmitLogin");

    public GuruLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String emailString){
        driver.findElement(email).sendKeys(emailString);
    }

    public void enterPassword(String passwordString){
        driver.findElement(email).sendKeys(passwordString);
    }

    public SuccessFullLoginMessage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new SuccessFullLoginMessage(driver);
    }

    public String getTitle(){
         return  driver.getTitle();
    }


}
