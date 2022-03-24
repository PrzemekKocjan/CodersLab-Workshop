package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class CreateNewAddressFormPage {
    private static WebDriver driver;

    public CreateNewAddressFormPage(WebDriver driver){

        this.driver = driver;
    }

    public void aliasInput(String alias){
        WebElement aliasFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[1]/div[1]/input"));
        aliasFill.sendKeys(alias);

    }


    public void addressInput(String address){
        WebElement addressFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[6]/div[1]/input"));
        addressFill.sendKeys(address);


    }

    public void cityInput(String city){
        WebElement cityFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[9]/div[1]/input"));
        cityFill.sendKeys(city);

    }


    public void postCodeInput(String postCode){
        WebElement postCodeFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[8]/div[1]/input"));
        postCodeFill.sendKeys(postCode);


    }


    public void countryInput(String country){
        WebElement countryFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[10]/div[1]/select"));
        countryFill.click();
        countryFill.sendKeys(country);
        countryFill.click();

    }


    public void phoneInput(String phone){
        WebElement phoneFill = driver.findElement(By.xpath("//*[@id='content']/div/div/form/section/div[11]/div[1]/input"));
        phoneFill.sendKeys(phone);


    }
     public void saveButton(){
         WebElement saveButton = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
         saveButton.click();
     }
}
