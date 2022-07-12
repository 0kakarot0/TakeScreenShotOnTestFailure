package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessFullLoginMessage {
    private WebDriver driver;
    private By getMessage = By.xpath("/html/body/div[4]/div/div/h3");

    public SuccessFullLoginMessage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage(){
        return driver.findElement(getMessage).getText();
    }

}
