package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInUserPage {
    private static WebDriver driver;

    public LogInUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnSignIn(){
        WebElement signInIcon = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInIcon.click();
    }
    public void insertEmail(String login){
        WebElement insertEmail = driver.findElement(By.xpath("//*[@name='email']"));
        insertEmail.click();
        insertEmail.sendKeys(login);
    }
    public void insertPasswd(String passwd){
        WebElement insertPasswd = driver.findElement(By.xpath("//*[@name='password']"));
        insertPasswd.click();
        insertPasswd.sendKeys(passwd);
    }
    public void clickSignInButton(){
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
}
