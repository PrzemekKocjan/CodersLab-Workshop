package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private static WebDriver driver;

    public MyAccountPage(WebDriver driver){

        this.driver = driver;
    }
    public void AddFirstAddressTile(){
        WebElement addAddressTile = driver.findElement(By.xpath("//*[@id='address-link']"));
        addAddressTile.click();
    }

    public String getAddressFieldBox(){
        WebElement addressFormBox = driver.findElement(By.xpath("//div[@class='address-body']"));
        return addressFormBox.getText();
    }
    public String getDeliveryAddress(){
        WebElement deliveryAddress = driver.findElement(By.id("id-address-delivery-address-21747"));
        return deliveryAddress.getText();
    }

    public void insertSearchField(){
        WebElement searchField = driver.findElement(By.xpath("//*[@id='search_widget']/form/input[2]"));
        searchField.click();
        searchField.sendKeys("Hummingbird Printed Sweater");
        searchField.submit();
    }


}
